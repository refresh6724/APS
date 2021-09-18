# 두 개의 정수를 입력받아 큰 수에서 작은 수를 뺀 차를 출력하는 프로그램을 작성하시오.​
 
a, b = input().split()
c = int(a) - int(b)
print(c if c > 0 else -c)