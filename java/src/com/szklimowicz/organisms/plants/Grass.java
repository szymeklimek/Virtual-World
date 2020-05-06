package com.szklimowicz.organisms.plants;

import com.szklimowicz.MyConsts;
import com.szklimowicz.World;

public class Grass extends Plant {

    public Grass(int x, int y, World world) {
        super(x, y, world);
        setName("Grass");
        setIcon(MyConsts.GRASS_SPRITE);
    }
}
