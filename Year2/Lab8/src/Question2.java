import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;
import java.util.ArrayList;

public class Question2 extends JFrame implements ActionListener {

    private Canvas canvas = new Canvas();

    public Question2() {
        this.setTitle("Drawing Shapes");
        this.setSize(750, 750);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void init() {
        this.add(canvas);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {}


    class Canvas extends JPanel implements MouseListener {
        private Point currentPoint;
        private boolean draw;

        private Color colors[] = {Color.red, Color.green, Color.blue, Color.black, Color.yellow, Color.CYAN, Color.magenta, Color.pink, Color.orange};
        int colorTracker;

        ArrayList<Shape> shapes = new ArrayList<>();
        int shapeTracker;


        public Canvas() {
            addMouseListener(this);
            draw = false;
            shapeTracker = 0;
            this.setBackground(Color.lightGray);

            addShape(new Rectangle(0, 0, 100, 200));
            addShape(new Rectangle(0, 0, 200, 150));
            addShape(new Rectangle(0, 0, 100, 100));
//            addShape(new Ellipse2D.Double(0, 0, 100, 100));
        }

        public void addShape(Shape shape) {
            this.shapes.add(shape);
        }

        private void drawCalled() {
            repaint();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D graphics2D = (Graphics2D) g;

            if (draw) {
                if (shapes.get(shapeTracker) instanceof Rectangle) {
                    if (((Rectangle) shapes.get(shapeTracker)).contains(currentPoint.x, currentPoint.y)) {
                        graphics2D.setColor(colors[colorTracker]);
                        graphics2D.fill(shapes.get(shapeTracker));
                        graphics2D.draw(shapes.get(shapeTracker));
                    }
                    else {
                        ((Rectangle) shapes.get(shapeTracker)).x = currentPoint.x - (((Rectangle) shapes.get(shapeTracker)).width / 2);
                        ((Rectangle) shapes.get(shapeTracker)).y = currentPoint.y - (((Rectangle) shapes.get(shapeTracker)).height / 2);

                        graphics2D.setColor(colors[colorTracker]);
                        graphics2D.fill(shapes.get(shapeTracker));
                        graphics2D.draw(shapes.get(shapeTracker));

                        shapeTracker++;
                        if (shapeTracker > shapes.size()-1) shapeTracker = 0;
                    }
                }

                colorTracker++;
                if (colorTracker > colors.length-1) colorTracker = 0;
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {
            draw = true;
            currentPoint = new Point(e.getX(), e.getY());
            repaint();
        }

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    }

    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        new Question2().init();
    }
}
