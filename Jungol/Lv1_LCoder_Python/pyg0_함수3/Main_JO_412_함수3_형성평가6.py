# 3자리로 이루어진 자연수 3개를 입력받아 그 수들의 곱을 구한 후 
# 그 결과값의 각 자리 숫자들중 0을 제외한 모든 수들의 곱을 구하여 출력하는 프로그램을 재귀함수로 작성하시오.  


def recursive(arr):
    s = 1
    for i in arr:
        s *= i
    return s

a = list(map(int, input().split()))
b = recursive(a)

d = []
while(b > 0):
    c = b%10
    b = b//10
    if(c != 0):
        d.append(c)

e = recursive(d)
print(e)