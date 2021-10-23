# 두 명의 이름과 국어, 영어 점수를 입력받아
# 과목별 점수의 평균을 구하여 출력하는 프로그램을 작성해 보시오.
# (이름은 20자 이하이고 평균의 소수점 이하는 버림한다.) 

class Student:
    def __init__(self, name:str, kor:int, eng:int) -> None:
        self.name = name
        self.kor = kor
        self.eng = eng        
    
    def sout(self):
        print(f'%s %d %d' % (self.name, self.kor, self.eng))

class Classroom:
    def __init__(self) -> None:
        self.students = []
    
    def addStudent(self, student:Student) -> None:
        self.students.append(student)

    def averageOut(self):
        kor = 0
        eng = 0
        n = len(self.students)
        for s in self.students:
            kor += s.kor
            eng += s.eng
            s.sout()
        print(f'avg %d %d' % (kor//n, eng//n))
        

classroom = Classroom()
for i in range(2):
    a, b, c = input().split()
    d = Student(a,int(b),int(c))
    classroom.addStudent(d)
classroom.averageOut()