# 100만 이하의 자연수 N을 입력받아 짝수이면 2로, 
# 홀수이면 3으로 나누는 작업을 반복하다가 그 값이 1이 되면 
# 그때까지 나누었던 작업의 횟수를 출력하는 프로그램을 재귀함수로 작성하시오.  

def recursive(n):
    if n==1:
        return 0
    if n%2==0:
        return 1 + recursive(n//2)
    else:
        return 1 + recursive(n//3)

n = int(input())
print(recursive(n))