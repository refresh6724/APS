# 10명의 학생 이름과 점수를 입력받아 이름과 점수, 등수를 입력받은 순서대로 출력하는 프로그램을 작성하시오.
# 단, 출력시 "Name", "Score", "Rank​​​"는 한 칸의 공백으로 구분을 하며, 
# 이름, 점수와 등수는 각각 5칸(%5d)으로 출력하며 이름은 점수와 한칸의 공백을 추가로 둔다. 

# f = open("io_443.txt", "r") # VS Code에서 열려있는 편집기 위치에 따라 상대경로가 결정된다
 
class Student:
    def __init__(self, idx, name, score) -> None:
        self.idx = idx
        self.name = name
        self.score = score

    def ranking(self, rank):
        self.rank = rank

students = []
for i in range(10):
    a, b = input().split()
    # a, b = f.readline().split()
    c = Student(i, a, int(b))
    students.append(c)

sorted_students = sorted(students, key=lambda s : s.score, reverse=True)
sorted_students[0].ranking(1)
for s in range(1, 10):
    if(sorted_students[s].score == sorted_students[s-1].score):
        sorted_students[s].ranking(sorted_students[s-1].rank)
    else:
        sorted_students[s].ranking(s+1)

students = sorted(sorted_students, key=lambda s : s.idx)
print("Name Score Rank")
for s in students:
    print(f'%4s %5d%5d' % (s.name, s.score, s.rank))

# f.close()