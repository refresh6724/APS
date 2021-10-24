# 위 1번과 같은 자료를 리스트로 생성하여 3명의 자료를 입력받은 후 
# 사전순으로 이름이 가장 빠른 사람의 자료를 출력 예와 같이 출력하는 프로그램을 작성하시오. 

class Person:
    def __init__(self, name, tel, addr) -> None:
        self.name = name
        self.tel = tel
        self.addr = addr

    def pout(self):
        print("name :", self.name)
        print("tel :", self.tel)
        print("addr :", self.addr)

people = []
for x in range(3):
    a, b, c = input().split()
    p = Person(a,b,c)
    people.append(p)

sorted_people = sorted(people, key=lambda k : k.name)
sorted_people[0].pout()