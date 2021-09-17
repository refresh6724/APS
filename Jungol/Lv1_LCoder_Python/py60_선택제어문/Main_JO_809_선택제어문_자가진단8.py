# 3개의 정수를 입력받아 삼항 연산자를 이용하여 입력받은 수들
# 중 최소값을 출력하는 프로그램을 작성하시오.​

# a = int(input())
# b = int(input())
# c = int(input())
# 입출력 예제와 다르다

num = list(map(int, input().split()))

min = num[0] if num[0] < num[1] else num[1]
min = num[2] if num[2] < min else min
print(min)