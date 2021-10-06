# 행의 크기를 입력받아 파스칼 삼각형을 작성하여 마지막 행부터 첫 번째 행까지 차례로 출력하는
# 프로그램을 작성하시오. 단, 행의 크기는 최대 10이다. 

n = int(input())
pascal = [[0] * n for i in range(n)]
pascal[0][0] = 1
for i in range(n-1):
    for j in range(i+1):
        pascal[i+1][j] += pascal[i][j]
        pascal[i+1][j+1] += pascal[i][j]
for i in range(n-1, -1, -1):
    # print("i" , i)    
    for j in range(i+1):
        # print("j" , j)
        print(pascal[i][j], end=" ")
    print()

