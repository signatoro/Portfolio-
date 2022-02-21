package Model;

public class Room extends Construction {


    private Tile[][] room = {{null}, {null}};
    public int x;
    public int y;

    public Room() {
        super (null, null, null, null);
    }

    public Room(Construction north, Construction east, Construction south, Construction west, Tile[][] room, int[] startCords) throws Exception {
        super(north, east, south, west);

        this.room = room;
        if (startCords.length != 2 || startCords == null) {
            throw new IllegalArgumentException("Cords contain more than two or does not exist");
        }
        if (startCords[0] >= getXDimension() || startCords[0] < 0){
            throw new IllegalArgumentException("X cords is out of the index");
        }
        else if (startCords[1] >= getYDimension() || startCords[0] < 0) {
            throw new IllegalArgumentException("Y cord is out of the index");
        }
        x = startCords[0];
        y = startCords[1];

    }

    public Tile[][] getRoom() {
        return room;
    }

    public void setRoom(Tile[][] room) {
        this.room = room;
    }

    public int getXDimension() {
        return room[0].length;
    }

    public int getYDimension() {
        return room.length;
    }


    public Tile getTile(int x, int y) {
        return room[y][x]; 
    }

    public void setTile(int x, int y, Tile tile) {
        room[x][y] = tile;
    }

    public void setStartCords(int[] startCords) throws Exception {
        if (startCords.length != 2 || startCords == null) {
            throw new IllegalArgumentException("Cords contain more than two or does not exist");
        }
        if (startCords[0] >= getXDimension() || startCords[0] < 0){
            throw new IllegalArgumentException("X cords is out of the index");
        }
        else if (startCords[1] >= getYDimension() || startCords[0] < 0) {
            throw new IllegalArgumentException("Y cord is out of the index");
        }
        x = startCords[0];
        y = startCords[1];
    }
    
}
