# 원의 둘레의 길이를 입력받아 반지름의 길이를 출력하는 작업을 0이 입력될 때 까지 
# 반복하는 프로그램을 작성하시오. (원주율은 3.14로 하고 출력은 반올림하여 소수 둘째자리까지 한다.)

# f = open("io_446.txt", "r") # VS Code에서 열려있는 편집기 위치에 따라 상대경로가 결정된다
 
# a, b = map(int, f.readline().split())

twopir = float(input())
while twopir != 0:
    print(f'%.2f' % (twopir / 2 / 3.14))
    twopir = float(input())
 
# f.close()