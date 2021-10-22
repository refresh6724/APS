# "이름", "학교명", "학년"을 입력받아 아래와 같이 출력하는 프로그램을 작성하시오.(이름과 학교명은 각각 20자 이하이다.) 

class School:
    def __init__(self, name, school, grade) -> None:
        self.name = name
        self.school = school
        self.grade = grade
    
    def sout(self) -> None:
        print("Name :", self.name)
        print("School :", self.school)
        print("Grade :", self.grade)

a, b, c = input().split()
d = School(a, b, c)
d.sout()

