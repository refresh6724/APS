# 100 이하의 자연수 N을 입력받아 재귀함수를 이용하여 1부터 N까지의 합을 구하는 프로그램을 작성하시오. 

def recursive(n):
    if n==1:
        return 1
    return n + recursive(n-1)

n = int(input())
print(recursive(n))
    