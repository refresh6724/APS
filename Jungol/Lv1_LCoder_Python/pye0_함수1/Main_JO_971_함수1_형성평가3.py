# 자연수를 입력받아 아래와 같은 사각형을 출력하는 프로그램을 작성하시오. 
# (출력하는 부분은 함수로 작성한다.) 

def matrix(n):
    for i in range(1, n):
        for j in range(1, n):
            print(i*j, end=" ")
        print()

n = int(input()) + 1
matrix(n)