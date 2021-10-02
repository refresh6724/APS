# 6명의 몸무게를 입력받아 평균을 출력하는 프로그램을 작성하시오.
# 출력은 반올림하여 소수 첫째자리까지로 한다.

weight = 0
for x in input().split():
    weight += float(x)
print(f'%.1f' % (weight/6))
