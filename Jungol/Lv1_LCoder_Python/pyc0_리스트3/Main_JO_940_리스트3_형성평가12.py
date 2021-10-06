# 3행 5열의 2차원 문자리스트에 차례로 대문자를 입력받은 후 소문자로 바꾸어서 출력하는 프로그램을 작성하시오. 

def toLower(x):
    return chr(ord(x)+32)

for i in range(3):
    line = list(map(toLower, input().split()))
    print(*line, sep=" ")
