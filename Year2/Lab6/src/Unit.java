public interface Unit {
    String DEFAULT_TENANT_NAME = "Bob Ross";
    boolean DEFAULT_IS_RENTED = true;
    int DEFAULT_UNIT_CAPACITY = 4;
    int DEFAULT_UNIT_NUMBER = 1;

    void setTenantName(String tenantName);
    String getTenantName();

    void setIsRented(boolean isRented);
    boolean getIsRented();

    void setUnitCapacity(int capacity);
    int getUnityCapacity();

    void setUnitNumber(int number);
    int getUnitNumber();
}
