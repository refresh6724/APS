# 두 개의 정수를 입력받아 큰 수는 2로 나눈 몫을 저장하고 
# 작은 수는 2를 곱하여 저장한 후 출력하는 프로그램을 작성하시오. 
# (함수에서는 전역변수를 수정만 하도록 작성한다.) 

def fx():
    global a, b
    if a < b:
        b //= 2
        a *= 2
    else:
        a //= 2
        b *= 2

global a, b
a, b = map(int, input().split())
fx()
print(a, b)