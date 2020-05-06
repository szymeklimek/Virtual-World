import pygame

from animal import Animal

class Human(Animal):

    def __init__(self, x, y, world):
        super().__init__(x, y, world)
        self.name = "Human"
        self.initiative = 4
        self.strength = 5
        self.world.isHumanAlive = True
        self.img = pygame.image.load('sprites/czl.png')

    def action(self, dir):

        new_x = self.x
        new_y = self.y

        if(dir == pygame.K_UP):
            new_y = self.y - self.moverange
        if(dir == pygame.K_DOWN):
            new_y = self.y + self.moverange
        if(dir == pygame.K_LEFT):
            new_x = self.x - self.moverange
        if(dir == pygame.K_RIGHT):
            new_x = self.x + self.moverange

        if new_x != self.x or new_y != self.y:
            if self.world.inWorld(new_x, new_y):
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
        else:
            return

    def special(self):

         for x in range(-1, 2, 1):
            for y in range(-1, 2, 1):
                if(x != 0 or y != 0):
                    self.world.deleteOrg(self.world.organisms[self.y + y][self.x + x], self)