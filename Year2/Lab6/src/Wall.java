public interface Wall {
    int DEFAULT_WALL_LENGTH = 10;
    int DEFAULT_WALL_WIDTH = 10;
    int DEFAULT_WALL_HEIGHT = 10;

    void setWallLength(int length);
    int getWallLength();

    void setWallWidth(int width);
    int getWallWidth();

    void setDefaultWallHeight(int height);
    int getDefaultWallHeight();
}
