# 어떤 학생의 키는 아버지와 어머니의 키의 평균보다 5cm 크고 
# 몸무게는 아버지와 어머니의 몸무게의 평균보다 4.5kg 가볍다고 한다. 
# 키와 몸무게를 멤버변수로 갖는 클래스를 생성하고 
# 아버지와 어머니의 키와 몸무게를 입력받아 
# 학생의 키와 몸무게를 출력하는 프로그램을 작성하시오. 
# (키는 정수미만 버림하고 몸무게는 반올림하여 소수 첫째자리까지 나타낸다.) 

class Family:
    def __init__(self, flen:int, fwgt:float, mlen:int, mwgt:float) -> None:
        self.flen = flen
        self.fwgt = fwgt
        self.mlen = mlen
        self.mwgt = mwgt
        
    def child(self):
        print(f'height : %dcm' % (5 + (self.flen+self.mlen)//2))
        print(f'weight : %.1fkg' % (-4.5 + (self.fwgt + self.mwgt)/2))
    
a, b = input().split()
c, d = input().split()
f = Family(int(a),float(b),int(c),float(d))
f.child()