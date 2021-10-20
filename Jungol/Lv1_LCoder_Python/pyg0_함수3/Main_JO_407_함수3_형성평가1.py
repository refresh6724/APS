# 자연수 N을 입력받아 1부터 N까지 출력을 하되 
# N-1번째는 N을 2로 나눈 몫이 되도록 하는 프로그램을 작성하시오 

def recursive(n):    
    if(n==1):
        print(n, end=" ")
        return
    recursive(n//2)
    print(n, end=" ")

n = int(input())
recursive(n)