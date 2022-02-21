package Model;

import Util.Global;

public class Path extends Construction {

    //Variables
    private Event event;

    public Path(Construction north, Construction east, Construction south, Construction west) {
        super(north, east, south, west);
    }

    public Path(Construction north, Construction east, Construction south, Construction west, Event event) {
        super(north, east, south, west);
        this.event = event;

    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }



    public void message() {
        String text = "There are trees to you're ";
        if (super.north == null) {
            text += "north ";
        }
        
        if (super.east == null) {
            text += " east ";
        }

        if (super.south == null) {
            text += "south ";
        }

        if (super.west == null) {
            text += "west ";
        }

        Global.view.printText(text);
    }




    
    
}
