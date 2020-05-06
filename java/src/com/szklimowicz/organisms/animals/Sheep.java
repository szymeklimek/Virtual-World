package com.szklimowicz.organisms.animals;

import com.szklimowicz.MyConsts;
import com.szklimowicz.World;

public class Sheep extends Animal {

    public Sheep(int x, int y, World world) {
        super(x, y, world);
        setName("Sheep");
        setInitiative(4);
        setStrength(4);
        setIcon(MyConsts.SHEEP_SPRITE);
    }
}
