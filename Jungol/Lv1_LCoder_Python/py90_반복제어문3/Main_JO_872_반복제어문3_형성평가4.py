# 자연수 n을 입력받아 각 문제의 출력예와 같이 출력되는 프로그램을 작성하시오. 
# 3
# 5 *****
# 3  ***
# 1   *
# 3  ***
# 5 *****
n = int(input())
for x in range(n):
    print(' '*x , end="")
    print('*'*((n-x)*2-1))
for x in range(n-2, -1, -1):
    print(' '*x, end="")
    print('*'*((n-x)*2-1))
