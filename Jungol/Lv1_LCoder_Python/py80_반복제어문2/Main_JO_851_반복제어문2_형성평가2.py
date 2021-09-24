# 두 개의 정수를 입력받아 작은 수부터 큰 수까지 차례대로 출력하는 프로그램을 작성하시오. (입력으로 주어지는 정수는 100이하의 자연수이다.)​

aa, bb = input().split()
a = int(aa)
b = int(bb)
if a > b:
    tmp = a
    a = b
    b = tmp

for x in range(a, b+1):
    print(x, end=" ")