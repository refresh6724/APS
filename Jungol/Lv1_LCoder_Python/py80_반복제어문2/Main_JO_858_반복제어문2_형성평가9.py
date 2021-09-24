# 정수를 입력받아 다음과 같이 순서쌍을 출력하는 프로그램을 작성하시오.​
# n행 n열의 좌표 표시
# 2
# (1, 1) (1, 2)
# (2, 1) (2, 2)

n = int(input())
for i in range(1, n+1):
    for j in range(1, n+1):
        print(f'(%d, %d)' % (i, j), end=" ")
    print()