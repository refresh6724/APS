# 한 개의 자연수를 입력받아 그 수의 배수를 차례로 10개 출력하는 프로그램을 작성하시오.​

n = int(input())
for x in range(1, 11):
    print(n*x, end=" ")