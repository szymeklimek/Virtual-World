package com.szklimowicz.organisms.animals;

import com.szklimowicz.MyConsts;
import com.szklimowicz.World;
import com.szklimowicz.organisms.Organism;

public class Turtle extends Animal {

    public Turtle(int x, int y, World world) {
        super(x, y, world);
        setName("Turtle");
        setInitiative(1);
        setStrength(2);
        setIcon(MyConsts.TURTLE_SPRITE);
    }

    @Override
    public void action() {
        if(Math.random() >= 0.75) super.action();
    }

    @Override
    public boolean collisionDefend(Organism attacker, Organism defender) {
        if(attacker.getStrength() <= 5) return true;
        else return super.collisionDefend(attacker, defender);
    }
}
