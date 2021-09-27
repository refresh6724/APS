# 자연수 n을 입력받아 출력예와 같이 출력되는 프로그램을 작성하시오.

n = int(input())
for x in range(n):
    print('*'*(x+1))
for x in range(n):
    print('*'*(n-1-x))
