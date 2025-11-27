import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player {

    public int x;
    public int y;
    public final int SIZE = 40;

    public double yVelocity = 0;
    public final double GRAVITY = 0.5;
    public final double JUMP_STRENGTH = -10.0;

    public Rectangle hitBox;

    private final int GROUND_LEVEL_Y = 360;

    public boolean isGrounded = true; // <<< NUEVA VARIABLE: Indica si está en el suelo o en plataforma

    public Player(int startX, int startY) {
        this.x = startX;
        this.y = GROUND_LEVEL_Y - SIZE;
        this.hitBox = new Rectangle(x, y, SIZE, SIZE);
    }

    public void update() {
        // 1. Aplicar la gravedad (solo si no está en el suelo/plataforma)
        if (!isGrounded) {
            yVelocity += GRAVITY;
        }
        y += yVelocity;

        // 2. Comprobar el suelo fijo: El GamePanel se encargará de las plataformas.
        if (y >= GROUND_LEVEL_Y - SIZE) {
            y = GROUND_LEVEL_Y - SIZE;
            yVelocity = 0;
            isGrounded = true; // El suelo fijo siempre es seguro
        } else {
            isGrounded = false; // Si no toca el suelo fijo, no está garantizado que esté en el suelo
        }

        // 3. Actualizar la posición del HitBox
        hitBox.setLocation(x, y);
    }

    public void jump() {
        // Solo puede saltar si isGrounded es true
        if (isGrounded) {
            yVelocity = JUMP_STRENGTH;
            isGrounded = false; // Ya no está en el suelo
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, SIZE, SIZE);
    }
}