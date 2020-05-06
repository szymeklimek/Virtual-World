import pygame
from animal import Animal

class Sheep(Animal):
    
    def __init__(self, x, y, world):
        super().__init__(x, y, world)
        self.name = "Sheep"
        self.initiative = 4
        self.strength = 4
        self.img = pygame.image.load('sprites/owca.png')


