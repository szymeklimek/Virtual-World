package com.szklimowicz.organisms.animals;

import com.szklimowicz.MyConsts;
import com.szklimowicz.World;

public class Wolf extends Animal {

    public Wolf(int x, int y, World world) {
        super(x, y, world);
        setName("Wolf");
        setStrength(9);
        setInitiative(5);
        setIcon(MyConsts.WOLF_SPRITE);
    }
}
