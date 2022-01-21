public interface Roof {
    int DEFAULT_ROOF_LENGTH = 10;
    int DEFAULT_ROOF_WIDTH = 10;

    void setRoofLength(int length);
    int getRoofLength();

    void setRoofWidth(int width);
    int getRoofWidth();
}