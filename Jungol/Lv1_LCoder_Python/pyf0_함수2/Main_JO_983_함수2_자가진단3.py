# 두 개의 정수를 입력받아 절대값이 더 큰 수를 출력하고, 
# 두 개의 실수를 입력받아 절대값이 작은수를 출력하는 프로그램을 작성하시오 

def funcA(a, b):
    if (a*a > b*b):
        print(a)
    else:
        print(b)

def funcB(c, d):
    if (c*c < d*d):
        print(c)
    else:
        print(d)


a, b = map(int, input().split())
funcA(a,b)
c, d = map(float, input().split())
funcB(c,d)