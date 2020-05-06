import pygame
import math
from animal import Animal

class Cybersheep(Animal):
    
    def __init__(self, x, y, world):
        super().__init__(x, y, world)
        self.name = "Cybersheep"
        self.initiative = 4
        self.strength = 11
        self.img = pygame.image.load('sprites/cyber.png')

    def action(self, null):
        prevpath = 0
        path = 0
        current_x = -1
        current_y = -1
        for i in range(len(self.world.iniList)):
            if self.world.iniList[i].name == "Beetsoup":

                if not prevpath:
                    current_x = self.world.iniList[i].x
                    current_y = self.world.iniList[i].y
                    prevpath = math.sqrt((self.x - current_x)**2 + (self.y - current_y)**2)
                path = math.sqrt((self.x - self.world.iniList[i].x)**2 + (self.y - self.world.iniList[i].y)**2)

                if prevpath > path:
                    prevpath = path
                    current_x = self.world.iniList[i].x
                    current_y = self.world.iniList[i].y

        new_x = self.x
        new_y = self.y

        if current_x != -1 and current_y != -1:
            if(new_y > current_y):
                new_y = self.y - self.moverange
            if(new_y < current_y):
                new_y = self.y + self.moverange
            if(new_x > current_x):
                new_x = self.x - self.moverange
            if(new_x < current_x):
                new_x = self.x + self.moverange
        else:
            super().action(null)
            return

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