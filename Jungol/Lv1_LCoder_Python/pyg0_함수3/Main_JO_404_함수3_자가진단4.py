# 10 이하의 자연수 N을 입력받아 
# 주사위를 N번 던져서 나올 수 있는 모든 경우를 출력하되
# 중복되는 경우에는 앞에서부터 작은 순으로 1개만 출력하는 프로그램을 작성하시오. 

def dices(idx, end, now, list):
    if idx == end:
        print(*list, sep=" ")
        return
    for next in range(now, 7):
        list[idx] = next
        dices(idx+1, end, next, list)
   
n = int(input())
num = [0] * n
dices(0, n, 1, num)