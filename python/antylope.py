import pygame
from random import randint
from animal import Animal

class Antylope(Animal):
   
    def __init__(self, x, y, world):
        super().__init__(x, y, world)
        self.name = "Antylope"
        self.initiative = 4
        self.strength = 4
        self.moverange = 2
        self.img = pygame.image.load('sprites/anty.png')

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

        self.moverange = 2

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

    def altCollision(self, att, de):
        self.moverange = 1
        i = randint(1, 2)
        if i:
            self.action(0)
        else:
            self.moverange = 2
        return False

