
public class CurrencyConverter implements BaseCurrency {

    private double usd = 0.0;

    @Override
    public double getUSD() {
        return usd;
    }

    @Override
    public void setUSD(double amount) {
        usd = amount;
    }

    @Override
    public void euroToUSD(double amount) {
        usd = amount * 1.14;
    }

    @Override
    public double usdToEuro() {
        return usd / 1.14;
    }

    @Override
    public void gbpToUSD(double amount) {
        usd = amount * 1.37;
    }

    @Override
    public double usdToGBP() {
        return usd / 1.37;
    }

    @Override
    public void yuanToUSD(double amount) {
        usd = amount / 6.35;
    }

    @Override
    public double usdToYuan() {
        return usd * 6.35;
    }


    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();

        converter.euroToUSD(100.0);
        System.out.println(converter.usdToEuro() + " EUR => " + converter.getUSD() + " USD");

        converter.gbpToUSD(100.0);
        System.out.println(converter.usdToGBP() + " GBP => " + converter.getUSD() + " USD");

        converter.yuanToUSD(100.0);
        System.out.println(converter.usdToYuan() + " RMB => " + converter.getUSD() + " USD");
    }
}
