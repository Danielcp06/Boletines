import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable {

    // --- 1. CONSTANTES DEL JUEGO ---
    final int SCREEN_WIDTH = 800;
    final int SCREEN_HEIGHT = 400;
    final int FPS = 60;
    final int GROUND_Y = SCREEN_HEIGHT - 40; // Coordenada Y del suelo (360)

    // --- 2. OBJETOS Y CONTROL ---
    Thread gameThread;
    KeyHandler keyHandler = new KeyHandler();
    Player player;
    List<Obstacle> obstacles = new ArrayList<>();
    Random random = new Random();

    // --- 3. ESTADO DEL JUEGO ---
    public boolean running = true;
    public boolean gameOver = false;
    public boolean gameWon = false;
    private long lastObstacleTime = System.currentTimeMillis();

    // --- 4. CONTROL DE PROGRESO ---
    public final int gameDurationSeconds = 30; // El juego dura 30 segundos
    private long timeStart;
    private float progressPercent = 0.0f;

    // Constructor: Configura la ventana y los objetos
    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.CYAN);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);

        player = new Player(50, GROUND_Y);
        timeStart = System.currentTimeMillis();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    // --- 5. BUCLE DEL JUEGO (Game Loop) ---
    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null && running) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    // --- 6. LÓGICA DE JUEGO Y FÍSICA (Update) ---
    public void update() {
        if (gameOver || gameWon) return;

        // 1. Mover el jugador
        if (keyHandler.spacePressed) {
            player.jump();
        }
        player.update();

        // 2. Control de Progreso y Victoria
        long timeElapsed = System.currentTimeMillis() - timeStart;
        float progress = (float)timeElapsed / (gameDurationSeconds * 1000f);
        progressPercent = Math.min(1.0f, progress);

        if (progressPercent >= 1.0f) {
            gameWon = true;
            running = false;
        }

        // 3. Mover obstáculos y gestionar el spawn
        updateObstacles();

        // 4. Colisión
        checkCollision();
    }

    private void updateObstacles() {
        long timeNow = System.currentTimeMillis();

        if (timeNow - lastObstacleTime > (random.nextInt(1500) + 1500)) {

            Obstacle.Type[] types = Obstacle.Type.values();
            Obstacle.Type randomType = types[random.nextInt(types.length)];

            // Ajuste: Plataformas se generan más arriba
            int yPos = GROUND_Y;
            if (randomType == Obstacle.Type.PLATFORM) {
                yPos = GROUND_Y - random.nextInt(80) - 50;
            }

            obstacles.add(new Obstacle(SCREEN_WIDTH, yPos, randomType));
            lastObstacleTime = timeNow;
        }

        // Mover y limpiar obstáculos
        for (int i = 0; i < obstacles.size(); i++) {
            Obstacle obs = obstacles.get(i);
            obs.update();

            if (obs.isOffScreen()) {
                obstacles.remove(i);
                i--;
            }
        }
    }

    // --- 7. DETECCIÓN DE COLISIONES (Soporte y Letal) ---
    private void checkCollision() {

        // Asumimos que no está en el suelo, hasta que se demuestre lo contrario (Player.update() lo fija al suelo fijo)

        for (Obstacle obs : obstacles) {

            if (player.hitBox.intersects(obs.hitBox)) {

                if (obs.type != Obstacle.Type.PLATFORM) {
                    // --- Colisión LETAL ---
                    gameOver = true;
                    running = false;
                    return;
                } else {
                    // --- Colisión de SOPORTE (PLATFORM) ---
                    // Aterrizaje: Chequea si el jugador estaba justo encima antes de este frame
                    if (player.yVelocity >= 0 && (player.y + player.SIZE - player.yVelocity) < obs.y) {

                        player.yVelocity = 0;
                        player.y = obs.y - player.SIZE;
                        player.isGrounded = true;

                        // Mover al jugador con la plataforma
                        player.x += obs.X_SPEED;
                    }
                }
            }
        }
    }

    // --- 8. RENDERIZADO (Dibujo) ---
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        // Activa el suavizado de bordes (Anti-aliasing)
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibujar el suelo
        g2.setColor(new Color(150, 75, 0));
        g2.fillRect(0, GROUND_Y, SCREEN_WIDTH, SCREEN_HEIGHT - GROUND_Y);

        drawProgressBar(g2);

        player.draw(g2);

        for (Obstacle obs : obstacles) {
            obs.draw(g2);
        }

        // Mensajes de Estado Final
        if (gameOver) {
            g2.setColor(Color.BLACK);
            g2.setFont(new Font("Arial", Font.BOLD, 50));
            g2.drawString("GAME OVER", SCREEN_WIDTH / 2 - 150, SCREEN_HEIGHT / 2);
        } else if (gameWon) {
            g2.setColor(Color.BLUE);
            g2.setFont(new Font("Arial", Font.BOLD, 50));
            g2.drawString("¡GANASTE!", SCREEN_WIDTH / 2 - 120, SCREEN_HEIGHT / 2);
        }

        g2.dispose();
    }

    private void drawProgressBar(Graphics2D g2) {
        final int BAR_WIDTH = SCREEN_WIDTH - 40;
        final int BAR_HEIGHT = 20;
        final int BAR_X = 20;
        final int BAR_Y = 10;

        // Fondo y borde
        g2.setColor(Color.LIGHT_GRAY);
        g2.fillRect(BAR_X, BAR_Y, BAR_WIDTH, BAR_HEIGHT);
        g2.setColor(Color.BLACK);
        g2.drawRect(BAR_X, BAR_Y, BAR_WIDTH, BAR_HEIGHT);

        // Relleno
        int fillWidth = (int)(BAR_WIDTH * progressPercent);
        g2.setColor(Color.ORANGE);
        g2.fillRect(BAR_X, BAR_Y, fillWidth, BAR_HEIGHT);

        // Texto
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arial", Font.PLAIN, 14));
        int percentValue = (int)(progressPercent * 100);
        g2.drawString("Progreso: " + percentValue + "%", BAR_X + 5, BAR_Y + 15);
    }
}