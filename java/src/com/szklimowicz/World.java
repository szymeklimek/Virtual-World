package com.szklimowicz;

import com.szklimowicz.organisms.Organism;
import com.szklimowicz.organisms.animals.*; // need ALL classes
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class World {

    private int x;
    private int y;
    private boolean isHumanAlive = false;
    private Field[][] fields;
    private List<Organism> initiativeList = new ArrayList<>();
    private List<Organism> newOrgList = new ArrayList<>();
    private List<Organism> deleteList = new ArrayList<>();


    public World() {
        this.x = 20;
        this.y = 20;
        this.fields = new Field[y][x];
    }
    public World(int x, int y) {
        this.x = x;
        this.y = y;
        this.fields = new Field[y][x];
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Field[][] getFields() {
        return fields;
    }

    public List<Organism> getInitiativeList() {
        return initiativeList;
    }

    public List<Organism> getSortedInitiativeList() {
        initiativeList.sort(Comparator.comparing(Organism::getInitiative).reversed());
        return initiativeList;
    }

    public List<Organism> getNewOrgList() {
        return newOrgList;
    }

    public List<Organism> getDeleteList() {
        return deleteList;
    }

    public boolean inWorldBorders(int x, int y) {
        if(x < this.x && x >= 0 && y < this.y && y >= 0) return true;
        else return false;
    }

    public void addNewOrganism(Organism org) {
        int x = org.getX();
        int y = org.getY();
        fields[y][x].setOrganism(org);
        newOrgList.add(org);
    }

    public void deleteOrganism(Organism org) {
        if(org != null) {
            if(org instanceof Human) isHumanAlive = false;
            fields[org.getY()][org.getX()].setOrganism(null);
            org.setIsAlive(false);
        }
    }
}
