# 자연수 n을 입력받아 각 문제의 출력예와 같이 출력되는 프로그램을 작성하시오. 

n = int(input())
for x in range(n):
    for y in range(n-1-x):
        print(' ', end=' ')
    a = 1
    for y in range(x+1):
        print(f'%d' % a, end=' ')
        a += 1
    print()

