package com.szklimowicz.organisms.animals;

import com.szklimowicz.MyConsts;
import com.szklimowicz.World;
import com.szklimowicz.organisms.Organism;

public class Fox extends Animal {

    public Fox(int x, int y, World world) {
        super(x, y, world);
        setName("Fox");
        setInitiative(7);
        setStrength(3);
        setIcon(MyConsts.FOX_SPRITE);
    }

    @Override
    public boolean collisionAttack(Organism attacker, Organism defender) {
        if (attacker.getStrength() >= defender.getStrength() || Math.random() > 0.9)
            return super.collisionAttack(attacker, defender);
        else return false;
    }
}
