package Model;

import java.util.*;

import Util.Generating;
import Util.Rarity;
import Util.Rng;


public class Map {

    

    //Variables
    private String name;

    private Construction startPoint;
    private Construction currentConst;
    

    //Lists 
    private Tile[][] currentRoomMap;

    //private List<Enemy> enemyList;



    public Map(String name) {
        this.name = name;
        //this.enemyList = enemylist;
        this.currentRoomMap = null;
        
        

    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Construction getCurrentConstruction() {
        return this.currentConst;
    }


    public int getXDimension() {
        return currentRoomMap[0].length;
    }

    public int getYDimension() {
        return currentRoomMap.length;
    }


    public Tile getTile(int x, int y) {
        return currentRoomMap[x][y]; 
    }

    public void setTile(int x, int y, Tile tile) {
        currentRoomMap[x][y] = tile;
    }



    public void goNorth() {
        currentConst = currentConst.getNorth();

    }

    public void goEasth() {
        currentConst = currentConst.getNorth();

    }

    public void goSouth() {
        currentConst = currentConst.getNorth();

    }

    public void goWest() {
        currentConst = currentConst.getNorth();

    }

    

}

