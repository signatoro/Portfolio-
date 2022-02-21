package Util;

import Model.Armor;
import Model.Construction;
import Model.Container;
import Model.Enemy;
import Model.Event;
import Model.Path;
import Model.Potion;
import Model.Room;
import Model.Tile;
import Model.Weapon;

public class Generating {

    private static Tile tree = new Tile ("tree", "You are in the forst", false, null, null, null);
    private static Tile open = new Tile ("open", "Yoo are in a cleering.", true, null, null, null);
    private static Tile tLef = new Tile ("leftTop", "Their are walls north and west of yoo.", true, null, null, null);
    private static Tile tRig = new Tile ("rightTop", "There are whalls north and east of yoe.", true, null, null, null);
    private static Tile bLef = new Tile ("leftBot", "They're are wals south and west of you.", true, null, null, null);
    private static Tile bRig = new Tile ("rightBot", "Their are walls too your south and east.", true, null, null, null);
    private static Tile topp = new Tile ("top", "Their is a wall to your north.", true, null, null, null);
    private static Tile bott = new Tile ("bot", "There is a wall two the south of yoe.", true, null, null, null);
    private static Tile left = new Tile ("left", "There is a wall too your west.", true, null, null, null);
    private static Tile righ = new Tile ("right", "They're is a wall to your east", true, null, null, null);
    private static Tile exit = new Tile ("exit", "Yoe leeve the room and hed down a hal", true, null, null, null);

    public static Construction initialize() throws Exception {

        Event startSc = new Event("Our storee degins in the small town of Aelwyn, more acuratelee in the forest just north of the town.#Yoo often come to the forest to get awa from the kid who pick on you for not being as smart as they are.#But who cares if they are better at spelling, your gud at a lot of things they aren\'t.#You continu to let you\'re mind wander had you head deapor and deypur into the forest.#As you walk you can feel a slight breaze and smell the intoxicating erthy sent. As your walking something catches you\'re i... a building!#But its not a cottage or a hut, it's big, like really big it almost looks like a school.#As you approach you ce this large gray rectangular building, with a red stripe running around it.#You can see faded lettering in the red stryp that reeds  \"Pepper\'s Mystical School of the Magic\".#You walk up to the grand wooden boors and they open for you, intrigued you go in and as you do the boors close.#Looking adout you see a dimley lit hallway with teal coloured lockors that line the walls to your east and west.#The hallway continues north.#");
        Event crossRoads = new Event("Yoo approach an intersecsion in the hallway, when you hear a soft pop, as you look over in the birecsion of the noise you see a veree tall and slendor man.#He has stone grey skin with brite pink hair that floes down his face. He is bressed in a beautiful teal rowb that matches the lockers perfectly.#As you look at him you can\'t help but notice his radian bleu eys and the soft inviting smile across his fase.#\"Hi, I\'m Caduceus, Caduceus Clay that is, and I am, or more accurately was, the headmaster of this school\"#His voice is deap and soft and has a soothing qualitee to it.#\"I can sense your worry and anxiety, so I will pass on the advice that was once given to me.\"#\"Your anxieties and worries do not define you, your strength to overcome them does.\"#\"Back in its heyday this school was able to help a lot of people and I have a feeling that it’s not done helping.\"#\"Speaking of helping you should grab the stick on the ground you never know how useful it might be.\"#\"The three paths in front of you will all lead you to the destination you seek and remember your strength come from within\"#And with the swish of his robes he vanishes leeving pink flowers were he was standing.#There are 3 hallways in front of you, one heeding north, one east, and one west and at your feet is a weird looking stick.#");


        Construction currentConstruction;
        
        Construction startPoint = new Path(null, null, null ,null, startSc);

        currentConstruction = startPoint;

        for (int i = 0; i < Rng.rangeInt(1, 3); i++) {
            currentConstruction.setNorth(new Path(null, null, currentConstruction, null));
            currentConstruction = currentConstruction.getNorth();
        }

        currentConstruction.setNorth(new Path(null, null, currentConstruction, null, crossRoads));
        currentConstruction = currentConstruction.getNorth();
        
        Construction westRoute =  makeWest(currentConstruction);
        currentConstruction.setWest(westRoute);
 

        currentConstruction.setNorth(new Path(null, null, currentConstruction, null, new Event("End of the path success#")));



        /*
        Tile[][] bossRoomMap = {{}};
        Construction bossRoom = new Room(null, null, null, null, bossRoomMap);
        */

        return startPoint;
        
    }





    public static Construction makeWest(Construction cConstruction) throws Exception {

        //Start Point
        Construction startPoint = new Path(null, cConstruction, null, null);
        Construction currentConstruction = startPoint;



        // 1-3 paths going west
        for (int i = 0; i < Rng.rangeInt(1, 3); i++) {
            currentConstruction.setWest(new Path(null, currentConstruction, null, null));
            currentConstruction = currentConstruction.getWest();
        }

        /**
         * Start Making Map
        */

        Tile[][] room1Map = new Tile[][]{
            {tree.clone(), tree.clone(), tree.clone(), tree.clone(), tree.clone()},
            {tree.clone(), tLef.clone(), topp.clone(), tRig.clone(), tree.clone()},
            {exit.clone(), open.clone(), open.clone(Enemy.slime.clone()), open.clone(), exit.clone()},
            {tree.clone(), bLef.clone(), bott.clone(), righ.clone(), tree.clone()},
            {tree.clone(), tree.clone(), tree.clone(), tree.clone(), tree.clone()}
        };

        Container chest1 = new Container("Chest", "A worn chest", 5);

        chest1.addEntity(new Weapon("Rusty Dagger", "An Old dagger with a weird Writing along the blade.", Rarity.ORIDINARY, 1, new int[]{1,3}, new String[]{"You Swing the blade and Hit your Enemy"}, new String[]{"You swing wildly missing your target"}));

        Tile [][] room2Map = {
            {tree.clone(), tree.clone(), exit.clone(), tree.clone(), tree.clone()},
            {tree.clone(), tLef.clone(), topp.clone(), tRig.clone(), tree.clone()},
            {tree.clone(), open.clone(), open.clone(chest1), open.clone(), exit.clone()},
            {tree.clone(), bLef.clone(), tree.clone(), righ.clone(), tree.clone()},
            {tree.clone(), tree.clone(), tree.clone(), tree.clone(), tree.clone()}
        };
        

        Tile[][] room3Map = new Tile[][] {
            {tree.clone(), tree.clone(), tree.clone(), tree.clone(), tree.clone(), tree.clone()},
            {tree.clone(), tLef.clone(), topp.clone(), topp.clone(), tRig.clone(), tree.clone()},
            {exit.clone(), open.clone(), open.clone(), open.clone(Enemy.spider.clone()), righ.clone(), tree.clone()},
            {tree.clone(), left.clone(), open.clone(Potion.healthPotion.clone()), open.clone(), righ.clone(), tree.clone()},
            {tree.clone(), left.clone(), open.clone(Enemy.slime.clone()), open.clone(), righ.clone(), tree.clone()},
            {tree.clone(), left.clone(), open.clone(), open.clone(), righ.clone(), tree.clone()},
            {tree.clone(), bLef.clone(), bott.clone(), open.clone(), bRig.clone(), tree.clone()},
            {tree.clone(), tree.clone(), tree.clone(), exit.clone(), tree.clone(), tree.clone()},
        };

        Container chest2 = new Container("Chest", "A worn chest", 5);

        chest2.addEntity(new Armor("Battered Sheild", "This sheild looks like its seen better days.", 3, Rarity.COMMON));

        Tile[][] room4Map = new Tile[][] {
            {tree.clone(), tree.clone(), tree.clone(), tree.clone(), tree.clone(), tree.clone(), tree.clone(), tree.clone(), exit.clone(), tree.clone(), tree.clone()},
            {tree.clone(), tLef.clone(), topp.clone(), topp.clone(), topp.clone(), topp.clone(), topp.clone(), topp.clone(), open.clone(), tRig.clone(), tree.clone()},
            {tree.clone(), left.clone(), open.clone(Enemy.skeleton.clone()), open.clone(), open.clone(), open.clone(chest2), open.clone(), open.clone(), open.clone(Enemy.skeleton.clone()), righ.clone(), tree.clone()},
            {tree.clone(), bLef.clone(), open.clone(), bott.clone(), bott.clone(), bott.clone(), bott.clone(), bott.clone(), bott.clone(), bRig.clone(), tree.clone()},
            {tree.clone(), tree.clone(), exit.clone(), tree.clone(), tree.clone(), tree.clone(), tree.clone(), tree.clone(), tree.clone(), tree.clone(), tree.clone()},
        };

        Container chest3 = new Container("Chest", "A worn chest", 10);
        chest3.addEntity(new Weapon("Rusty Sword", "A Rusty Sword", Rarity.UNCOMMON, 4, new int[]{5, 8}, new String[]{"You swing your blade and Slash your Target"}, new String[]{"You swing the sword with all your might but your target is to quick and dodges out of the way."}));

        Tile[][] room5Map = new Tile[][] {
            {tree.clone(), tree.clone(), tree.clone(), tree.clone(), tree.clone(), tree.clone(), tree.clone(), tree.clone(), tree.clone(), tree.clone(), tree.clone()},
            {tree.clone(), tLef.clone(), topp.clone(), topp.clone(), topp.clone(), topp.clone(), topp.clone(), topp.clone(), topp.clone(), tRig.clone(), tree.clone()},
            {tree.clone(), left.clone(), open.clone(Enemy.skeleton.clone()), open.clone(), open.clone(), open.clone(), open.clone(), open.clone(Enemy.spider.clone()), open.clone(), righ.clone(Potion.healthPotion.clone()), tree.clone()},
            {tree.clone(), left.clone(), open.clone(), open.clone(), open.clone(), open.clone(Enemy.skeleton.clone()), open.clone(), open.clone(), open.clone(chest3), open.clone(), exit.clone()},
            {tree.clone(), bLef.clone(), open.clone(Enemy.slime.clone()), bott.clone(), bott.clone(), bott.clone(), bott.clone(), bott.clone(), bott.clone(), bRig.clone(), tree.clone()},
            {tree.clone(), tree.clone(), exit.clone(), tree.clone(), tree.clone(), tree.clone(), tree.clone(), tree.clone(), tree.clone(), tree.clone(), tree.clone()},

        };

        /**
         * End Making Map
        */
        Room room1 = new Room(null, currentConstruction, null, null, room1Map, new int[]{4, 2});


        
        currentConstruction.setWest(room1);
        currentConstruction = currentConstruction.getWest();

        if (currentConstruction != room1) {
            throw new Exception("Error ");
        }
        
        //Room1
        currentConstruction.setWest(new Path(null, currentConstruction, null, null));
        //Path from room
        currentConstruction = currentConstruction.getWest();
        
        Room room2 = new Room(null, null, null, null, room2Map, new int[]{4, 2});

        //Path from room 1 set west to room2
        currentConstruction.setWest(room2);
        
        //Set Room east to Path froom room 1 
        room2.setEast(currentConstruction);
        currentConstruction = room2;

        for (int i = 0; i < Rng.rangeInt(2, 3); i++) {
            currentConstruction.setNorth(new Path(null, null, room2, null));
            currentConstruction = currentConstruction.getNorth();
        }

        Room room3 = new Room(null, null, currentConstruction, null, room3Map, new int[]{3, 7});
        currentConstruction.setNorth(room3);

        currentConstruction = room3;

        currentConstruction.setWest(new Path(null, room3, null, null));
        currentConstruction = currentConstruction.getWest();

        for (int i = 0; i < Rng.rangeInt(2, 3); i++) {
            currentConstruction.setNorth(new Path(null, null, currentConstruction, null));
            currentConstruction = currentConstruction.getNorth();
        }

        
        Room room4 = new Room(null, null, currentConstruction, null, room4Map, new int[]{2, 4});
        currentConstruction.setNorth(room4);

        currentConstruction = room4;

        currentConstruction.setNorth(new Path(null, null, currentConstruction, null));
        currentConstruction = currentConstruction.getNorth();

        for (int i = 0; i < Rng.rangeInt(3, 4); i++) {
            currentConstruction.setNorth(new Path(null, null, currentConstruction, null));
            currentConstruction = currentConstruction.getNorth();
        }

        Room room5 = new Room(null, null, currentConstruction, null, room5Map, new int[]{2, 4});

        currentConstruction.setNorth(room5);
        currentConstruction = currentConstruction.getNorth();

        currentConstruction.setWest(new Path(null, currentConstruction, null, null));
        currentConstruction = currentConstruction.getWest();

        for (int i = 0; i < Rng.rangeInt(3, 4); i++) {
            currentConstruction.setWest(new Path(null, currentConstruction, null, null));
            currentConstruction = currentConstruction.getWest();
        }

        return startPoint;

    }
    
}
