from organism import Organism
from random import randint

class Animal(Organism):
        
    def __init__(self, x, y, world):
        super().__init__(x, y, world)
        self.name = "Animal"

    def action(self, null):

        dir = randint(1,4)

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


        if self.world.inWorld(new_x, new_y):
            if type(self) == type(self.world.organisms[new_y][new_x]):
                self.breed(type(self))
                return
            else:
               if self.world.organisms[new_y][new_x] == 0:
                   self.world.organisms[new_y][new_x] = self.world.organisms[self.y][self.x]
                   self.world.organisms[self.y][self.x] = 0
                   self.x = new_x
                   self.y = new_y
                   self.ID = new_x*23 + new_y
               else:
                   if self.collision(self, self.world.organisms[new_y][new_x]):
                      return
                   else:
                       return

    def breed(self, type):

        breedchance = randint(0,1)

        if breedchance:
            dir = randint(1,4)

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
        
            if self.world.inWorld(new_x, new_y):
                if self.world.organisms[new_y][new_x] == 0:
                    self.world.addNewOrganism(type, new_x, new_y)