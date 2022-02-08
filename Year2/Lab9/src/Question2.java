import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Question2 extends JFrame implements KeyListener {

    private Canvas canvas;

    public Question2() {
        this.setSize(500, 500);
        this.setTitle("WASD Movement");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addKeyListener(this);

        this.canvas = new Canvas();
    }

    public void init() {
        this.add(canvas);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        // W - 87
        // A - 65
        // S - 83
        // D - 68
        if (e.getKeyCode() == 87)
            canvas.moveUp();
        else if (e.getKeyCode() == 65)
            canvas.moveLeft();
        else if (e.getKeyCode() == 83)
            canvas.moveDown();
        else if (e.getKeyCode() == 68)
            canvas.moveRight();
    }

    class Canvas extends JPanel {

        private int xPosition, yPosition, xStep, yStep;

        public Canvas() {
            xPosition = 30;
            yPosition = 20;
            xStep = 50;
            yStep = 50;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawShapes(g);
        }

        public void drawShapes(Graphics g) {
            Graphics2D graphics2D = (Graphics2D) g;

            RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

            graphics2D.setRenderingHints(renderingHints);
            graphics2D.setPaint(Color.red);
            graphics2D.fillOval(xPosition, yPosition, 50, 50);

        }

        public void moveUp() {
            yPosition -= yStep;
            repaint();
        }

        public void moveDown() {
            yPosition += yStep;
            repaint();
        }

        public void moveLeft() {
            xPosition -= xStep;
            repaint();
        }

        public void moveRight() {
            xPosition += xStep;
            repaint();
        }
    }

    public static void main(String[] args) {
        new Question2().init();
    }
}
