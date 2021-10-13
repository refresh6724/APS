# 10 이하의 두 정수 m과 n을 입력 받아서 
# m을 n만큼 거듭제곱하여 나온 값(mn)을 리턴하는 함수를 작성하여 
# 다음과 같이 출력하는 프로그램을 작성하시오.
# (거듭제곱 연산자 m**n을 리턴하면 편하나, 
# 여러분들의 연습을 위해 거듭제곱 연산자를 사용하지 않고 작성하시오) 


def returnMN(m, n):
    if(n == 0):
        return 1
    elif(n == 1):
        return m
    else:
        return m * returnMN(m, n-1)


m, n = map(int, input().split())
print(returnMN(m,n))