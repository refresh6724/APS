# 자연수 n을 입력받아 각 문제의 출력예와 같이 출력되는 프로그램을 작성하시오. 
# 3
# 1 3 5
# 7 9 1
# 3 5 7

n = int(input())
num = 1
for x in range(n):
    for y in range(n):
        print(num, end=' ')
        num += 2
        num %= 10
    print()
    
