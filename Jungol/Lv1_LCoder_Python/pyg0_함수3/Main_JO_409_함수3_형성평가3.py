# 자연수 N과 M을 입력받아서 주사위를 N번 던져서 나온 눈의 합이 M이 나올 수 있는 
# 모든 경우를 출력하는 프로그램을 작성하시오. 

def dice(level, sum, n, m, a):
    if(level == n):
        if(sum==m):
            print(*a, sep=" ")
        return
    for next in range(1,7):
        a[level] = next
        dice(level + 1, sum+next, n, m, a)

n, m = map(int, input().split())
a = [0] * n
dice(0, 0, n, m, a)
