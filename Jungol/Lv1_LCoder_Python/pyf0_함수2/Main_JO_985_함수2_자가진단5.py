# 세 개의 실수를 입력받아 가장 큰 수를 올림한 정수를 출력하고
# 가장 작은 수를 버림한 정수를 출력한 후 
# 남은 수를 반올림한 정수를 출력하는 프로그램을 작성하시오.
# 입력되는 실수는 -1000 이상 1000 이하이다. 

import math

def func(x):
    m = sorted(x, reverse=True)
    n = []
    n.append(math.ceil(m[0]))
    n.append(math.floor(m[2]))
    n.append(round(m[1]))
    print(*n, sep=" ")
    

a = list(map(float, input().split()))
func(a)