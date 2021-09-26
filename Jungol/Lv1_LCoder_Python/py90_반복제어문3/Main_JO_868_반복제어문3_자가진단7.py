# 자연수 n을 입력받아서 n개의 줄에 n + 1개의 숫자와 문자로 채워서 다음과 같이 출력하는 프로그램을 작성하시오.​​
# 3
# 1 2 3 A
# 4 5 B C
# 6 D E F
n = int(input())
start = ord('A')
num = 1
pp = ''
for x in range(n):    
    for y in range(n-x):
        pp += str(num) + ' '
        num += 1
    for y in range(x+1):
        pp += chr(start) + ' '
        start += 1
    pp += '\n'
print(pp)

