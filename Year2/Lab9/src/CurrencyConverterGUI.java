import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverterGUI extends JFrame implements ActionListener {
    private final JPanel textFieldPanel;
    private final JLabel errorLabel, usdLabel, euroLabel, gbpLabel, yuanLabel;
    private final JTextField usdField, euroField, gbpField, yuanField;
    private final JButton clearBtn;

    private double enteredValue;
    private boolean fromUSD = false;
    private boolean fromEuro = false;
    private boolean fromGBP = false;
    private boolean fromYuan = false;

    public CurrencyConverterGUI() {
        this.setSize(800, 150);
        this.setResizable(false);
        this.setTitle("Currency Converter w/ JSoup");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.textFieldPanel = new JPanel(new FlowLayout());

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
    }

    public void init() {
        addActionListeners();

        this.textFieldPanel.add(usdLabel);
        this.textFieldPanel.add(usdField);

        this.textFieldPanel.add(euroLabel);
        this.textFieldPanel.add(euroField);

        this.textFieldPanel.add(gbpLabel);
        this.textFieldPanel.add(gbpField);

        this.textFieldPanel.add(yuanLabel);
        this.textFieldPanel.add(yuanField);

        this.add(textFieldPanel, BorderLayout.CENTER);
        this.add(clearBtn, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    private void addActionListeners() {
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
                enteredValue = Double.parseDouble(usdField.getText());
                convert(enteredValue);
            } catch (Exception exception) {
                System.out.println("Error. Invalid value entered.");
//                exception.printStackTrace();
            }
        }

        if (e.getSource() == euroField) {
            fromEuro = true;
            try {
                enteredValue = Double.parseDouble(euroField.getText());
                convert(enteredValue);
            } catch (Exception exception) {
                System.out.println("Error. Invalid value entered.");
//                exception.printStackTrace();
            }
        }

        if (e.getSource() == gbpField) {
            fromGBP = true;
            try {
                enteredValue = Double.parseDouble(gbpField.getText());
                convert(enteredValue);
            } catch (Exception exception) {
                System.out.println("Error. Invalid value entered.");
//                exception.printStackTrace();
            }
        }

        if (e.getSource() == yuanField) {
            fromYuan = true;
            try {
                enteredValue = Double.parseDouble(yuanField.getText());
                convert(enteredValue);
            } catch (Exception exception) {
                System.out.println("Error. Invalid value entered.");
//                exception.printStackTrace();
            }
        }

        if (e.getSource() == clearBtn) {
            System.out.println("All fields cleared.");
            usdField.setText(" ");
            euroField.setText(" ");
            gbpField.setText(" ");
            yuanField.setText(" ");
        }
    }

    private void convert(double amount) {
        String fromCurrency;

        if (fromUSD) {
            fromUSD = false;
            fromCurrency = "USD";

            euroField.setText("" + getCurrencyExchange(fromCurrency, "EUR", amount));
            gbpField.setText("" + getCurrencyExchange(fromCurrency, "GBP", amount));
            yuanField.setText("" + getCurrencyExchange(fromCurrency, "CNY", amount));
        }
        else if (fromEuro) {
            fromEuro = false;
            fromCurrency = "EUR";

            usdField.setText("" + getCurrencyExchange(fromCurrency, "USD", amount));
            gbpField.setText("" + getCurrencyExchange(fromCurrency, "GBP", amount));
            yuanField.setText("" + getCurrencyExchange(fromCurrency, "CNY", amount));
        }
        else if (fromGBP) {
            fromGBP = false;
            fromCurrency = "GBP";

            usdField.setText("" + getCurrencyExchange(fromCurrency, "USD", amount));
            euroField.setText("" + getCurrencyExchange(fromCurrency, "EUR", amount));
            yuanField.setText("" + getCurrencyExchange(fromCurrency, "CNY", amount));
        }
        else if (fromYuan) {
            fromYuan = false;
            fromCurrency = "CNY";

            usdField.setText("" + getCurrencyExchange(fromCurrency, "USD", amount));
            euroField.setText("" + getCurrencyExchange(fromCurrency, "EUR", amount));
            gbpField.setText("" + getCurrencyExchange(fromCurrency, "GBP", amount));
        }
    }

    private double getCurrencyExchange(String fromCurrency, String toCurrency, double amount) {
        try {
            Document doc = Jsoup.connect(String.format("https://www.xe.com/currencyconverter/convert/?Amount=%f&From=%s&To=%s", amount, fromCurrency, toCurrency)).get();
            Elements elements = doc.select("p");
            for (Element element : elements) {
                String classes = element.className();
                if (classes.contains("result__BigRate")) {
                    String temp = element.text();
                    temp = temp.replaceAll("[^0-9.]", "");

                    System.out.println(amount + " " + fromCurrency + " => " + temp + " " + toCurrency);
                    return Double.parseDouble(temp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        new CurrencyConverterGUI().init();
    }
}
