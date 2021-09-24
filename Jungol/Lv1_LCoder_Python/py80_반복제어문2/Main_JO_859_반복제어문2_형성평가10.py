# 2부터 9까지의 정수 a와 b를 입력받아 a단부터 b단까지의 구구단을 차례대로 출력하는 프로그램을 작성하시오. 
# 구구단 사이의 공백은 3칸이다.​
# 5 3
# 5 * 1 =  5   4 * 1 =  4   3 * 1 =  3

aa, bb = input().split()
a = int(aa)
b = int(bb)

if a > b:
	step = -1
	b -= 1
else:
	step = 1
	b += 1

for i in range(1, 10):
	print(f'%d * %d = %2d' % (a, i, a*i), end="")
	for j in range(a + step, b, step):
		print(f'   %d * %d = %2d' % (j, i, i*j), end="")
	print()

