# 실수 2개를 입력받아 합계를 구하고 각각 소수 셋째 자리에서 반올림하여 둘째 자리까지 한 줄에 출력하시오.

a, b = map(float, input().split())
c = a + b
print(f'%.2f %.2f %.2f' % (a, b, c))