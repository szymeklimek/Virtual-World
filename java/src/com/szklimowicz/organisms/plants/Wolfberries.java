package com.szklimowicz.organisms.plants;

import com.szklimowicz.MyConsts;
import com.szklimowicz.World;

public class Wolfberries extends Plant {

    public Wolfberries(int x, int y, World world) {
        super(x, y, world);
        setName("Wolfberries");
        setStrength(99);
        setIcon(MyConsts.WOLFBERRIES_SPRITE);
    }
}
