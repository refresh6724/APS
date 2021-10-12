# 2021-10-12 23:49:14
# 3명 학생의 3과목 점수를 입력받아
# 각 과목별, 학생별 총점을 출력하는 구조화된 프로그램을 작성하시오 
# https://dojang.io/mod/page/view.php?id=2388

class Student:
    def __init__(self, x):
        a, b, c = x.split()
        self.s1 = int(a)
        self.s2 = int(b)
        self.s3 = int(c)

    def sum(self):
        return self.s1+self.s2+self.s3

    def print(self):
        print(f'%d %d %d %d' % (self.s1, self.s2, self.s3, self.sum()))

class Subject:
    def __init__(self):
        self.sub1 = 0
        self.sub2 = 0
        self.sub3 = 0
        self.tot = 0

    def add(self, Student):
        self.sub1 += Student.s1
        self.sub2 += Student.s2
        self.sub3 += Student.s3
        self.tot += Student.sum()

    def print(self):
        print(f'%d %d %d %d' % (self.sub1, self.sub2, self.sub3, self.tot))

a1 = Student(input())
a2 = Student(input())
a3 = Student(input())

t = Subject()
t.add(a1)
t.add(a2)
t.add(a3)

a1.print()
a2.print()
a3.print()
t.print()

