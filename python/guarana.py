import pygame

from plant import Plant

class Guarana(Plant):

    def __init__(self, x, y, world):
        super().__init__(x, y, world)
        self.name = "Guarana"
        self.initiative = 0
        self.strength = 0
        self.img = pygame.image.load('sprites/guarana.png')

    def altCollision(self, att, de):
        att.strength += 3
        return True