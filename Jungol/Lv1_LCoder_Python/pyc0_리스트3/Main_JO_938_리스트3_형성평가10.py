# 4행 2열의 리스트를 입력받아 첫 번째 줄에는 가로평균, 
# 두 번째 줄에는 세로평균 
# 그리고 세 번째 줄에는 전체평균을 출력하는 프로그램을 작성하시오. (소수점 이하는 버림 한다.)

num = []
garo = []
sero = []
avg = 0
tot = 0
for x in range(4):
    a1 = list(map(int, input().split()))
    num.append(a1)
    garo.append(sum(a1)//2)
for y in range(2):
    sum = 0
    for x in range(4):
        tot += num[x][y]
        sum += num[x][y]
    sero.append(sum//4)
avg = tot//8
print(*garo, sep=" ")
print(*sero, sep=" ")
print(avg)

