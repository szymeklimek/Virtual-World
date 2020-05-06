package com.szklimowicz.organisms.animals;

import com.szklimowicz.MyConsts;
import com.szklimowicz.World;

public class Human extends Animal {

    public Human(int x, int y, World world) {
        super(x, y, world);
        setName("Human");
        setInitiative(4);
        setStrength(5);
        setIcon(MyConsts.HUMAN_SPRITE);
    }
}
