# 5개의 정수를 입력받아 각 정수의 절대값의 합을 출력하는 프로그램을 작성하시오. 

def sumofabs(x):
    s = 0
    for i in x:
        s += abs(i)
    print(s)

a = list(map(int, input().split()))
sumofabs(a)