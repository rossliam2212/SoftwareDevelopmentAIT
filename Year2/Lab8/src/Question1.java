import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Question1 extends JFrame implements ActionListener {

    private DrawingPanel drawingArea;
    private JButton drawButton;

    private boolean draw = false;

    public Question1() {
        this.setTitle("Draw Shape");
        this.setSize(750,750);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.drawingArea = new DrawingPanel();
        this.drawButton = new JButton("Draw");
    }

    public void init(){
        this.drawButton.addActionListener(this);

        this.add(drawButton);
        this.add(drawingArea);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        draw = true;
        drawingArea.drawCalled();
    }


    class DrawingPanel extends JPanel implements MouseListener {

        private ArrayList<Point> points;

        public DrawingPanel() {
            this.points = new ArrayList<>();

            addMouseListener(this);
            this.setBackground(Color.GRAY);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            if(draw) {
                for(int i = 0; i < points.size() - 1; i++) {
                    g.drawLine(points.get(i).x, points.get(i).y, points.get(i+1).x, points.get(i+1).y);
                }

                g.drawLine(points.get(0).x, points.get(0).y, points.get(points.size()-1).x, points.get(points.size()-1).y);
            }

            for(Point p : points) {
                g.setColor(Color.RED);
                g.fillOval(p.x -5, p.y - 5, 10,10);
            }
        }
        public void drawCalled() {
            repaint();
        }

        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {
            points.add(new Point(e.getX(), e.getY()));
            repaint();
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        new Question1().init();
    }
}