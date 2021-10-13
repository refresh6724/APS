# 정수의 연산식을 입력받아 연산을 위한 함수를 호출하여 
# 사칙연산(+ - * /)의 연산결과를 출력하는 프로그램을 작성하시오. 
# ('/'의 경우는 정수 부분만 출력하고 사칙연산 이외의 연산 결과는 0으로 한다.) 

def calc(a, b, c):
    if(b=='+'):
        return a+c
    elif(b=='-'):
        return a-c
    elif(b=='*'):
        return a*c
    else:
        return a//c

aa, b, cc = input().split()
a = int(aa)
c = int(cc)
print(a,b,c,"=",calc(a,b,c))