# 20 이하의 자연수 N을 입력받아 재귀함수를 이용해서 "recursive"를 N번 출력하는 프로그램을 작성하시오. 

def recursive(n):
    print("recursive")
    if(n==1):
        return
    recursive(n-1)
    

n = int(input())
recursive(n)