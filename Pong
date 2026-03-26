import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PongGame extends JPanel implements ActionListener, KeyListener {

    // Ventana
    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    // Palas
    Rectangle player1;
    Rectangle player2;
    int paddleWidth = 10;
    int paddleHeight = 100;
    int paddleSpeed = 6;

    // Pelota
    Rectangle ball;
    int ballSize = 15;
    int ballXSpeed = 4;
    int ballYSpeed = 4;

    // Puntuación
    int score1 = 0;
    int score2 = 0;

    // Control
    boolean wPressed, sPressed, upPressed, downPressed;

    Timer timer;

    public PongGame() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        initGame();

        timer = new Timer(16, this); // ~60 FPS
        timer.start();
    }

    private void initGame() {
        player1 = new Rectangle(30, HEIGHT / 2 - paddleHeight / 2, paddleWidth, paddleHeight);
        player2 = new Rectangle(WIDTH - 40, HEIGHT / 2 - paddleHeight / 2, paddleWidth, paddleHeight);
        ball = new Rectangle(WIDTH / 2, HEIGHT / 2, ballSize, ballSize);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        movePaddles();
        moveBall();
        checkCollision();
        repaint();
    }

    private void movePaddles() {
        if (wPressed && player1.y > 0) {
            player1.y -= paddleSpeed;
        }
        if (sPressed && player1.y < HEIGHT - paddleHeight) {
            player1.y += paddleSpeed;
        }
        if (upPressed && player2.y > 0) {
            player2.y -= paddleSpeed;
        }
        if (downPressed && player2.y < HEIGHT - paddleHeight) {
            player2.y += paddleSpeed;
        }
    }

    private void moveBall() {
        ball.x += ballXSpeed;
        ball.y += ballYSpeed;

        // Rebote arriba/abajo
        if (ball.y <= 0 || ball.y >= HEIGHT - ballSize) {
            ballYSpeed = -ballYSpeed;
        }

        // Punto para jugador 2
        if (ball.x <= 0) {
            score2++;
            resetBall();
        }

        // Punto para jugador 1
        if (ball.x >= WIDTH - ballSize) {
            score1++;
            resetBall();
        }
    }

    private void checkCollision() {
        if (ball.intersects(player1) || ball.intersects(player2)) {
            ballXSpeed = -ballXSpeed;
        }
    }

    private void resetBall() {
        ball.x = WIDTH / 2;
        ball.y = HEIGHT / 2;
        ballXSpeed = -ballXSpeed;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);

        // Dibujar palas
        g.fillRect(player1.x, player1.y, player1.width, player1.height);
        g.fillRect(player2.x, player2.y, player2.width, player2.height);

        // Dibujar pelota
        g.fillOval(ball.x, ball.y, ball.width, ball.height);

        // Dibujar línea central
        for (int i = 0; i < HEIGHT; i += 30) {
            g.fillRect(WIDTH / 2 - 2, i, 4, 20);
        }

        // Dibujar puntuación
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString(String.valueOf(score1), WIDTH / 4, 50);
        g.drawString(String.valueOf(score2), WIDTH * 3 / 4, 50);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> wPressed = true;
            case KeyEvent.VK_S -> sPressed = true;
            case KeyEvent.VK_UP -> upPressed = true;
            case KeyEvent.VK_DOWN -> downPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> wPressed = false;
            case KeyEvent.VK_S -> sPressed = false;
            case KeyEvent.VK_UP -> upPressed = false;
            case KeyEvent.VK_DOWN -> downPressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong en Java");
        PongGame game = new PongGame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
