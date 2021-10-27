# 정수 n(n ≤ 10)을 입력받아 n!을 구하여 출력하시오 

n = int(input())
ans = 1
for i in range(2, n+1):
    ans *= i
print(ans)