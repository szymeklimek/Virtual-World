package com.szklimowicz.organisms.plants;

import com.szklimowicz.MyConsts;
import com.szklimowicz.World;
import com.szklimowicz.organisms.Organism;

public class Guarana extends Plant {

    public Guarana(int x, int y, World world) {
        super(x, y, world);
        setName("Guarana");
        setIcon(MyConsts.GUARANA_SPRITE);
    }

    @Override
    public boolean collisionDefend(Organism attacker, Organism defender) {
        attacker.setStrength(attacker.getStrength() + 3);
        return super.collisionDefend(attacker, defender);
    }
}
