# 5명의 이름과 키를 입력받아 키가 가장 작은 사람의 이름과 키를 출력하는 프로그램을 작성하시오.
# (이름은 20자 이하이다.) 

class Person:
    def __init__(self, name, length) -> None:
        self.name = name
        self.length = length
    
    def __lt__(self, other):
        return self.length < other.length

    def pout(self):
        print(self.name, self.length)

people = []
for x in range(5):
    name, length = input().split()
    y = Person(name, int(length))
    people.append(y)

people = sorted(people)
people[0].pout()
