import pygame

from cybersheep import Cybersheep
from plant import Plant

class Beetsoup(Plant):

    def __init__(self, x, y, world):
        super().__init__(x, y, world)
        self.name = "Beetsoup"
        self.initiative = 0
        self.strength = 10
        self.img = pygame.image.load('sprites/barszcz.png')

    def special(self):

        for i in range(-1, 2, 1):
            for j in range(-1, 2, 1):
                if self.world.inWorld(self.y + i, self.x + j):
                    if not type(self.world.organisms[self.y + i][self.x + j]) == Cybersheep:
                        if not self.world.isPlant(self.world.organisms[self.y + i][self.x + j]):
                            self.world.deleteOrg(self.world.organisms[self.y + i][self.x + j], self)

    def altCollision(self, att, de):

        if not type(att) == Cybersheep :
            self.world.deleteOrg(att, de)
        self.world.deleteOrg(de, att)
        return False