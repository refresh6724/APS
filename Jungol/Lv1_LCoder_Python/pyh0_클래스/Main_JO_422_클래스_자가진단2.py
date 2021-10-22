# "학교명", "학년"을 저장할 수 있는 class를 만들고, 
# "Jejuelementary" 6학년으로 초기화한 인스턴스와, 
# 새로운 학교와 학년을 입력받은 인스턴스를 생성하여 
# 아래와 같이 출력하는 프로그램을 작성하시오.(학교명은 30자 이하이다.) 

# 6 grade in Jejuelementary School
# 1 grade in Seogwipomiddle School

class School:
    def __init__(self, name, school, grade) -> None:
        self.name = name
        self.school = school
        self.grade = grade
    
    def sout(self) -> None:
        print("Name :", self.name)
        print("School :", self.school)
        print("Grade :", self.grade)

    def lineout(self) -> None:
        print(f'%s grade in %s School' %(self.grade, self.school))

a = School('a', 'Jejuelementary', '6')
b, c = input().split()
d = School('d', b, c)
a.lineout()
d.lineout()
