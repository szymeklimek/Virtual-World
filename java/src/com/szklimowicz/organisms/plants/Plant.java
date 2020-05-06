package com.szklimowicz.organisms.plants;

import com.szklimowicz.Field;
import com.szklimowicz.World;
import com.szklimowicz.organisms.Organism;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Plant extends Organism {

    public Plant(int x, int y, World world) {
        super(x, y, world);
        setName("Plant");
        setStrength(0);
        setInitiative(0);
    }

    @Override
    public void action() {
        if (Math.random() >= 0.96) {
            int new_x = getX(), new_y = getY();
            int range = getRange();
            int dir = ThreadLocalRandom.current().nextInt(1, 4 + 1);

            switch (dir) {

                case LEFT:
                    new_x -= range;
                    break;
                case RIGHT:
                    new_x += range;
                    break;
                case UP:
                    new_y -= range;
                    break;
                case DOWN:
                    new_y += range;
                    break;
            }

            World world = getWorld();
            Class plant_class = this.getClass();
            if (world.inWorldBorders(new_x, new_y)) {
                if (world.getFields()[new_y][new_x].getOrganism() == null) {
                    try {
                        Organism org = (Organism) plant_class.getDeclaredConstructor(int.class, int.class, World.class).newInstance(new_x, new_y, world);
                        world.addNewOrganism(org);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}
