import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    // All JPanels
    private JPanel mainPanel;
    private JPanel radioButtonPanel;
    private JPanel housePanel;
    private JPanel apartmentPanel;
    private JPanel officePanel;

    // All JRadioButtons
    private JRadioButton houseButton;
    private JRadioButton apartmentButton;
    private JRadioButton officeButton;

    private final int SCREEN_WIDTH = 600;
    private  final int SCREEN_HEIGHT = 600;

    private House house;
    private ApartmentBlock apartmentBlock;
    private OfficeBlock officeBlock;


    public GUI() {
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setTitle("Building Creator");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // CHANGE THIS LATER

        this.house = new House();
        this.apartmentBlock = new ApartmentBlock();
        this.officeBlock = new OfficeBlock();

        //this.setLayout(new FlowLayout()); // Setting layout on the frame
    }

    public void init() {
        mainPanel = createPanel(2); // Main panel with border layout to hold all other panels

        // Radio Buttons Panel & Buttons
        radioButtonPanel = createPanel(1);
        radioButtonPanel.setBackground(Color.ORANGE);
        houseButton = new JRadioButton("House");
        apartmentButton = new JRadioButton("Apartment Block");
        officeButton = new JRadioButton("Office Block");

        addRadioButtonActionListeners(); // Add the Action listeners for the radio buttons

        // Creating a button group for the radio buttons so only one radio button can be selected at a time.
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(houseButton);
        buttonGroup.add(apartmentButton);
        buttonGroup.add(officeButton);

        radioButtonPanel.add(new JLabel("Choose a building type:"));
        radioButtonPanel.add(houseButton);
        radioButtonPanel.add(apartmentButton);
        radioButtonPanel.add(officeButton);

        // House Panel & Components
        housePanel = createPanel(2);
//        setUpHousePanel();
        housePanel.setBackground(Color.yellow);
        JLabel houseLabel = new JLabel("House:");
        housePanel.add(houseLabel);
        housePanel.setVisible(true); // House Panel visible by default.

        // Apartment Panel & Components
        apartmentPanel = createPanel(2);
        housePanel.setBackground(Color.green);
        JLabel apartmentLabel = new JLabel("Apartment Block:");
        apartmentPanel.add(apartmentLabel);
        apartmentPanel.setVisible(false); // Apartment Panel invisible by default.

        // Office Panel & Components
        officePanel = createPanel(2);
        officePanel.setBackground(Color.blue);
        JLabel officeLabel = new JLabel("Office Block:");
//        officeLabel.setBounds(80, 80, 100, 100);
        officePanel.add(officeLabel);
        officePanel.setVisible(false); // Office Panel invisible by default.

        // Setting the dimensions for each of the three building panels.
        housePanel.setPreferredSize(new DimensionUIResource(400,400));
        officePanel.setPreferredSize(new DimensionUIResource(400,400));
        apartmentPanel.setPreferredSize(new DimensionUIResource(400,400));

        mainPanel.add(radioButtonPanel, BorderLayout.NORTH); // Placing the radio buttons panel at the top.
        JPanel displayPane = new JPanel(); // Display panel to add the building panels to.
        mainPanel.add(displayPane, BorderLayout.CENTER); // Placing the display panel in the center.

        // Adding the building panels to the display panel.
        displayPane.add(housePanel);
        displayPane.add(officePanel);
        displayPane.add(apartmentPanel);

        this.add(mainPanel);
        this.setVisible(true); // Setting the frame to be visible.
    }


    /**
     * This method adds action listeners to all the radio buttons on the radio button panel.
     */
    private void addRadioButtonActionListeners() {
        houseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("House Button selected");
                housePanel.setVisible(true);
                apartmentPanel.setVisible(false);
                officePanel.setVisible(false);
            }
        });

        apartmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Apartment Button Selected");
                housePanel.setVisible(false);
                apartmentPanel.setVisible(true);
                officePanel.setVisible(false);
            }
        });

        officeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Office Block Button Selected");
                housePanel.setVisible(false);
                apartmentPanel.setVisible(false);
                officePanel.setVisible(true);
            }
        });
    }

    /**
     * This method is used to create new JPanels with a specific layout.
     * 1 = FlowLayout
     * 2 = BorderLayout
     * 3 = Grid Layout
     * @param layout The layout that the panel should have.
     * @return The new JPanel
     */
    private JPanel createPanel(int layout) {
        JPanel panel = new JPanel();
        // FlowLayout = 1
        if (layout == 1)
            panel.setLayout(new FlowLayout());
        else if (layout == 2)
            panel.setLayout(new BorderLayout());
        else if (layout == 3)
            panel.setLayout(new GridLayout());

        return panel;
    }

//    private void setUpHousePanel() {
//
//        String[] houseTitles = {"Room Type", "Room Number", "Room Size"};
//        String[][] houseInfo = { {house.getRoomType(), ""+house.getRoomNumber(), ""+house.getRoomSize()}};
//        JTable houseTable = new JTable(houseInfo, houseTitles);
//        houseTable.setBounds(50, 50, 300, 50);
//        housePanel.add(houseTable);
//
//        housePanel.setBackground(Color.yellow);
//        JLabel houseLabel = new JLabel("House:");
//        houseLabel.setBounds(0, 0, 0, 0);
//        housePanel.add(houseLabel);
//
//    }

    // Main method for Running the class
    public static void main(String[] args) {
        new GUI().init();
    }
}
