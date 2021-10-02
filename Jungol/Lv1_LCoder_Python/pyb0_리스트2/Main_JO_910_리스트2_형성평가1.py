# 최대 100개의 정수를 차례로 입력받다가 
# -1이 입력되면 입력을 중단하고 
# -1을 제외한 마지막 세 개의 정수를 출력하는 프로그램을 작성하시오. 
# (입력받은 정수가 3개 미만일 경우에는 모두 출력한다.)

list = []
while(True):
    a = int(input())
    if a == -1:
        break
    list.append(a)

if len(list) < 3:
    print(*list, sep=" ")
else:
    print(f'%d %d %d' % (list[-3], list[-2], list[-1]))