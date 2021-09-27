# 자연수 n을 입력받아 각 문제의 출력예와 같이 출력되는 프로그램을 작성하시오. 

n = int(input())
for x in range(1, n):
    for y in range(x):
        print('#', end=' ')
    print()
for x in range(n):
    for y in range(x):
        print(' ', end=' ')
    for y in range(n-x):
        print('#', end=' ')    
    print()