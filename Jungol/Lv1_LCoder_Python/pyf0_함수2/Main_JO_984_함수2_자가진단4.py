# 원의 넓이를 입력받아 반지름의 길이를 
# 소수 둘째자리까지 출력하는 프로그램을 작성하시오. 
# (원의 넓이 = 반지름 * 반지름 * 3.14 식을 이용하시오.) 

def radius(x):
    print(f'%.2f' % (x/3.14)**(1/2))

circle = float(input())
radius(circle)