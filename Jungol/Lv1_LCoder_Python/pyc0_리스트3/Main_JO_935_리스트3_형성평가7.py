# 호석이네 학교는 6학년에 네 반이 있는데 각 반의 대표를 세 명씩 선발하여 제기차기 시합을 하였다.
# 반별로 세 명이 제기를 찬 개수를 입력받아 
# 각 반별로 제기를 찬 개수의 합계를 출력하는 프로그램을 작성하시오. 

num = []
for x in range(1,5):
    print(f'%dclass?' % x)
    a = list(map(int, input().split()))
    num.append(sum(a))
for x in range(1,5):
    print(f'%dclass : %d' % (x, num[x-1]))