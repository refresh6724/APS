# 10개의 정수를 입력받아 입력받은 수들 중 
# 짝수의 개수와 홀수의 개수를 각각 구하여 출력하는 프로그램을 작성하시오.​

list = list(map(int, input().split()))
even = 0
odd = 0
for x in list:
    if x%2==0:
        even += 1
    else:
        odd += 1

print(f'even : %d' % even)
print(f'odd : %d' % odd)

