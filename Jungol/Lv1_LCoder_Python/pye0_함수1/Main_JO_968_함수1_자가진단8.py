# 1 이상 10 미만의 두 개의 정수를 입력받아서 
# 작은 수부터 큰 수까지의 구구단을 차례대로 출력하는 프로그램을 구조화하여 작성하시오.

def gugudan(a, b):
    for i in range(a, b+1):
        print(f'== %ddan ==' % (i))
        for j in range(1, 10):
            print(f'%d * %d = %2d' % (i,j,i*j))
        print()

a, b = map(int, input().split())
if a > b:
    tmp = a
    a = b
    b = tmp
gugudan(a,b)
