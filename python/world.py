from human import Human
from grass import Grass


class World:

    def __init__(self, x, y, spritesize):

        self.organisms = [[0 for x in range(x)] for y in range(y)]
        self.iniList = []
        self.commlist = []
        self.plantlist = ["Beetsoup", "Grass", "Guarana", "Dandelion", "Wolfberries"]
        self.my_x = x
        self.my_y = y
        self.turncounter = 1
        self.isHumanAlive = False
        self.spritesize = spritesize

    def inWorld(self, x, y):

        if x < self.my_x and x >= 0 and y < self.my_y and y >= 0:
            return True
        else:
            return False

    def addNewOrganism(self, org, x, y):

        self.organisms[y][x] = org(x, y, self)
        self.iniList.append(self.organisms[y][x])
        self.commlist.append("New organism: " + self.organisms[y][x].name + ". Coords: " + str(x + 1) + ", " + str(y + 1))

    def deleteOrg(self, org, de):
        if org != 0:
            if type(org) == Human:
                self.isHumanAlive = False
            self.organisms[org.y][org.x] = 0
            self.iniList.remove(org)
            self.commlist.append(de.name + " kills " + org.name + ".")

    def isPlant(self, org):
        if org != 0:
            for i in range(len(self.plantlist)):
                if org.name == self.plantlist[i]:
                    return True
            return False