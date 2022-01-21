public class Building implements Wall, Roof {

    private int wallLength;
    private int wallWidth;
    private int wallHeight;
    private int roofLength;
    private int roofWidth;

    public Building() {
        this.wallLength = DEFAULT_WALL_LENGTH;
        this.wallWidth = DEFAULT_WALL_WIDTH;
        this.wallHeight = DEFAULT_WALL_HEIGHT;
        this.roofLength = DEFAULT_ROOF_LENGTH;
        this.roofWidth = DEFAULT_ROOF_WIDTH;
    }

    // Methods from Roof Interface
    @Override
    public void setRoofLength(int length) {
        this.roofLength = length;
    }

    @Override
    public int getRoofLength() {
        return this.roofLength;
    }

    @Override
    public void setRoofWidth(int width) {
        this.roofWidth = width;
    }

    @Override
    public int getRoofWidth() {
        return this.roofWidth;
    }


    // Methods from Wall Interface
    @Override
    public void setWallLength(int length) {
        this.wallLength = length;
    }

    @Override
    public int getWallLength() {
        return this.wallLength;
    }

    @Override
    public void setWallWidth(int width) {
        this.wallWidth = width;
    }

    @Override
    public int getWallWidth() {
        return this.wallWidth;
    }

    @Override
    public void setDefaultWallHeight(int height) { this.wallHeight = height; }

    @Override
    public int getDefaultWallHeight() { return  this.wallHeight; }
}
