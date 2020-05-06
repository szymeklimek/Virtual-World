package com.szklimowicz.organisms.plants;

import com.szklimowicz.MyConsts;
import com.szklimowicz.World;

public class Borscht extends Plant {

    public Borscht(int x, int y, World world) {
        super(x, y, world);
        setName("Borscht");
        setStrength(10);
        setIcon(MyConsts.BORSCHT_SPRITE);
    }

    //TODO borscht logic - destroy around
}
