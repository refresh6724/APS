# 1~12 사이의 정수를 입력받아 평년의 경우 입력받은 월의 날수를 출력하는 프로그램을 작성하시오.​
 
a = int(input())
if a in (1,3,5,7,8,10,12):
    print(31)
elif a in (4,6,9,11):
    print(30)
else:
    print(28)