# 가람이는 주사위 놀이를 하다가 주사위를 10번 던져서 각 숫자가 몇 번씩 나왔는지 알아보려고 한다.
# 한번 던질 때마다 나온 주사위의 숫자를 입력받아서 숫자가 몇 번씩 나왔는지 출력하는 프로그램을
# 작성하시오. 

dices = list(map(int, input().split()))
cnt = [0] * 6
for x in dices:
    cnt[x-1] += 1
for i,x in enumerate(cnt):
    print(f'%d : %d' % (i+1, x))