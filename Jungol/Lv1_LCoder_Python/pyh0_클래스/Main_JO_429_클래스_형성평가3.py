# 직사각형의 왼쪽 아래의 좌표 (x1, y1)와 오른쪽 위의 좌표 (x2, y2)를 저장할 수 있는 클래스를 만들고
# 두 개의 직사각형 자료를 입력받아 두 직사각형을 포함하는 최소의 직사각형 자료를 구하여 
# 멤버 변수에 저장하고 출력하는 프로그램을 작성하시오. 단, 모든 입력값은 100을 넘지 않는다. 

class Rectangle:
    def __init__(self, x1, y1, x2, y2) -> None:
        self.x1 = x1
        self.y1 = y1
        self.x2 = x2
        self.y2 = y2

    def union(self, other):
        print(f'%d %d %d %d' % (min(self.x1, other.x1), min(self.y1, other.y1), max(self.x2, other.x2), max(self.y2, other.y2)))

a, b, c, d = map(int, input().split())
e = Rectangle(a,b,c,d)
a, b, c, d = map(int, input().split())
f = Rectangle(a,b,c,d)
e.union(f)
