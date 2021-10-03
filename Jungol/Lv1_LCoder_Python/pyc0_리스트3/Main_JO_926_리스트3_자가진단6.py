# 2행 4열의 리스트 두 개를 만들어서 입력을 받고 두 리스트의 곱을 구하여 출력하는 프로그램을 작성하시오

# 입출력 예제가 문제의 보기와 다르다...

# t = input() # first array
print("first array")
a1 = []
for x in range(2):
    a1.append(list(map(int, input().split())))
# t = input() # second array
print("second array")
a2 = []
for x in range(2):
    a2.append(list(map(int, input().split())))
for x in range(2):
    for y in range(4):
        print(a1[x][y] * a2[x][y], end=" ")
    print()