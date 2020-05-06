import pygame

from world import World
from wolf import Wolf
from grass import Grass
from human import Human
from sheep import Sheep
from dandelion import Dandelion
from turtle import Turtle
from fox import Fox
from antylope import Antylope
from cybersheep import Cybersheep
from guarana import Guarana
from wolfberries import Wolfberries
from beetsoup import Beetsoup
from organism import Organism

pygame.init()

spritesize = 30
specialcounter = 0

my_x = 20
my_y = 20

grid = [[0 for x in range(my_x)] for y in range(my_y)]

orgbuttons = []

spritelist = [pygame.image.load('sprites/anty.png'), pygame.image.load('sprites/barszcz.png'), pygame.image.load('sprites/cyber.png'), pygame.image.load('sprites/guarana.png') ,pygame.image.load('sprites/jagoda.png') ,pygame.image.load('sprites/lis.png') ,pygame.image.load('sprites/mlecz.png') ,pygame.image.load('sprites/owca.png') ,pygame.image.load('sprites/trawa.png') ,pygame.image.load('sprites/wilk.png') ,pygame.image.load('sprites/zolw.png')]

orglist = [Antylope, Beetsoup, Cybersheep, Guarana, Wolfberries, Fox, Dandelion, Sheep, Grass, Wolf, Turtle]

world = World(my_x, my_y, spritesize)

gamebarwidth = 11*spritesize
gamewidth = (spritesize + 2)*my_x + 2 + gamebarwidth
gameheight = (spritesize + 2)*my_y + 2

white = (255, 255, 255)
black = (0, 0, 0)
smth = (100, 100, 100)

font = pygame.font.SysFont('Arial', 18)
font1 = pygame.font.SysFont('Arial', 16)

gameDisplay = pygame.display.set_mode((gamewidth, gameheight))
pygame.display.set_caption('Symulator Swiata - Python')
gameDisplay.fill((smth))

clock = pygame.time.Clock()

for i in range(11):
    orgbuttons.append(gameDisplay.blit(spritelist[i], (gamewidth - gamebarwidth + i*spritesize, 200)))

back1 = pygame.Rect(gamewidth - gamebarwidth, 0, gamebarwidth, gameheight/3)
back2 = pygame.Rect(gamewidth - gamebarwidth, gameheight/3, gamebarwidth, 2*(gameheight/3))
button1 = pygame.Rect(gamewidth - gamebarwidth + 55, 50, 100, 50)
button2 = pygame.Rect(gamewidth - gamebarwidth + 195, 50, 100, 50)

def drawTextArea(my_x, my_y):

        pygame.draw.rect(gameDisplay, black, back1)
        pygame.draw.rect(gameDisplay, white, back2) 
        pygame.draw.rect(gameDisplay, white, button1)
        pygame.draw.rect(gameDisplay, white, button2)
        gameDisplay.blit(font.render('Tura: ' + str(world.turncounter), True, white), (gamewidth - gamebarwidth + 2, 10))
        gameDisplay.blit(font.render('Nowa Tura', True, black), (gamewidth - gamebarwidth + 60, 65))
        gameDisplay.blit(font.render('Umiejetnosc', True, black), (gamewidth - gamebarwidth + 197, 65))
        for i in range(11):
            gameDisplay.blit(spritelist[i], (gamewidth - gamebarwidth + i*spritesize, 200))

def drawGrid(world):

    gameDisplay.fill((smth))

    for i in range(world.my_y):
        for j in range(world.my_x):

            my_img = pygame.image.load('sprites/null.png')

            if world.organisms[i][j] != 0:
                my_img = world.organisms[i][j].img

            grid[i][j] = gameDisplay.blit(my_img, (2 + j*(spritesize+2),2 + i*(spritesize+2)))

def drawGame():
    drawGrid(world)
    drawTextArea(my_x,my_y)
    for i in range(len(world.commlist)):
        gameDisplay.blit(font1.render(str(i + 1) + ". " + world.commlist[i], True, black), (gamewidth - gamebarwidth + 2, 250 + i*20))

def takeTurn(key):

    world.commlist.clear()
    world.iniList.sort(key=lambda Organism: Organism.initiative, reverse = True)

    k = 0

    global specialcounter

    if specialcounter > 0:
        specialcounter += 1
    if specialcounter == 10:
        specialcounter = 0

    while True:
        world.iniList[k].action(key)
        if specialcounter > 0 and specialcounter < 6 and type(world.iniList[k]) == Human:
            world.iniList[k].special()
        if type(world.iniList[k]) == Beetsoup:
            world.iniList[k].special()
        ran = len(world.iniList) - 1
        k += 1
        if k >= ran + 1:
            break
    world.turncounter += 1

crashed = False;

world.addNewOrganism(Human, 10, 10)

while not crashed:

    for event in pygame.event.get():
        
        if event.type == pygame.QUIT:
            crashed = True
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_q:
                crashed = True
            if event.key == pygame.K_r:
                takeTurn(event.key)
            if event.key == pygame.K_n:
                specialcounter = 0
                world.turncounter = 1
                world.iniList.clear()
                for i in range(world.my_y):
                    for j in range(world.my_x):
                        world.organisms[i][j] = 0
                world.addNewOrganism(Human, 10, 10)
                for i in range(world.my_y):
                    for j in range(world.my_x):
                        grid[i][j] = 0
            if event.key == pygame.K_UP:
                takeTurn(event.key)
            if event.key == pygame.K_DOWN:
                takeTurn(event.key)
            if event.key == pygame.K_LEFT:
                takeTurn(event.key)
            if event.key == pygame.K_RIGHT:
                takeTurn(event.key)
        if event.type == pygame.MOUSEBUTTONDOWN:
             mouse_pos = event.pos
             if button1.collidepoint(mouse_pos):
                 takeTurn(event.type)
             if button2.collidepoint(mouse_pos):
                 if world.isHumanAlive:
                     j = 0
                     while True:
                        if type(world.iniList[j]) == Human:
                            if not specialcounter:
                                specialcounter += 1
                                world.iniList[j].special()
                            break
                        ran = len(world.iniList) - 1
                        j += 1
                        if j >= ran + 1:
                            break
             for i in range(11):
                 if orgbuttons[i].collidepoint(mouse_pos):
                     current = orglist[i]
             for i in range(world.my_y):
                for j in range(world.my_x):
                    if grid[i][j].collidepoint(mouse_pos) and world.organisms[i][j] == 0:
                         try:
                            current
                         except NameError:
                             print('undefined organism')
                         else:
                            world.addNewOrganism(current, j, i)
    
    drawGame()
    pygame.display.update()
    clock.tick(30)

pygame.quit()
