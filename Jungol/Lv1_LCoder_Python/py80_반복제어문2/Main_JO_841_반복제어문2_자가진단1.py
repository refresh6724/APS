# 자연수 n을 입력받아서, 리스트 [n, n-1, ... 1]을 출력하는 프로그램을 작성하라.​

n = int(input())
list = []
for x in range(n):
	list.append(n-x)
print(list)