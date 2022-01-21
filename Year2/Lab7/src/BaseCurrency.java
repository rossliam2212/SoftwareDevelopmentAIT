public interface BaseCurrency {

    double getUSD();
    void setUSD(double amount);


    void euroToUSD(double amount);
    double usdToEuro();

     void gbpToUSD(double amount);
     double usdToGBP();

     void yuanToUSD(double amount);
     double usdToYuan();
}
