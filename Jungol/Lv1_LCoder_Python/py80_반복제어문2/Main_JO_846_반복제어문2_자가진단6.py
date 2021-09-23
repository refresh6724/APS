# 10개의 정수를 입력받아 3의 배수의 개수와 5의 배수의 개수를 각각 출력하는 프로그램을 작성하시오.​

three = 0
five = 0
for x in input().split():
	a = int(x)
	if a%3==0:
		three += 1
	if a%5==0:
		five += 1

print("Multiples of 3 :", three)
print("Multiples of 5 :", five)