public interface Room {

    String DEFAULT_ROOM_TYPE = "Sitting Room";
    int DEFAULT_ROOM_NUMBER = 1;
    int DEFAULT_ROOM_SIZE = 10;

    void setRoomType(String type);
    String getRoomType();

    void setRoomNumber(int number);
    int getRoomNumber();

    void setRoomSize(int size);
    int getRoomSize();
}

