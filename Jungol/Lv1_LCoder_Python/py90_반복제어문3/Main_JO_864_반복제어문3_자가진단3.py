# 자연수 n을 입력받아서 다음과 같이 출력하는 프로그램을 작성하시오.​

n = int(input())
for x in range(n, 0, -1):
    print('*'*x)
for x in range(1, n+1, 1):
    print('*'*x)