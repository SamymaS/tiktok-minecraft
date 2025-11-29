import express from 'express';
import { WebSocketServer } from 'ws';
import http from 'http';
import cors from 'cors';
import dotenv from 'dotenv';
import { fileURLToPath } from 'url';
import { dirname, join } from 'path';

dotenv.config();

const __filename = fileURLToPath(import.meta.url);
const __dirname = dirname(__filename);

const app = express();
const server = http.createServer(app);
const wss = new WebSocketServer({ port: process.env.WEBSOCKET_PORT || 3001 });

app.use(cors());
app.use(express.json());

// Stockage des clients WebSocket connectés (Minecraft)
const minecraftClients = new Set();

// WebSocket pour communication avec Minecraft
wss.on('connection', (ws) => {
  console.log('✅ Client Minecraft connecté');
  minecraftClients.add(ws);

  ws.on('close', () => {
    console.log('❌ Client Minecraft déconnecté');
    minecraftClients.delete(ws);
  });

  ws.on('error', (error) => {
    console.error('Erreur WebSocket:', error);
  });

  // Envoi d'un message de bienvenue
  ws.send(JSON.stringify({
    type: 'connection',
    message: 'Connecté au serveur TikTok Live'
  }));
});

// Fonction pour envoyer un événement à tous les clients Minecraft
function broadcastToMinecraft(event) {
  const message = JSON.stringify(event);
  minecraftClients.forEach((client) => {
    if (client.readyState === 1) { // WebSocket.OPEN
      client.send(message);
    }
  });
}

// Webhook endpoint pour recevoir les événements TikTok Live
app.post('/webhook/tiktok', (req, res) => {
  const event = req.body;
  console.log('📥 Événement TikTok reçu:', event);

  // Vérification de la signature (à implémenter selon la doc TikTok)
  // Pour l'instant, on accepte tous les événements

  // Traitement des différents types d'événements
  let minecraftEvent = null;

  switch (event.event_type) {
    case 'gift':
      minecraftEvent = {
        type: 'gift',
        giftName: event.gift?.gift_name || 'Cadeau',
        giftValue: event.gift?.gift_value || 0,
        sender: event.user?.unique_id || 'Anonyme',
        timestamp: Date.now()
      };
      break;

    case 'donation':
      minecraftEvent = {
        type: 'donation',
        amount: event.donation?.amount || 0,
        currency: event.donation?.currency || 'USD',
        sender: event.user?.unique_id || 'Anonyme',
        message: event.donation?.message || '',
        timestamp: Date.now()
      };
      break;

    case 'like':
      minecraftEvent = {
        type: 'like',
        count: event.like_count || 1,
        sender: event.user?.unique_id || 'Anonyme',
        timestamp: Date.now()
      };
      break;

    case 'comment':
      minecraftEvent = {
        type: 'comment',
        text: event.comment?.text || '',
        sender: event.user?.unique_id || 'Anonyme',
        timestamp: Date.now()
      };
      break;

    case 'follow':
      minecraftEvent = {
        type: 'follow',
        sender: event.user?.unique_id || 'Anonyme',
        timestamp: Date.now()
      };
      break;

    default:
      console.log('Type d\'événement non géré:', event.event_type);
  }

  if (minecraftEvent) {
    console.log('🎮 Envoi de l\'événement à Minecraft:', minecraftEvent);
    broadcastToMinecraft(minecraftEvent);
  }

  res.status(200).json({ success: true });
});

// Endpoint pour tester la connexion
app.get('/health', (req, res) => {
  res.json({
    status: 'ok',
    connectedClients: minecraftClients.size,
    timestamp: new Date().toISOString()
  });
});

// Endpoint pour envoyer un événement de test
app.post('/test/event', (req, res) => {
  const testEvent = {
    type: 'test',
    message: 'Événement de test',
    timestamp: Date.now()
  };
  
  console.log('🧪 Envoi d\'un événement de test');
  broadcastToMinecraft(testEvent);
  
  res.json({ success: true, event: testEvent });
});

// Page de statut
app.get('/', (req, res) => {
  res.send(`
    <html>
      <head>
        <title>TikTok → Minecraft Bridge</title>
        <style>
          body { font-family: Arial, sans-serif; padding: 20px; background: #1a1a1a; color: #fff; }
          .status { background: #2a2a2a; padding: 20px; border-radius: 8px; margin: 10px 0; }
          .connected { color: #4caf50; }
          .disconnected { color: #f44336; }
        </style>
      </head>
      <body>
        <h1>🎮 TikTok → Minecraft Bridge</h1>
        <div class="status">
          <h2>Statut du serveur</h2>
          <p>Clients Minecraft connectés: <span class="${minecraftClients.size > 0 ? 'connected' : 'disconnected'}">${minecraftClients.size}</span></p>
          <p>Port WebSocket: ${process.env.WEBSOCKET_PORT || 3001}</p>
          <p>Port HTTP: ${process.env.PORT || 3000}</p>
        </div>
        <div class="status">
          <h2>Endpoints</h2>
          <ul>
            <li><code>POST /webhook/tiktok</code> - Webhook pour les événements TikTok</li>
            <li><code>GET /health</code> - Statut du serveur</li>
            <li><code>POST /test/event</code> - Envoyer un événement de test</li>
          </ul>
        </div>
      </body>
    </html>
  `);
});

const PORT = process.env.PORT || 3000;
server.listen(PORT, () => {
  console.log(`🚀 Serveur démarré sur le port ${PORT}`);
  console.log(`🔌 WebSocket disponible sur le port ${process.env.WEBSOCKET_PORT || 3001}`);
  console.log(`📡 Webhook TikTok: http://localhost:${PORT}/webhook/tiktok`);
});


