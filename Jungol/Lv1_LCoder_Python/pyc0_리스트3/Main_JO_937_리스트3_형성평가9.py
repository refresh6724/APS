a1 = []
print("first array")
for x in range(2):
    a1.append(list(map(int, input().split())))
a2 = []
print("second array")
for x in range(2):
    a2.append(list(map(int, input().split())))
a3 = [[0]*3 for i in range(2)]
for x in range(2):
    for y in range(3):
        a3[x][y] = a1[x][y] * a2[x][y]
    print(*a3[x], sep=" ")