class Organism:
   
    def __init__(self, x, y, world):

        self.name=""
        self.x = x
        self.y = y
        self.age = 1
        self.moverange = 1
        self.ID = self.x*23 + self.y
        self.world = world
        self.strength=0
        self.initiative=0

    def collision(self, att, de):

        if att.strength >= de.strength:
            if de.altCollision(att, de):
                self.world.deleteOrg(de, att)
                self.world.organisms[de.y][de.x] = self.world.organisms[att.y][att.x]
                self.world.organisms[att.y][att.x] = 0
                att.x = de.x
                att.y = de.y
                att.ID = att.x*23 + att.y
                return True
            else:
                if att.strength < de.strength:
                    self.world.deleteOrg(att, de)
                    return False
                else:
                    return False
        else:
            de.altCollision(att, de)
            return False

    def altCollision(self, att, de):
        return True