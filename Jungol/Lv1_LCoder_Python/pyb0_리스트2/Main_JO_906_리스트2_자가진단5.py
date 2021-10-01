# 10개의 정수를 입력받아 100 미만의 수 중 가장 큰 수와 
# 100 이상의 수 중 가장 작은 수를 출력하는 프로그램을 작성하시오.
# (입력되는 정수의 범위는 1 이상 10000 미만이다. 각각의 경우, 만약 해당하는 수가 없을 때에는 100을 출력한다.)
a = list(map(int, input().split()))
lt100 = list(filter(lambda x: x < 100, a))
gte100 = list(filter(lambda x: x>= 100, a))
print(max(lt100) if lt100 else 100, min(gte100) if gte100 else 100)