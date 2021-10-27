# 두 정수와 한 개의 연산자(+, -, *, /, %)를 입력받아 계산식을 출력하시오 

a, b, c = input().split()
a = int(a)
b = int(b)
if c == '+':
    print(f'%d %s %d = %d' % (a, c, b, a+b))
elif c == '-':
    print(f'%d %s %d = %d' % (a, c, b, a-b))
elif c == '*':
    print(f'%d %s %d = %d' % (a, c, b, a*b))
elif c == '/':
    print(f'%d %s %d = %d' % (a, c, b, a//b))
else:
    print(f'%d %s %d = %d' % (a, c, b, a%b))