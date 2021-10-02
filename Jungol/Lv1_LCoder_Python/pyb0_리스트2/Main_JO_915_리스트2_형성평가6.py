# 100개 이하의 정수를 한 줄로 입력받아 
# 입력 받은 개수를 출력한 후, 
# 입력받은 정수를 차례로 출력하되 그 수가 홀수이면 2배한 값을, 
# 짝수인 경우에는 2로 나눈 몫을 출력하는 프로그램을 작성하시오.

a = list(map(int, input().split()))
print(len(a))
for x in a:
    print(x*2 if x%2 != 0 else x//2, end=" ")
    