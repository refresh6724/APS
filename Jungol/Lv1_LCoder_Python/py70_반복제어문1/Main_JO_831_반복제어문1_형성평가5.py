# 삼각형의 밑변의 길이와 높이를 입력받아 넓이를 출력하고,
# "Continue?"에서 'Y'나 'y'를 입력하면 작업을 반복하고
# 다른 문자를 입력하면 종료하는 프로그램을 작성하시오. 
# (넓이는 반올림하여 소수 첫째 자리까지 출력한다.)

while True:
    print("Width =", end=" ")
    width = int(input())
    print("Height =", end=" ")
    height = int(input())
    print(f'Triangle Area = %.1f' % (width*height/2))
    print("Continue?", end=" ")
    yes = input()
    if yes != 'Y' and yes != 'y':
        break;
