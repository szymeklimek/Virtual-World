package com.szklimowicz.organisms.animals;

import com.szklimowicz.MyConsts;
import com.szklimowicz.World;
import com.szklimowicz.organisms.Organism;

public class Antylope extends Animal {

    public Antylope(int x, int y, World world) {
        super(x, y, world);
        setName("Antylope");
        setInitiative(4);
        setStrength(4);
        setRange(2);
        setIcon(MyConsts.ANTYLOPE_SPRITE);
    }

    @Override
    public boolean collisionDefend(Organism attacker, Organism defender) {
        if(Math.random() > 0.5) {
            setRange(1);
            action();
            setRange(2);
            return true;
        }
        else {
            return super.collisionDefend(attacker, defender);
        }
    }
}
