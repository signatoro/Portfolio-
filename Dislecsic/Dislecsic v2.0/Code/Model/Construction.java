package Model;

import javax.print.DocFlavor.READER;

public class Construction {

    protected Construction north;
    protected Construction east;
    protected Construction south;
    protected Construction west;


    public Construction (Construction north, Construction  east, Construction south, Construction west) {
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
    }

    public Construction getNorth() {
        return north;
    }

    public Construction getEast() {
        return east;
    }

    public Construction getSouth() {
        return south;
    }

    public Construction getWest() {
        return west;
    }

    public void setNorth(Construction north) {
        this.north = north;
    }

    public void setEast(Construction east) {
        this.east = east;
    }

    public void setSouth(Construction south) {
        this.south = south;
    }

    public void setWest(Construction west) {
        this.west = west;
    }
    
}
