# 2차원 리스트를 생성하여 1행의 1열과 3열, 5열을 각각 1로 나머지는 모두 0으로 초기화한 후 
# 2행부터는 바로 전행의 왼쪽과 오른쪽의 값을 더하여 채운 후 출력하는 프로그램을 작성하시오. 

a1 = [1,0,1,0,1]
num = []
num.append(a1)
for x in range(2,6):
    a2 = [0]*5
    for y in range(1,5):
        a2[y] += a1[y-1]
        a2[y-1] += a1[y]
    num.append(a2)
    a1 = a2
for x in num:
    print(*x, sep=" ")

