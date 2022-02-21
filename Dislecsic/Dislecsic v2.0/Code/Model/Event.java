package Model;

import Util.Global;
import Util.Sec;

public class Event {
    
    private String text;

    private Boolean eventTriggered;

    public Event (String text) {
        this.text = text;
        eventTriggered = false;
    }

    public String getText() {
        return text;
    }

    public void setText() {
        this.text = text;
    }

    public void trigger() throws Exception {
        if (!eventTriggered) {
            String temp = text;
            while (temp.length() > 0) {
                int index = temp.indexOf('#');
                if (index == 0) 
                {
                    throw new Exception("text starts with #");

                } else if (index == -1) 
                {
                    Global.view.printText(temp.substring(0));
                    Sec.delaySec((temp.substring(0).length()/30));

                } 
                else 
                {
                    Global.view.printText(temp.substring(0, index));
                    
                    Sec.delaySec((temp.substring(0, index).length()/30));
                }

                if (index != temp.length() - 1) {
                    temp = temp.substring(index + 1);
                }
                else {
                    break;
                }
            }
            eventTriggered = true;
        }
        
    }
    
}
