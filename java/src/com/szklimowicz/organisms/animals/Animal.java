package com.szklimowicz.organisms.animals;

import com.szklimowicz.Field;
import com.szklimowicz.World;
import com.szklimowicz.organisms.Organism;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends Organism {

    public Animal(int x, int y, World world) {
        super(x, y, world);
        setName("Animal");
        setStrength(1);
        setInitiative(1);
    }

    @Override
    public void action() {

        setAge(getAge() + 1);
        int new_x = getX(), new_y = getY();
        int range = getRange();
        int dir = ThreadLocalRandom.current().nextInt(1, 4 + 1);

        switch(dir) {

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
        Class animal_class = this.getClass();

        if(world.inWorldBorders(new_x, new_y)) {
            Field target_field = world.getFields()[new_y][new_x];
            if (target_field.getOrganism() == null) {
                target_field.setOrganism(this);
                world.getFields()[getY()][getX()].setOrganism(null);
                setX(new_x);
                setY(new_y);
            }
            else if (animal_class.isInstance(target_field.getOrganism())) {
                breed(animal_class, world);
            }
            else collisionAttack(this, target_field.getOrganism());
        }
    }

    private void breed(Class animal_class, World world) {
        if(Math.random() > 0.5) {

            int new_x = getX(), new_y = getY();
            int dir = ThreadLocalRandom.current().nextInt(1, 4 + 1);

            switch(dir) {

                case LEFT:
                    new_x--;
                    break;
                case RIGHT:
                    new_x++;
                    break;
                case UP:
                    new_y--;
                    break;
                case DOWN:
                    new_y++;
                    break;
            }

            if(world.inWorldBorders(new_x, new_y)) {
                if(world.getFields()[new_y][new_x].getOrganism() == null) {
                    try {
                        Organism org = (Organism) animal_class.getDeclaredConstructor(int.class, int.class, World.class).newInstance(new_x, new_y, world);
                        world.addNewOrganism(org);
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}
