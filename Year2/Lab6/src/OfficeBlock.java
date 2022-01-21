public class OfficeBlock extends Building implements Cubicle {
    private int cubicleNumber;
    private int cubicleSize;
    private boolean hasSink;

    public OfficeBlock() {
        this.cubicleNumber = DEFAULT_CUBICLE_NUMBER;
        this.cubicleSize = DEFAULT_CUBICLE_SIZE;
        this.hasSink = DEFAULT_HAS_SINK;
    }

    // Methods from the OfficeBlock Interface
    @Override
    public void setCubicleNumber(int number) { this.cubicleNumber = number; }

    @Override
    public int getCubicleNumber() { return this.cubicleNumber; }

    @Override
    public void setCubicleSize(int size) { this.cubicleSize = size; }

    @Override
    public int getCubicleSize() { return this.cubicleSize; }

    @Override
    public void setHasSink(boolean hasSink) { this.hasSink = hasSink;}

    @Override
    public boolean getHasSink() { return this.hasSink; }
}
