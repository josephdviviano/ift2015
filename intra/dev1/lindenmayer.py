# -*- coding: utf-8 -*-
"""
Created on Sat Sep 30 16:54:56 2017

@author: Chin-Wei Huang

devoir 1
"""



import turtle
import math
import random
cos = lambda angle: math.cos(2*math.pi*angle/360.)
sin = lambda angle: math.sin(2*math.pi*angle/360.)


class Turtle(object):
    
    states = list()
    drawn = list()
    
    def __init__(self,x0=0.,y0=0.,theta0=90.,todraw=True):
        self.x = x0
        self.y = y0
        self.theta = theta0
        
        if todraw:
            pen = turtle.Turtle()
            pen.ht()
            pen.speed(0)
            pen.pencolor('blue')        
            self.pen = pen
        self.todraw = todraw
        
        self.xmin = self.x
        self.xmax = self.x
        self.ymin = self.y
        self.ymax = self.y
        
    def getPosition(self):
        return (self.x,self.y)
    
    def getAngle(self):
        return self.theta
        
    def setUnits(self,step,delta):
        self.step = step
        self.delta = delta
        
    def reinit(self,x0=0.,y0=0.,theta0=90.):
        self.x = x0
        self.y = y0
        self.theta = theta0
        
        self.xmin = self.x
        self.xmax = self.x
        self.ymin = self.y
        self.ymax = self.y
        
    
    def draw(self):
        oldx, oldy = self.x, self.y
        self.move()
        newx, newy = self.x, self.y
        #self.drawn.append( 
        #    ((oldx,oldy),(newx,newy))
        #)
        
        if self.todraw:
            self.pen.up()
            self.pen.goto(oldx,oldy)
            self.pen.down()
            self.pen.goto(newx,newy)
        
        if newx < self.xmin:
            self.xmin = newx
        if newx > self.xmax:
            self.xmax = newx
        if newy < self.ymin:
            self.ymin = newy
        if newy > self.ymax:
            self.ymax = newy
        
        
    def move(self):
        self.x += self.step * cos(self.theta)
        self.y += self.step * sin(self.theta)
        
    
    def turnL(self):
        self.theta += self.delta
    
    def turnR(self):
        self.theta -= self.delta
    
    def push(self):
        self.states.append((self.x,self.y,self.theta))
    
    def pop(self):
        self.x, self.y, self.theta = self.states.pop()
    
    def stay(self):
        pass
    

class Actions(object):

    def execute(self,sym):
        return getattr(self,sym)
    
    
class LSystem(object):
    
    def __init__(self):
        self.axiom = None
        self.actions = Actions()
        self.alphabet = list()
        self.rules = dict()
        
        
    def addSymbol(self,sym):
        # add a symbol to the alphabet and return the associated symbol
        self.alphabet.append(sym)
        setattr(self.actions,sym,None)
        return sym
    
    def addRule(self,sym, expansion):
        # add the rule: sym -> expansion
        if sym not in self.rules.keys():
            self.rules[sym] = list()
            
        # set of rules: not repeated (deprecated)
        # if expansion not in self.rules[sym]: 
        #     self.rules[sym].append(expansion) 
            
        # can be repeated
        self.rules[sym].append(expansion)
    
    def setAction(self, sym, action):
        # define the action of the turtle for the given symbol
        setattr(self.actions,sym,action)
    
    def setAxiom(self,string):
        # store the axiom
        self.axiom = [string]
    
    def getAxiom(self):
        # retrieve the symbol / return an iterator
        pass
    
    def rewrite(self,sym):
        # return the replacement according to one rule chosen at random among 
        # those with `sym` to the left, or return None if no rules apply
        if sym in self.rules.keys():
            chosen = random.choice(self.rules[sym])
            for c in chosen:
                yield c
        else:
            yield sym
    
    def tell(self, turtle, sym, n=1):
        # ask the turtle to execute the instruction (Action) 
        # associated with `sym`
        for to_execute in self.applyRules(sym,n):
            #print to_execute, self.actions.execute(to_execute)
            executable = getattr(turtle,self.actions.execute(to_execute))
            executable()
            
    
    def applyRules(self,seq, n=1):
        for s in seq:
            replaced = self.rewrite(s)
            for r in replaced:
                if n == 1:
                    yield r
                else:
                    for new in self.applyRules(r,n-1):
                        yield new
        
    def readJSONFile(self, filename, turtle):
        import json
        data = json.load(open(filename,'r'))
        self.setAxiom(data['axiom'])
        x0,y0,theta0 = map(float,data['parameters']['start'])
        turtle.reinit(x0,y0,theta0)  # -300 to relocate 
                                              # to the bottom of the screen
        turtle.setUnits(float(data['parameters']['step']),
                        float(data['parameters']['angle']))
        for sym in data['alphabet']:
            self.addSymbol(sym)
        for k,v in data['actions'].items():
            self.setAction(k,v)
        for k,rules in data['rules'].items():
            for rule in rules:
                self.addRule(k,rule)
        
    def getBoundingBox(self, turt, seq, n=1):
        for to_execute in self.applyRules(seq,n):
            executable = getattr(turt,self.actions.execute(to_execute))
            executable()
        return turt.xmin, turt.ymin, turt.xmax, turt.ymax
            
    
        

def dumpJsonExample(tosave=1):
    if tosave == 1:
        tosave = {
            "alphabet": ["F", 
                         "[", 
                         "]", 
                         "+", 
                         "-"],
            "rules": {"F" : ["F[+F]F[-F]F",
                             "F[+F]F",
                             "F[+F]F[-F]F"]},
            "axiom": "F",
            "actions": {"F":"draw", 
                        "[":"push",
                        "]":"pop", 
                        "+":"turnR", 
                        "-":"turnL"},
            "parameters" : {"step": 2, 
                            "angle":25.0, 
                            "start":[0,0,90]}
        }
    elif tosave == 2:
        tosave = {
            "alphabet": ["F", 
                         "[", 
                         "]", 
                         "+", 
                         "-",
                         "X"],
            "rules": {"X" : ["F[-X][X]F[-X]+FX"],
                      "F" : ["FF"]},
            "axiom": "X",
            "actions": {"F":"draw", 
                        "[":"push",
                        "]":"pop", 
                        "+":"turnR", 
                        "-":"turnL",
                        "X":"stay"},
            "parameters" : {"step": 2, 
                            "angle":25.0, 
                            "start":[0,0,60.]}
        }
    elif tosave == 3:
        tosave = {
            "alphabet": ["A",
                         "B"],
            "rules": {"A" : ["B-A-B"],
                      "B" : ["A+B+A"]},
            "axiom": "A",
            "actions": {"A":"draw", 
                        "B":"draw",
                        "+":"turnL", 
                        "-":"turnR"},
            "parameters" : {"step": 2, 
                            "angle":60.0, 
                            "start":[0,0,60.]}
        }
    elif tosave == 4:
        tosave = {
            "alphabet": ["X",
                         "Y"],
            "rules": {"X" : ["X+YF+"],
                      "Y" : ["-FX-Y"]},
            "axiom": "FX",
            "actions": {"F":"draw", 
                        "-":"turnL",
                        "+":"turnR", 
                        "X":"stay",
                        "Y":"stay"},
            "parameters" : {"step": 2, 
                            "angle":90.0, 
                            "start":[0,0,90.]}
        }
    import json
    json.dump(tosave,open('example.json','w'))

if __name__ == '__main__':
    
    dumpJsonExample(2)
    
    
    # initializing and read file
    first_turtle = Turtle()
    lsystem = LSystem()
    lsystem.readJSONFile('example.json',first_turtle)
    
    
    # example
    n = int(raw_input('number of layers [default 4]: ') or 4)
    start = lsystem.axiom
    print 'testing `applyRules`, rounds: %i, start from `%s`:' %(2,start)
    print   
    seq = ''
    for j in lsystem.applyRules(start,2):
        seq += j
    print 'result: %s' %seq
    
    
    # get bounding box example
    random.seed(427)
    second_turtle = Turtle(todraw=False)
    aux_lsystem = LSystem()
    aux_lsystem.readJSONFile('example.json',second_turtle)
    bbx = aux_lsystem.getBoundingBox(second_turtle,start,n)
    print 'bounding box for %i ites, staring from `%s`: ' %(n,start), bbx
    
    
    turtle.setworldcoordinates(*bbx)
    random.seed(427)
    turtle.hideturtle()
    lsystem.tell(first_turtle,start,n)
          
    
    raw_input('hit enter to close the screen ...')    
    turtle.bye()
    
    
    








