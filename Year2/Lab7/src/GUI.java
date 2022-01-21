import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class GUI extends JFrame implements ActionListener {
    private CurrencyConverter converter;
    private double inputtedValue = 0.0;

    private Container contentPane;
    private JPanel textFieldPanel;

    private JLabel errorLabel, usdLabel, euroLabel, gbpLabel, yuanLabel;
    private JTextField usdField, euroField, gbpField, yuanField;
    private JButton clearBtn;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    private boolean fromUSD = false;
    private boolean fromEuro = false;
    private boolean fromGBP = false;
    private boolean fromYUAN = false;

    public GUI() {
        this.setSize(800, 150);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Currency Converter");
        init();
        this.setVisible(true);
    }

    private void init() {
        converter = new CurrencyConverter();
        contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());

        textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new FlowLayout());

        // Labels
        errorLabel = new JLabel("Error! Invalid entry.");
        usdLabel = new JLabel("USD ($):");
        euroLabel = new JLabel("EUR (€):");
        gbpLabel = new JLabel("GBP (£):");
        yuanLabel = new JLabel("CNY (¥):");
        // Text Fields
        usdField = new JTextField(10);
        euroField = new JTextField(10);
        gbpField = new JTextField(10);
        yuanField = new JTextField(10);

        clearBtn = new JButton("Clear");

        setActionListeners();

        // Adding the labels & fields to the field panel
        textFieldPanel.add(usdLabel);
        textFieldPanel.add(usdField);

        textFieldPanel.add(euroLabel);
        textFieldPanel.add(euroField);

        textFieldPanel.add(gbpLabel);
        textFieldPanel.add(gbpField);

        textFieldPanel.add(yuanLabel);
        textFieldPanel.add(yuanField);

        contentPane.add(textFieldPanel, BorderLayout.NORTH); // Adding the field panel to the top of the contentPane
        contentPane.add(errorLabel, BorderLayout.CENTER); // Adding the error label to the center of the contentPane and making it invisible
        errorLabel.setVisible(false);
        contentPane.add(clearBtn, BorderLayout.SOUTH); // Adding the clear button to the bottom of the contentPane
    }

    /**
     * This method adds the action listeners to all the text areas and the clear button.
     */
    private void setActionListeners() {
        usdField.addActionListener(this);
        euroField.addActionListener(this);
        gbpField.addActionListener(this);
        yuanField.addActionListener(this);

        clearBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == usdField) {
            fromUSD = true;
            try {
                inputtedValue = Double.parseDouble(usdField.getText());
                errorLabel.setVisible(false);
                displayValues(inputtedValue);
//                System.out.println("\nConverting from $:");
            } catch (Exception exception) {
//                exception.printStackTrace();
                handleError();
            }
        }
        else if (e.getSource() == euroField) {
            fromEuro = true;
            try {
                inputtedValue = Double.parseDouble(euroField.getText());
                errorLabel.setVisible(false);
                displayValues(inputtedValue);
//                System.out.println("\nConverting from €:");
            } catch (Exception exception) {
                handleError();
            }
        }
        else if (e.getSource() == gbpField) {
            fromGBP = true;
            try {
                inputtedValue = Double.parseDouble(gbpField.getText());
                errorLabel.setVisible(false);
                displayValues(inputtedValue);
//                System.out.println("\nConverting from £:");
            } catch (Exception exception) {
                handleError();
            }
        }
        else if (e.getSource() == yuanField) {
            fromYUAN = true;
            try {
                inputtedValue = Double.parseDouble(yuanField.getText());
                errorLabel.setVisible(false);
                displayValues(inputtedValue);
//                System.out.println("\nConverting from ¥:");

            } catch (Exception exception) {
                handleError();
            }
        }
        else if (e.getSource() == clearBtn)
            clearFields();
    }

    /**
     * This method is used to update each text field with the correct conversions.
     * @param value The value entered in by the user.
     */
    private void displayValues(double value) {
           if (fromUSD) {
               fromUSD = false;

               converter.setUSD(value);

               euroField.setText("" + df.format(converter.usdToEuro()));
               gbpField.setText("" + df.format(converter.usdToGBP()));
               yuanField.setText("" + df.format(converter.usdToYuan()));
           }
           else if (fromEuro) {
               fromEuro = false;
               converter.euroToUSD(value);

               usdField.setText("" + df.format(converter.getUSD()));
               gbpField.setText("" + df.format(converter.usdToGBP()));
               yuanField.setText("" + df.format(converter.usdToYuan()));
           }
           else if (fromGBP) {
               fromGBP = false;
               converter.gbpToUSD(value);

               usdField.setText("" + df.format(converter.getUSD()));
               euroField.setText("" + df.format(converter.usdToEuro()));
               yuanField.setText("" + df.format(converter.usdToYuan()));
           }
           else if (fromYUAN) {
               fromYUAN = false;

               converter.yuanToUSD(value);

               usdField.setText("" + df.format(converter.getUSD()));
               euroField.setText("" + df.format(converter.usdToEuro()));
               gbpField.setText("" + df.format(converter.usdToGBP()));
           }
    }

    /**
     * This method is used to clear all the text fields.
     * It is called when the clear button is pressed.
     */
    private void clearFields() {
//        System.out.println("All fields cleared.");
        usdField.setText("");
        euroField.setText("");
        gbpField.setText("");
        yuanField.setText("");
        errorLabel.setVisible(false);
    }

    private void handleError() {
        errorLabel.setVisible(true);
//        System.out.println("\nInvalid entry. Try again!");
    }

    public static void main(String[] args) {
//        System.out.println("\uD83D\uDCA3");
        new GUI();
    }

}
