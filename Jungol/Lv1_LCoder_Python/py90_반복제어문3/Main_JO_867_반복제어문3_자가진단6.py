# 자연수 n을 입력받아 다음과 같이 영문자를 출력하는 프로그램을 작성하시오.​

n = int(input())
start = ord('A')
pp = ''
for x in range(n):
    for y in range(n-x):
        pp += chr(start)
        start += 1
    pp += '\n'
print(pp)