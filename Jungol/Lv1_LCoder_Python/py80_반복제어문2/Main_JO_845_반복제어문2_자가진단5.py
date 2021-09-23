# 정수를 입력받아서 입력받은 정수부터 100까지의 합을 출력하는 프로그램을 작성하시오. (입력받는 정수는 100 이하의 자연수이다.)​

a = int(input())
sum = 0
for x in range(a, 101):
	sum += x
print(sum)