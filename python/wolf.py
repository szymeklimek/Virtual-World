import pygame
from animal import Animal

class Wolf(Animal):
    
    def __init__(self, x, y, world):
        super().__init__(x, y, world)
        self.name = "Wolf"
        self.initiative = 5
        self.strength = 9
        self.img = pygame.image.load('sprites/wilk.png')