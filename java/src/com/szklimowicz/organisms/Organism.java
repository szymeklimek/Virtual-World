package com.szklimowicz.organisms;

import com.szklimowicz.World;

import javax.swing.*;

public abstract class Organism {

    protected static final int LEFT = 1;
    protected static final int RIGHT = 2;
    protected static final int UP = 3;
    protected static final int DOWN = 4;

    private int x;
    private int y;
    private int age = 1;
    private int range = 1;
    private String name;
    private int strength;
    private int initiative;
    private ImageIcon icon;
    private World world;
    private boolean isAlive = true;

    public Organism(int x, int y, World world) {
        this.x = x;
        this.y = y;
        this.world = world;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAge() {
        return age;
    }

    public int getRange() {
        return range;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getInitiative() {
        return initiative;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public World getWorld() {
        return world;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public abstract void action();

    public boolean collisionAttack(Organism attacker, Organism defender) { // boolean, returns the outcome (successful or not)
        if(attacker.getStrength() >= defender.getStrength()) {
            if(!defender.collisionDefend(attacker, defender)) { // couldn't defend, has no defend action, or a special case (guarana)
                world.getFields()[attacker.getY()][attacker.getX()].setOrganism(null);
                attacker.setX(defender.getX());
                attacker.setY(defender.getY());
                world.deleteOrganism(defender);
                world.getFields()[defender.getY()][defender.getX()].setOrganism(attacker);
                return true;
            }
            else return false;
        }
        else {
            defender.collisionAttack(defender, attacker);
            return false;
        }
    }

    public boolean collisionDefend(Organism attacker, Organism defender) { // false - organism failed to defend
        return false;
    }
}
