# 정수를 전달받아 다음과 같이 숫자 정사각형을 출력하는 함수를 작성하고 
# 함수를 호출하여 입력받은 정수를 함수로 전달하여 출력하는 프로그램을 작성하시오. 

def rectangle(n):
    start = 1
    for i in range(n):
        for j in range(n):            
            print(start, end=" ")
            start += 1
        print()

n = int(input())
rectangle(n)