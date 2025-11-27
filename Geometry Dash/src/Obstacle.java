import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class Obstacle {

    // Enumeración de tipos de obstáculos
    public enum Type {
        LOW_SPIKE,      // Peligro
        BLOCK,          // Peligro
        HIGH_WALL,      // Peligro
        PLATFORM        // Soporte
    }

    // --- Propiedades ---
    public int x;
    public int y;
    public int WIDTH;
    public int HEIGHT;
    public final int X_SPEED = -5; // Velocidad horizontal
    public Rectangle hitBox;
    public Type type;

    // Constructor: 3 argumentos
    public Obstacle(int startX, int groundY, Type type) {
        this.x = startX;
        this.type = type;

        // 1. Definir dimensiones basado en el tipo
        switch (type) {
            case LOW_SPIKE:
                WIDTH = 30;
                HEIGHT = 40;
                break;
            case BLOCK:
                WIDTH = 60;
                HEIGHT = 40;
                break;
            case HIGH_WALL:
                WIDTH = 30;
                HEIGHT = 80;
                break;
            case PLATFORM:
                WIDTH = 100;
                HEIGHT = 20;
                break;
        }

        // 2. Calcular Y para que la base quede en el nivel deseado
        // groundY es la altura del suelo fijo, pero lo usamos como referencia de generación.
        this.y = groundY - HEIGHT;
        this.hitBox = new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public void update() {
        x += X_SPEED;
        hitBox.setLocation(x, y);
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;

        switch (type) {
            case LOW_SPIKE:
                // --- Pincho triangular ---
                g2.setColor(Color.GREEN.darker());

                int[] xPoints = {x, x + WIDTH, x + WIDTH / 2};
                int[] yPoints = {y + HEIGHT, y + HEIGHT, y};

                g2.fillPolygon(xPoints, yPoints, 3);
                break;

            case BLOCK:
                // --- Bloque con sombra ---
                g2.setColor(Color.BLUE);
                g2.fillRect(x, y, WIDTH, HEIGHT);

                g2.setColor(Color.BLUE.darker().darker());
                g2.fillRect(x + WIDTH - 5, y + 5, 5, HEIGHT - 5);
                g2.fillRect(x + 5, y + HEIGHT - 5, WIDTH - 5, 5);
                break;

            case HIGH_WALL:
                // --- Pared alta con sombra ---
                g2.setColor(Color.MAGENTA);
                g2.fillRect(x, y, WIDTH, HEIGHT);

                g2.setColor(Color.MAGENTA.darker().darker());
                g2.fillRect(x + WIDTH - 5, y + 5, 5, HEIGHT - 5);
                g2.fillRect(x + 5, y + HEIGHT - 5, WIDTH - 5, 5);
                break;

            case PLATFORM:
                // --- Plataforma simple ---
                g2.setColor(Color.ORANGE.darker());
                g2.fillRect(x, y, WIDTH, HEIGHT);
                break;
        }
    }

    public boolean isOffScreen() {
        return x + WIDTH < 0;
    }
}