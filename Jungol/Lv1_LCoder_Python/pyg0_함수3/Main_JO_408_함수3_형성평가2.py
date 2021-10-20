# 자연수 N을 입력받아 N이 홀수인 경우에는 1부터 N까지의 홀수를, 
# 짝수인 경우는 2부터 N까지의 짝수를 모두 출력하는 프로그램을 재귀함수로 작성하시오. 

def recursive(n):
    if n<=2:
        print(n, end=" ")
        return;
    recursive(n-2)
    print(n, end=" ")

n = int(input())
recursive(n)