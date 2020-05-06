package com.szklimowicz;

import com.szklimowicz.organisms.Organism;

public class Field {

    private int x;
    private int y;
    private Organism organism;

    public Field(int x, int y, Organism organism) {
        this.x = x;
        this.y = y;
        this.organism = organism;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Organism getOrganism() {
        return organism;
    }

    public void setOrganism(Organism organism) {
        this.organism = organism;
    }
}
