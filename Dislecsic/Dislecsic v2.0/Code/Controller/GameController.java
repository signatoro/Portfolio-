package Controller;


import Model.Armor;
import Model.Construction;
import Model.Container;
import Model.CutScene;
import Model.Enemy;
import Model.Entity;
import Model.Event;
import Model.Item;
import Model.Map;
import Model.Path;
import Model.Player;
import Model.Potion;
import Model.Room;
import Model.Tile;
import Model.Weapon;
import Model.Items.HealthPotion;
import Util.GameState;
import Util.Generating;
import Util.Global;
import Util.Rarity;
import Util.Rng;
import Util.Sec;
import Util.StringCleaner;

public class GameController {

    

    private Player player;
    private Construction pos;
    private Construction previousPos;
    

    public GameController(Player player, Map map) {
        this.player = player;
        try {
            this.pos = Generating.initialize();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            Global.view.printError(e);
            e.printStackTrace();
        }
    }

    public void gameloop() {

        while(true) {
            

            Sec.delaySec(1);
            

            if (pos instanceof Path) 
            {
                if (previousPos instanceof Room) {
                    Global.view.printText("You Leave the room and return to the hallway.");
                }
                
                Path path = (Path) pos;
                
                try {
                    if (path.getEvent() != null) {
                        path.getEvent().trigger();
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    Global.view.printError(e);
                    e.printStackTrace();
                };

                path.message();

            }

            //ROOM
            else if (pos instanceof Room) 
            {
                boolean skip = false;

                Room room = (Room) pos;
                if (previousPos instanceof Path) {
                    Global.view.printText("You entered a room!");
                    player.x = room.x;
                    player.y = room.y;
                    skip = true;
                }   
                
                
                Tile tile = room.getTile(player.x, player.y);


                if (tile.getEnemy() != null) {
                    Global.view.printText(tile.getEnemy().getName());
                    //combatLoop(tile.getEnemy());
                }

                
                try {
                    if (tile.getEvent() != null && !skip) {
                        tile.getEvent().trigger();
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    Global.view.printError(e);
                    e.printStackTrace();
                }

                if (tile.getEntity() != null) {
                    Global.view.printText("You look down at the ground and see a " + tile.getEntity().getName());
                }

                tile.message();
            }


            String choice = StringCleaner.cleanString(Global.view.getInput());

            // **********
            // COMMANDS
            // **********

            // HELP
            if (choice.equalsIgnoreCase("Help")) 
            {
                Global.lastGameState = Global.gamestate;
                Global.gamestate = GameState.INSTRUCTIONS;
                Global.view.panelSwitcher(Global.gamestate);

                Sec.delaySec(1);
            }
            
            // REST
            else if (choice.equalsIgnoreCase("Rest"))
            {
                if (player.getRestCounter() > 0)
                {
                    player.rest();
                    CutScene.Sc5Sleep();
                }
                else
                {
                    Global.view.printText("You lie down and try to fall asleep but you can't.");
                    Sec.delaySec(2);
                    Global.view.printText("the complete silence of the forest is unnerving");
                }
            }
            else if (choice.equalsIgnoreCase("xy")) {
                Global.view.printText("x: " + player.x + " y: " + player.y);
            }

            // GO
            else if (choice.contains("go") && choice.length() > 2)
            {
                String direction = StringCleaner.cleanString(choice.substring(3));

                if (direction.equals("north"))
                {
                    if (pos instanceof Path) 
                    {
                        if (pos.getNorth() == null) {
                            Global.view.printText("You look at the wall and see a motivational cat poster");
                        } 
                        else 
                        {
                            previousPos = pos;
                            pos = pos.getNorth();
                            Global.view.printText("You head North");
                        }
                        
                    }
                    else if (pos instanceof Room) 
                    {
                        player.goNorth();;

                        if (!(((Room) pos).getTile(player.x, player.y).valid)) {
                            Global.view.printText("You look at the wall and see a motivational cat poster");
                            player.goSouth();
                        }
                        else {
                            previousPos = pos;
                            Global.view.printText("You head West");
                        }
                    }
                }

                else if (direction.equals("east"))
                {
                    if (pos instanceof Path) 
                    {
                        if (pos.getEast() == null) {
                            Global.view.printText("You look at the wall and see a motivational cat poster");
                        } 
                        else 
                        {
                            previousPos = pos;
                            pos = pos.getEast();
                            Global.view.printText("You head East");

                        }
                        
                    }
                    else if (pos instanceof Room) 
                    {
                        player.goEast();

                        if (!(((Room) pos).getTile(player.x, player.y).valid)) {
                            Global.view.printText("You look at the wall and see a motivational cat poster");
                            player.goWest();
                        }
                        else {
                            previousPos = pos;
                            Global.view.printText("You head West");
                        }
                        
                    }
                    
                }
                else if (direction.equals("south"))
                {
                    if (pos instanceof Path) 
                    {
                        if (pos.getSouth() == null) {
                            Global.view.printText("You look at the wall and see a motivational cat poster");
                        } 
                        else 
                        {
                            previousPos = pos;
                            pos = pos.getSouth();
                            Global.view.printText("You head South");

                        }
                    }
                    else if (pos instanceof Room) 
                    {
                        player.goSouth();

                        if (!(((Room) pos).getTile(player.x, player.y).valid)) {
                            Global.view.printText("You look at the wall and see a motivational cat poster");
                            player.goNorth();
                        }
                        else {
                            previousPos = pos;
                            Global.view.printText("You head West");
                        }
                    }
                    
                }
                else if (direction.equals("west"))
                {
                    if (pos instanceof Path) 
                    {
                        if (pos.getWest() == null) {
                            Global.view.printText("You look at the wall and see a motivational cat poster");
                        } 
                        else 
                        {
                            previousPos = pos;
                            pos = pos.getWest();
                            Global.view.printText("You head West");
                        }
                        
                    }
                    else if (pos instanceof Room) 
                    {
                        player.goWest();

                        if (!(((Room) pos).getTile(player.x, player.y).valid)) {
                            Global.view.printText("You look at the wall and see a motivational cat poster");
                            player.goEast();
                        }
                        else {
                            if ((((Room) pos).getTile(player.x, player.y).getName().equals("exit"))) {
                                
                                try {
                                    ((Room) pos).setStartCords(new int[]{player.x, player.y});
                                } catch (Exception e) {
                                    // TODO Auto-generated catch block
                                    Global.view.printError(e);
                                    e.printStackTrace();
                                }
                                previousPos = pos;

                                if (player.x == 0) {
                                    pos = pos.getWest();
                                }
                                else if (player.x == ((Room) pos).getXDimension()) {
                                    pos = pos.getEast();
                                }
                                else if (player.y == 0) {
                                    pos = pos.getNorth();
                                }
                                else if (player.y == ((Room)pos).getYDimension()) {
                                    pos = pos.getSouth();
                                }
                                else {
                                    int currentLine = new Throwable().getStackTrace()[0].getLineNumber();
                                    Global.view.printError(currentLine + "Exit is not at the edge of the room");
                                }

                            } 
                            else {
                            previousPos = pos;
                            Global.view.printText("You head West");
                            }
                        }
                        

                    }
                    
                }
                else 
                {
                    Global.view.printText("You can not go " + direction);
                    System.out.println(choice);
                    System.out.println(direction);
                }




            }

            
        }
    }

    private void combatLoop(Enemy enemy) {

    }

    /**
     * if (pos instanceof Path) 
        {
            ((Path) pos).message();
        }
        else if (pos instanceof Room) 
        {
            

        }
     */

    
}
