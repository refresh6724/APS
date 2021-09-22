# 100 이하의 정수를 입력받아 while 문을 이용하여 
# 1부터 입력받은 정수까지의 합을 구하여 출력하는 프로그램을 작성하시오.​

a = int(input())
sum = 0
b = 1
while b <= a:
    sum += b
    b += 1

print(sum)
