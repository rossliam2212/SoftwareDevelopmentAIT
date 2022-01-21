public class House extends Building implements Room {

    private String roomType;
    private int roomNumber;
    private int roomSize;

    public House() {
        this.roomType = DEFAULT_ROOM_TYPE;
        this.roomNumber = DEFAULT_ROOM_NUMBER;
        this.roomSize = DEFAULT_ROOM_SIZE;
    }

    // Methods from the Room Interface
    @Override
    public void setRoomType(String type) { this.roomType = type; }

    @Override
    public String getRoomType() { return this.roomType; }

    @Override
    public void setRoomNumber(int number) { this.roomNumber = number; }

    @Override
    public int getRoomNumber() { return this.roomNumber; }

    @Override
    public void setRoomSize(int size) { this.roomSize = size; }

    @Override
    public int getRoomSize() { return this.roomSize; }
}
