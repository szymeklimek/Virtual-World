import pygame

from plant import Plant

class Wolfberries(Plant):

    def __init__(self, x, y, world):
        super().__init__(x, y, world)
        self.name = "Wolfberries"
        self.initiative = 0
        self.strength = 99
        self.img = pygame.image.load('sprites/jagoda.png')

    def altCollision(self, att, de):
        self.world.deleteOrg(att, de)
        self.world.deleteOrg(de, att)
        return False