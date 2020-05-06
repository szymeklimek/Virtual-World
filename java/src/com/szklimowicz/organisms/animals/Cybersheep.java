package com.szklimowicz.organisms.animals;

import com.szklimowicz.MyConsts;
import com.szklimowicz.World;

public class Cybersheep extends Animal {

    public Cybersheep(int x, int y, World world) {
        super(x, y, world);
        setName("Cybersheep");
        setInitiative(4);
        setStrength(11);
        setIcon(MyConsts.CYBERSHEEP_SPRITE);
    }
    //TODO cybersheep logic
}
