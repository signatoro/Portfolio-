package Model;

import Util.Global;

public class Tile {
    private String name;
    private String responce;
    public boolean valid;
    private Enemy enemy;
    private Entity entity;
    private Event event;
    

    public Tile(String name, String responce, boolean valid, Enemy enemy, Entity entity, Event event) {
        this.name = name;
        this.responce = responce;
        this.enemy = enemy;
        this.entity = entity;
        this.event = event;
        this.valid = valid;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }


    public String getResponce() {
        return this.responce; 
    }

    public void setResponce(String responce) {
        this.responce = responce;
    }


    public boolean getValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }




    public Enemy getEnemy() {
        return this.enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }


    public Entity getEntity() {
        return this.entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }


    public Event getEvent() {
        return this.event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }


    public Tile clone() {
        return new Tile(name, responce, valid, enemy, entity, event);
    }

    public Tile clone(Enemy enemy) {
        return new Tile(name, responce, valid, enemy, entity, event);
    }

    public Tile clone(Entity entity) {
        return new Tile(name, responce, valid, enemy, entity, event);
    }

    public Tile clone(Event event) {
        return new Tile(name, responce, valid, enemy, entity, event);
    }

    public Tile clone(Enemy enemy, Entity entity) {
        return new Tile(name, responce, valid, enemy, entity, event);
    }

    public Tile clone(Enemy enemy, Event event) {
        return new Tile(name, responce, valid, enemy, entity, event);
    }

    public Tile clone(Entity entity, Event event) {
        return new Tile(name, responce, valid, enemy, entity, event);
    }

    public Tile clone(Enemy enemy, Entity entity, Event event) {
        return new Tile(name, responce, valid, enemy, entity, event);
    }

    public void message() {
        Global.view.printText(responce);
    }


}
