# 50 이하의 자연수 N을 입력받아 재귀함수를 이용하여 N부터 1까지를 차례대로 출력하는 프로그램을작성하시오. 

def recursive(n):
    print(n, end=" ")
    if(n==1):
        return;
    recursive(n-1)

n = int(input())
recursive(n)