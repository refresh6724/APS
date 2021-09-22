# 한 개의 정수를 입력받아 양수(positive integer)인지 
# 음수(negative number)인지 출력하는 작업을 반복하다가 
# 0이 입력되면 종료하는 프로그램을 작성하시오.​

a = 1
while a != 0:
    print("number?", end=" ")
    a = int(input())
    if a > 0:
        print("positive integer")
    elif a < 0:
        print("negative number")
    else:
        break;