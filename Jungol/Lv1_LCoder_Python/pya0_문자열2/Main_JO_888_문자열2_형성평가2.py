# 문자열 한 개와 두 개의 정수 x, y를 입력받아 
# 문자열을 x만큼 왼쪽으로 순환하여 출력하는 작업을 y만큼 반복하는 프로그램을 작성하시오

a, xx, yy = input().split()
x = int(xx)
y = int(yy)
for i in range(y):
    a = a[x:] + a[:x]
    print(a)