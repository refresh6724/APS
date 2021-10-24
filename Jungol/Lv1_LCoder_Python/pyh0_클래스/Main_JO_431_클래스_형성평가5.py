# 정수 n을 입력받은 후 n명의 이름(20자 이하)과
# 세 과목의 점수를 입력받아 총점이 높은 순으로 정렬하여 출력하는 프로그램을 작성하시오. (1 ≤ n ≤ 10) 

class Student:
    def __init__(self, name, s1, s2, s3) -> None:
        self.name = name
        self.s1 = s1
        self.s2 = s2
        self.s3 = s3
        self.sum = s1+s2+s3
    
    def pout(self):
        print(self.name, self.s1, self.s2, self.s3, self.sum)

students = []      
n = int(input())
for i in range(n):
    a, b, c, d = input().split()
    s = Student(a, int(b), int(c), int(d))
    students.append(s)

sorted_students = sorted(students, key=lambda s: s.sum, reverse=True)
for i in sorted_students:
    i.pout()