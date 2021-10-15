# 10개의 정수를 입력받아 버블정렬로 내림차순 정렬을 하면서 
# 하나의 단계가 끝날 때마다 그 정렬 결과를 출력하는 프로그램을 작성하시오. 

def bubble(x):
    for i in range(9, -1, -1): # 이번 루프에 정렬 되어야 하는 가장 작은 수의 위치
        for j in range(0, i):
            if x[j] < x[j+1]:
                tmp = x[j]
                x[j] = x[j+1]
                x[j+1] = tmp
        print(*x, sep=" ")

n = list(map(int, input().split()))
bubble(n)