import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Question3 extends JFrame implements ActionListener {

    private final static Font monospacedFont = new Font("Monospaced", Font.BOLD, 14);

    private Canvas canvas;

    private final JButton resetButton;

    private final JPanel colorButtonPanel, colorButtonPanelContainer;
    private final JButton redButton, greenButton, blueButton, yellowButton, pinkButton, orangeButton, cyanButton, grayButton, magentaButton;
    private final JLabel colorLabel;

    private final JPanel shapeButtonPanel, shapeButtonPanelContainer;
    private final JButton squareButton, widthLongRectangleButton, lengthLongRectangleButton, circleButton, ovalLengthButton, ovalWidthButton;
    private final JLabel shapeLabel;


    public Question3() {
        this.setTitle("Shape Drawer");
        this.setSize(750, 750);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());
        this.canvas = new Canvas();

        this.resetButton = new MyButton("Reset Canvas");

        // --- Color Button Panel & Buttons ---
        this.colorButtonPanel = new JPanel();
        this.colorButtonPanelContainer = new JPanel();

        this.colorButtonPanelContainer.setLayout(new FlowLayout());
        this.colorButtonPanelContainer.setBackground(Color.darkGray);

        this.colorButtonPanel.setLayout(new GridLayout(3, 3));
        this.colorButtonPanel.setBackground(Color.darkGray);

        this.redButton = new ColorButton(Color.red, "Red");
        this.greenButton = new ColorButton(Color.green, "Green");
        this.blueButton = new ColorButton(Color.blue, "Blue");
        this.yellowButton = new ColorButton(Color.yellow, "Yellow");
        this.pinkButton = new ColorButton(Color.pink, "Pink");
        this.orangeButton = new ColorButton(Color.orange, "Orange");
        this.cyanButton = new ColorButton(Color.cyan, "Cyan");
        this.grayButton = new ColorButton(Color.gray, "Gray");
        this.magentaButton = new ColorButton(Color.magenta, "Magenta");

        this.colorLabel = new JLabel("Choose a color:");
        this.colorLabel.setFont(monospacedFont);
        this.colorLabel.setForeground(Color.white);


        // --- Shape Button Panel & Buttons ---
        this.shapeButtonPanel = new JPanel();
        this.shapeButtonPanelContainer = new JPanel();

        this.shapeButtonPanelContainer.setLayout(new FlowLayout());
        this.setBackground(Color.darkGray);

        this.shapeButtonPanel.setLayout(new GridLayout(2, 3));
        this.setBackground(Color.darkGray);

        this.squareButton = new MyButton("Square");
        this.widthLongRectangleButton = new MyButton("Rectangle 1");
        this.lengthLongRectangleButton = new MyButton("Rectangle 2");
        this.circleButton = new MyButton("Circle");
        this.ovalLengthButton = new MyButton("Oval 1");
        this.ovalWidthButton = new MyButton("Oval 2");

        this.shapeLabel = new JLabel("Choose a shape:");
        this.shapeLabel.setFont(monospacedFont);

        addButtonActionListeners();
    }

    public void init() {
        setColorButtons();
        setShapeButtons();

        this.add(shapeButtonPanelContainer, BorderLayout.NORTH);
        this.add(canvas, BorderLayout.CENTER);
        this.add(colorButtonPanelContainer, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    private void setColorButtons() {
        this.colorButtonPanel.add(redButton);
        this.colorButtonPanel.add(greenButton);
        this.colorButtonPanel.add(blueButton);
        this.colorButtonPanel.add(yellowButton);
        this.colorButtonPanel.add(pinkButton);
        this.colorButtonPanel.add(orangeButton);
        this.colorButtonPanel.add(cyanButton);
        this.colorButtonPanel.add(grayButton);
        this.colorButtonPanel.add(magentaButton);

        this.colorButtonPanelContainer.add(colorLabel);
        this.colorButtonPanelContainer.add(colorButtonPanel);
        this.colorButtonPanelContainer.add(resetButton);
    }

    private void setShapeButtons() {
        this.shapeButtonPanel.add(squareButton);
        this.shapeButtonPanel.add(widthLongRectangleButton);
        this.shapeButtonPanel.add(lengthLongRectangleButton);
        this.shapeButtonPanel.add(circleButton);
        this.shapeButtonPanel.add(ovalLengthButton);
        this.shapeButtonPanel.add(ovalWidthButton);

        this.shapeButtonPanelContainer.add(shapeLabel);
        this.shapeButtonPanelContainer.add(shapeButtonPanel);
    }

    private void addButtonActionListeners() {
        this.resetButton.addActionListener(this);

        this.redButton.addActionListener(this);
        this.greenButton.addActionListener(this);
        this.blueButton.addActionListener(this);
        this.yellowButton.addActionListener(this);
        this.pinkButton.addActionListener(this);
        this.orangeButton.addActionListener(this);
        this.cyanButton.addActionListener(this);
        this.grayButton.addActionListener(this);
        this.magentaButton.addActionListener(this);

        this.squareButton.addActionListener(this);
        this.widthLongRectangleButton.addActionListener(this);
        this.lengthLongRectangleButton.addActionListener(this);
        this.circleButton.addActionListener(this);
        this.ovalLengthButton.addActionListener(this);
        this.ovalWidthButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            System.out.println("Canvas Reset");
            canvas.resetCanvas();
        }

        if (e.getSource() == redButton) {
            System.out.println("Color: Red Selected");
            canvas.setCurrentColor(Color.red);
        }
        if (e.getSource() == greenButton) {
            System.out.println("Color: Green Selected");
            canvas.setCurrentColor(Color.green);
        }

        if (e.getSource() == blueButton) {
            System.out.println("Color: Blue Selected");
            canvas.setCurrentColor(Color.blue);
        }

        if (e.getSource() == yellowButton) {
            System.out.println("Color: Yellow Selected");
            canvas.setCurrentColor(Color.yellow);
        }

        if (e.getSource() == pinkButton) {
            System.out.println("Color: Pink Selected");
            canvas.setCurrentColor(Color.pink);
        }

        if (e.getSource() == orangeButton) {
            System.out.println("Color: Orange Selected");
            canvas.setCurrentColor(Color.orange);
        }

        if (e.getSource() == cyanButton) {
            System.out.println("Color: Cyan Selected");
            canvas.setCurrentColor(Color.cyan);
        }

        if (e.getSource() == grayButton) {
            System.out.println("Color: Gray Selected");
            canvas.setCurrentColor(Color.gray);
        }

        if (e.getSource() == magentaButton) {
            System.out.println("Color: Magenta Selected");
            canvas.setCurrentColor(Color.magenta);
        }

        if (e.getSource() == squareButton) {
            System.out.println("Shape: Square Selected");
            canvas.setCurrentShape(new Rectangle(0, 0, 50, 50));
        }

        if (e.getSource() == widthLongRectangleButton) {
            System.out.println("Shape: Rectangle 1 Selected");
            canvas.setCurrentShape(new Rectangle(0, 0, 100, 50));
        }

        if (e.getSource() == lengthLongRectangleButton) {
            System.out.println("Shape: Rectangle 2 Selected");
            canvas.setCurrentShape(new Rectangle(0, 0, 50, 100));
        }

        if (e.getSource() == circleButton) {
            System.out.println("Shape: Circle Selected");
            canvas.setCurrentShape(new Ellipse2D.Double(0, 0, 50, 50));
        }

        if (e.getSource() == ovalLengthButton) {
            System.out.println("Shape: Oval Selected");
            canvas.setCurrentShape(new Ellipse2D.Double(0, 0, 50, 100));
        }

        if (e.getSource() == ovalWidthButton) {
            System.out.println("Shape: Line Selected");
            canvas.setCurrentShape(new Ellipse2D.Double(0, 0, 100, 50));
        }
    }

    class Canvas extends JPanel implements MouseListener, MouseMotionListener {
        private Point currentPoint;
        private Color currentColor;
        private Shape currentShape;

        private final ArrayList<Shape> shapes;
        private final ArrayList<Color> shapeColors;

        private boolean draw;
        private boolean pressed;

        public Canvas() {
            this.addMouseListener(this);
            this.setBackground(Color.lightGray);

            this.currentShape = new Rectangle(0, 0, 50, 50);
            this.shapes = new ArrayList<>();

            this.currentColor = Color.red;
            this.shapeColors = new ArrayList<>();
        }

        public void setCurrentColor(Color color) {
            this.currentColor = color;
        }

        public void setCurrentShape(Shape shape) {
            this.currentShape = shape;
        }

        public void resetCanvas() {
            this.shapes.clear();
            this.shapeColors.clear();
            repaint();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D graphics2D = (Graphics2D) g;

            if (draw) {
                if (currentShape instanceof Rectangle) {
                    ((Rectangle) currentShape).x = currentPoint.x - ((Rectangle) currentShape).width / 2;
                    ((Rectangle) currentShape).y = currentPoint.y - ((Rectangle) currentShape).height / 2;
                }
                else if (currentShape instanceof Ellipse2D) {
                    ((Ellipse2D) currentShape).setFrame(currentPoint.x - ((Ellipse2D) currentShape).getWidth() / 2,
                                                        currentPoint.y - ((Ellipse2D) currentShape).getHeight() / 2,
                                                        ((Ellipse2D) currentShape).getWidth(),
                                                        ((Ellipse2D) currentShape).getHeight());
                }
                else if (currentShape instanceof Line2D) {
//                    ((Line2D) currentShape).setLine();
                }

                shapeColors.add(currentColor);
                shapes.add(currentShape);

                for (int i = 0; i < shapes.size(); i++) {
                    graphics2D.setColor(shapeColors.get(i));
                    graphics2D.fill(shapes.get(i));
                    graphics2D.draw(shapes.get(i));
                }

                // Making sure the shape is kept on screen if the shape hasn't been changed
                if (currentShape instanceof Rectangle)
                    currentShape = new Rectangle(0, 0, ((Rectangle) currentShape).width,  ((Rectangle) currentShape).height);
                else if (currentShape instanceof Ellipse2D)
                    currentShape = new Ellipse2D.Double(0, 0, ((Ellipse2D) currentShape).getWidth(), ((Ellipse2D) currentShape).getHeight());
            }
            else if (pressed) {
                System.out.println("Reached here");
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            draw = true;
            currentPoint = new Point(e.getX(), e.getY());
            repaint();

        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (currentShape.contains(e.getPoint())) {
                pressed = true;
                System.out.println("Pressed is true");
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            pressed = false;
        }

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}

        @Override
        public void mouseDragged(MouseEvent e) {
            if (pressed) {
                if (currentShape instanceof Rectangle) {
                    double w = ((Rectangle) currentShape).getWidth();
                    double h = ((Rectangle) currentShape).getHeight();
                    double x = ((Rectangle) currentShape).getX();
                    double y = ((Rectangle) currentShape).getY();
                    currentShape = new Rectangle2D.Double(x, y, w, h);
                }
                else if (currentShape instanceof Ellipse2D) {
                    double w = ((Ellipse2D) currentShape).getWidth();
                    double h = ((Ellipse2D) currentShape).getHeight();
                    double x = ((Ellipse2D) currentShape).getX();
                    double y = ((Ellipse2D) currentShape).getY();
                    currentShape = new Ellipse2D.Double(x, y, w, h);
                }
                repaint();
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }

    class ColorButton extends JButton {
        public ColorButton(Color color, String text) {
            this.setText(text);
            this.setForeground(color);
            this.setBackground(Color.black);
            this.setFont(monospacedFont);
        }
    }

    class MyButton extends JButton {
        public MyButton(String text) {
            this.setText(text);
            this.setFont(monospacedFont);
        }
    }

    class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        new Question3().init();
    }
}
