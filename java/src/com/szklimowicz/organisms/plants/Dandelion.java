package com.szklimowicz.organisms.plants;

import com.szklimowicz.MyConsts;
import com.szklimowicz.World;

public class Dandelion extends Plant {

    public Dandelion(int x, int y, World world) {
        super(x, y, world);
        setName("Dandelion");
        setIcon(MyConsts.DANDELION_SPRITE);
    }

    @Override
    public void action() {
        int newCount = getWorld().getNewOrgList().size();
        for(int i = 0; i < 3; i++){
            super.action();
            if(newCount < getWorld().getNewOrgList().size()) break;
        }
    }
}
