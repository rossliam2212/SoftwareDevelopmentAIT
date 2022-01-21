public class ApartmentBlock extends Building implements Unit {

    private String tenantName;
    private boolean isRented;
    private int unitCapacity;
    private int unitNumber;

    public ApartmentBlock() {
        this.tenantName = DEFAULT_TENANT_NAME;
        this.isRented = DEFAULT_IS_RENTED;
        this.unitCapacity = DEFAULT_UNIT_CAPACITY;
        this.unitNumber = DEFAULT_UNIT_NUMBER;
    }

    // Methods from the Unity interface
    @Override
    public void setTenantName(String tenantName) { this.tenantName = tenantName; }

    @Override
    public String getTenantName() { return this.tenantName; }

    @Override
    public void setIsRented(boolean isRented) { this.isRented = isRented; }

    @Override
    public boolean getIsRented() { return this.isRented; }

    @Override
    public void setUnitCapacity(int capacity) { this.unitCapacity = capacity; }

    @Override
    public int getUnityCapacity() { return this.unitCapacity; }

    @Override
    public void setUnitNumber(int number) { this.unitNumber = number; }

    @Override
    public int getUnitNumber() { return this.unitNumber; }
}
