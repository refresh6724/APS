class Triangle:
    def __init__(self, x1, y1, x2, y2, x3, y3) -> None:
        self.x1 = x1
        self.x2 = x2
        self.x3 = x3
        self.y1 = y1
        self.y2 = y2
        self.y3 = y3
        
    def center(self):
        print(f'(%.1f, %.1f)' % ((self.x1 + self.x2 + self.x3)/3 , (self.y1+self.y2+self.y3)/3))
    
a, b, c, d, e, f = map(int, input().split())
t = Triangle(a, b, c, d, e, f)
t.center()