# 7개의 정수를 입력받아, 
# 입력받은 순서대로 앞에서부터 마지막까지 가면서 
# 바로 뒤의 숫자와 비교하여 크면 교환한다. 
# 이러한 작업을 세 번 반복한 후 그 결과를 차례대로 출력하는 프로그램을 작성하시오. 

def bubble(x, repeat):
    for r in range(repeat):
        for i in range(len(x)-1):
            if x[i] > x[i+1]:
                tmp = x[i]
                x[i] = x[i+1]
                x[i+1] = tmp
    return x

repeat = 3
x = list(map(int, input().split()))
print(*bubble(x, repeat), sep=" ")