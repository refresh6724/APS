# 자연수 n을 입력받아 각 문제의 출력예와 같이 출력되는 프로그램을 작성하시오. 
# 3
# A B C
# D E 0
# F 1 2
n = int(input())
alp = ord('A')
num = 0
for x in range(n):
    for y in range(n-x):
        print(chr(alp), end=' ')
        alp += 1
    for y in range(x):
        print(num, end=' ')
        num += 1
    print()
    