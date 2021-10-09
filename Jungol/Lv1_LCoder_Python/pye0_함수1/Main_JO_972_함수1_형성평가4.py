# 두 개의 정수를 입력받아 
# 큰 수의 제곱에서 작은 수의 제곱을 뺀 결과값을 출력하는 프로그램을 작성하시오. 
# (두 정수를 전달받아 제곱의 차를 리턴하는 함수를 이용할 것) 

def func(a, b):
    if a < b:
        return b**2 - a**2
    else:
        return a**2 - b**2

aa, bb = input().split()
a = int(aa)
b = int(bb)
print(func(a,b))