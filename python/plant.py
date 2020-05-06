from organism import Organism

from random import randint

class Plant(Organism):

    def __init__(self, x, y, world):
        super().__init__(x, y, world)
        self.name = "Plant"

    def action(self, null):

        dir = randint(1,100)

        new_x = self.x
        new_y = self.y

        if(dir == 1):
            new_y = self.y - self.moverange
        if(dir == 2):
            new_y = self.y + self.moverange
        if(dir == 3):
            new_x = self.x - self.moverange
        if(dir == 4):
            new_x = self.x + self.moverange
        
        if new_x != self.x or new_y != self.y:
            if self.world.inWorld(new_x, new_y):
                if self.world.organisms[new_y][new_x] == 0:
                    self.world.addNewOrganism(type(self), new_x, new_y)