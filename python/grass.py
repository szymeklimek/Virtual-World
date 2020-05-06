import pygame

from plant import Plant

class Grass(Plant):

    def __init__(self, x, y, world):
        super().__init__(x, y, world)
        self.name = "Grass"
        self.initiative = 0
        self.strength = 0
        self.img = pygame.image.load('sprites/trawa.png')