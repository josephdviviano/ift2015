"""
Created on Mon Oct 1 10:38:17 2017

@author: Jae Hyun Lim 

devoir 1
"""

import math
import matplotlib
matplotlib.use('Agg')
import matplotlib.pyplot as plt
import pylab as pl
from matplotlib import collections  as mc
import random


class Turtle:
    def __init__(self, x=0., y=0., angle=90., step=1., delta=45.):
        # init turtle state
        self.x     = float(x)
        self.y     = float(y)
        self.angle = float(angle) # degree

        self.step  = float(step)
        self.delta = float(delta)

        # stack for storing intermediate states of a tutle
        self.states = []

    def init(self, x, y, angle):
        self.x     = float(x)
        self.y     = float(y)
        self.angel = float(angle)

    def setUnits(self, step, delta):
        self.step  = float(step)
        self.delta = float(delta)

    def getPosition(self):
        return self.x, self.y

    def getAngle(self):
        return self.angle

    def draw(self):
        x     = self.x + self.step * math.cos(self.angle / 180. * math.pi)
        y     = self.y + self.step * math.sin(self.angle / 180. * math.pi)
        angle = self.angle
        (self.x, self.y, self.angle) = (x, y, angle)

    def move(self):
        x     = self.x + self.step * math.cos(self.angle / 180. * math.pi)
        y     = self.y + self.step * math.sin(self.angle / 180. * math.pi)
        angle = self.angle
        (self.x, self.y, self.angle) = (x, y, angle)
    
    def turnL(self):
        x     = self.x
        y     = self.y
        angle = self.angle + self.delta
        (self.x, self.y, self.angle) = (x, y, angle)

    def turnR(self):
        x     = self.x
        y     = self.y
        angle = self.angle - self.delta
        (self.x, self.y, self.angle) = (x, y, angle)

    def push(self):
        self.states.append((self.x, self.y, self.angle))

    def pop(self):
        (self.x, self.y, self.angle) = self.states.pop()

    def stay(self):
        (self.x, self.y, self.angle) = (self.x, self.y, self.angle)


class LSystem:
    def __init__(self, json):
        self.json    = json # dictionary

        def _parse_rules(json_rules):
            self.rules = {}
            for sym, expansion in json_rules.iteritems():
                self.addRule(sym, expansion[0]) 

        self.alphabet = json['alphabet']
        #self.rules    = json['rules']
        _parse_rules(json['rules'])
        self.axiom    = json['axiom']

        self.actions  = json['actions']

        self.step  = json['parameters']['step']
        self.delta = json['parameters']['angle']
        self.start = (json['parameters']['start'][0],
                      json['parameters']['start'][1],
                      json['parameters']['start'][2])

        # setup
        self.turtle = Turtle(x=self.start[0],
                             y=self.start[1],
                             angle=self.start[2],
                             step=self.step,
                             delta=self.delta)

        # resulting path
        #self.symbols = '' 
        self.lines = [] 

    # system initialization methods
    def addSymbol(self, sym):
        if sym not in self.alphabet:
            self.alphabet.append(sym)

    def addRule(self, sym, expansion):
        if sym not in self.rules.keys():
            self.rules[sym] = []
        self.rules[sym].append(expansion)

    def setAction(self, sym, action):
        self.actions[sym] = action

    def setAxiom(self, axiom):
        self.axiom = axiom

    # access to rules and enforcement 
    def getAxiom(self):
        return self.json['axiom'] 

    def rewrite(self, sym):
        if sym in self.rules.keys():
            return random.choice(self.rules[sym])
        else:
            return sym

    def tell(self, turtle, sym): #def forward(self, sym):
        action = self.actions[sym]
        if action == 'push':
            turtle.push()
        elif action == 'pop':
            turtle.pop()
        elif action == 'turnL':
            turtle.turnL()
        elif action == 'turnR':
            turtle.turnR()
        elif action == 'draw':
            # previous position 
            x_prev, y_prev = turtle.getPosition()
            # update turtle
            turtle.draw()
            # updated position 
            x, y = turtle.getPosition()
            # add a line to resulting path 
            self.lines.append([(x_prev, y_prev), (x, y)])
        elif action == 'move':
            turtle.move()
        else:
            raise ValueError('action == {} is not defined.'.format(action))

        #print(sym)
        #self.symbols += sym

    # advance operations
    def applyRules(self, symbols, n):
        new_symbols = symbols
        for i in range(n):
            old_symbols = new_symbols 
            new_symbols = '' 
            for sym in old_symbols:
                new_symbols += self.rewrite(sym)
        return new_symbols

    def tell_n(self, turtle, sym, n):
        if n == 0:
            self.tell(turtle, sym)
        else:
            symbols = self.rewrite(sym)
            for sym in symbols: 
                self.tell_n(turtle, sym, n-1) 

    def getBoundingBox(self):
        xs = [x for (x, y) in self.lines] 
        ys = [y for (x, y) in self.lines]
        x_min = min(xs)
        x_max = max(xs)
        y_min = min(ys)
        y_max = max(ys)
        return (x_min, x_max, y_min, y_max)

def plot_lines(lines, example, n):
    # plot results
    lc = mc.LineCollection(lines, linewidths=1)
    fig, ax = pl.subplots()
    ax.add_collection(lc)
    ax.autoscale()
    ax.margins(0.1)
    plt.axis('equal')
    plt.savefig('{}{}.png'.format(example, n))
    plt.savefig('{}{}.pdf'.format(example, n), format='pdf')

#buisson
buisson = {
        "alphabet" :    ["F", "[", "]", "+", "-"],
        "rules" : {
                "F" : ["FF-[-F+F+F]+[+F-F-F]"]
        },
        "axiom":"F",
        "actions": {
                "F":"draw", 
                "[":"push",
                "]":"pop", 
                "+":"turnR", 
                "-":"turnL"},
        "parameters" : {"step": 3, "angle":22.5, "start":[250,0,90]},
}

#hexamaze
hexamaze = {
    "alphabet" : ["R", "L", "+", "-"],
    "rules" : {
        "L": ["L+R++R-L--LL-R+"],
        "R": ["-L+RR++R+L--L-R"]
    },
    "axiom" : "L",
    "actions": {
        "L": "draw", 
        "R": "draw", 
        "+": "turnR", 
        "-": "turnL"},
    "parameters" : {
        "step": 1.5,
        "angle":60,
        "start":[500,500,90]},
}

#plante
plante = {
        "alphabet" :    ["F", "[", "]", "+", "-"],
        "rules" : {
                "F" : [ "F[+F]F[-F]F","F[+F]F","F[+F]F[-F]F"]
        },
        "axiom":"F",
        "actions": {
                "F":"draw", 
                "[":"push",
                "]":"pop", 
                "+":"turnR", 
                "-":"turnL"},
        "parameters" : {"step": 2, "angle":22.5, "start":[250,0,90]},
}

#sierpinski
sierpinski = {
        "alphabet" :    ["R", "L", "+", "-"],
        "rules" : {
                "L": ["R+L+R"],
                "R": ["L-R-L"]
        },
        "axiom" : "R",
        "actions": {
                "L":"draw", 
                "R":"draw", 
                "+":"turnR", 
                "-":"turnL"},
        "parameters" : {"step": 1, "angle":60, "start":[0,0,0]},
}


def run_l_system(mode, n):
    if mode == 'buisson': 
      json = buisson; #n = 5
    elif mode == 'hexamaze':
      json = hexamaze; #n = 6
    elif mode == 'plante':
      json = plante; #n = 7
    elif mode == 'sierpinski':
      json = sierpinski; #n = 8
    else:
      raise NameError('undefined json')
    print(json)
    
    print('init L-system')
    lsys = LSystem(json)
    print(vars(lsys))
    print(vars(lsys.turtle))
    
    print('')
    axiom = lsys.getAxiom()
    print('axiom:', axiom)
    
    print('')
    seq = lsys.applyRules(axiom, n)
    print('resulting seq:')
    print(seq)
    
    print('')
    print('run turtle: ')
    turtle = lsys.turtle
    lsys.tell_n(turtle, axiom, n)
    print('done.')

    print('draw results: ')
    plot_lines(lsys.lines, mode, n)
    print('done.')

    print('get bouding boxes: ')
    print(lsys.getBoundingBox())

# run examples
run_l_system('buisson', 5)
run_l_system('hexamaze', 6)
run_l_system('plante', 7)
run_l_system('sierpinski', 8)
