# 100 미만의 정수를 입력받아 입력된 정수의
# 십의 자리 숫자가 각각 몇 개인지 작은 수부터 
# 출력하는 프로그램을 작성하시오. (0개인 숫자는 출력하지 않는다.)

cnt = {}
for x in input().split():
    xx = (int(x)%100)//10
    cnt[xx] = cnt.get(xx, 0) + 1
asc = sorted(cnt.items())
for tp in asc:
    print(f'%d : %d' % (tp[0], tp[1]))