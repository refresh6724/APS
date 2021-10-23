# 5명의 이름과 키, 몸무게를 입력받아 이름순으로 정렬하여 출력하고, 
# 몸무게가 무거운 순으로 정렬하여 출력하는 프로그램을 작성하시오. 

class Person:
    def __init__(self, name, length, weight) -> None:
        self.name = name
        self.length = length
        self.weight = weight
    
    def pout(self):
        print(self.name, self.length, self.weight)

people = []
for x in range(5):
    name, length, weight = input().split()
    y = Person(name, int(length), float(weight))
    people.append(y)

print("name")
a = sorted(people, key=lambda p: p.name)
for p in a:
    p.pout()

print()
print("weight")
b = sorted(people, key=lambda p: p.weight, reverse=True)
for p in b:
    p.pout()