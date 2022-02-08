import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Question3 extends JFrame implements KeyListener {

    private JLabel label;
    private Canvas canvas;

    public Question3() {
        this.setSize(500, 500);
        this.setTitle("WASD Movement");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addKeyListener(this);
        this.setLayout(new BorderLayout());

        this.canvas = new Canvas();
        this.label = new JLabel("Shapes Remaining:" + canvas.getNumberOfShapes());
        this.label.setFont(new Font("Monospaced", Font.BOLD, 20));
    }

    public void init() {
        this.add(label, BorderLayout.NORTH);
        this.add(canvas, BorderLayout.CENTER);
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
        // Space - 32
        if (e.getKeyCode() == 87)
            this.canvas.moveUp();
        else if (e.getKeyCode() == 65)
            this.canvas.moveLeft();
        else if (e.getKeyCode() == 83)
            this.canvas.moveDown();
        else if (e.getKeyCode() == 68)
            this.canvas.moveRight();
        else if (e.getKeyCode() == 32) {
            this.canvas.checkPlayerPosition();
            this.label.setText("Shapes Remaining: " + this.canvas.getShapesRemaining());
        }
    }

    class Canvas extends JPanel {

        private final int numberOfShapes;
        private ArrayList<Shape> shapes;

        private Shape player;
        private int xPosition, yPosition, xStep, yStep;

        public Canvas() {
            this.setBackground(Color.lightGray);

            this.player = new Rectangle(xPosition, yPosition, 50, 50);
            this.xPosition = 30;
            this.yPosition = 20;
            this.xStep = 20;
            this.yStep = 20;


            this.numberOfShapes = 30;
            this.shapes = new ArrayList<>();
            generateShapes();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawPlayer(g);
            drawShapes(g);
        }

        public void drawPlayer(Graphics g) {
            Graphics2D graphics2D = (Graphics2D) g;

            RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

            graphics2D.setRenderingHints(renderingHints);
            graphics2D.setPaint(Color.red);

            player = new Rectangle(xPosition, yPosition, 40, 40);
            graphics2D.fill(player);
            graphics2D.draw(player);
        }

        public void drawShapes(Graphics g) {
            Graphics2D graphics2D = (Graphics2D) g;
            graphics2D.setColor(Color.blue);

            for (Shape shape : shapes) {
                graphics2D.fill(shape);
                graphics2D.draw(shape);
            }
        }

        private void generateShapes() {
            for (int i = 0; i < numberOfShapes; i++) {
                Rectangle rectangle = new Rectangle(randomPosition(), randomPosition(), 10, 10);
                this.shapes.add(rectangle);
            }
        }

        private int randomPosition() {
            return (int) (Math.random() * 400);
        }

        public void checkPlayerPosition() {
            for (int i = 0; i < shapes.size(); i++) {
                if (player.contains((Rectangle)shapes.get(i))) {
                    System.out.println("Removing shape at index: " + i);
                    shapes.remove(i);
                    break;
                }
            }
            repaint();

            if (shapes.size() == 0)
                System.exit(0);
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

        public int getNumberOfShapes() { return this.numberOfShapes; }
        public int getShapesRemaining() { return this.shapes.size(); }
    }

    public static void main(String[] args) {
        new Question3().init();
    }
}
