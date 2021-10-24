# 이름과 전화번호, 주소를 멤버로 하는 클래스를 정의하여 1개의 자료를 입력받고 
# 아래 출력 예와 같은 형식으로 출력하는 프로그램을 작성하시오.(각각의 길이는 100자 이하이다.) 

class Person:
    def __init__(self, name, tel, addr) -> None:
        self.name = name
        self.tel = tel
        self.addr = addr

    def pout(self):
        print("name :", self.name)
        print("tel :", self.tel)
        print("addr :", self.addr)

a, b, c = input().split()
p = Person(a,b,c)
p.pout()
