public interface Cubicle {
    int DEFAULT_CUBICLE_NUMBER = 1;
    int DEFAULT_CUBICLE_SIZE = 10;
    boolean DEFAULT_HAS_SINK = false;

    void setCubicleNumber(int number);
    int getCubicleNumber();

    void setCubicleSize(int size);
    int getCubicleSize();

    void setHasSink(boolean hasSink);
    boolean getHasSink();
}
