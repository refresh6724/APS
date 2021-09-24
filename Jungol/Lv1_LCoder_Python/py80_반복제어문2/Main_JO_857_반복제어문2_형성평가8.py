# 행과 열의 수를 입력받아 다음과 같이 출력하는 프로그램을 작성하시오.​
# 3 4
# 1 2 3 4
# 2 4 6 8
# 3 6 9 12

aa, bb = input().split()
a = int(aa)
b = int(bb)
for i in range(1, a+1):
    for j in range(1, b+1):
        print(i*j, end=" ")
    print()