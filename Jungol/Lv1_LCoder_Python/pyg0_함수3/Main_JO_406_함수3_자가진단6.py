# 9자리 이하의 자연수를 입력받아 재귀함수를 이용하여 각 자리 숫자의 제곱의 합을 출력하는 프로그램을 작성하시오. 

def recursive(n):
    if n < 10:
        return n*n
    return recursive(n//10) + recursive(n%10)

n = int(input())
print(recursive(n))