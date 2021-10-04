# 학생들의 점수를 입력받아서 입력받은 점수를 10점 단위로 구분하여 점수대
# 별 학생 수를 출력하는 프로그램을 작성하시오. (1명도 없는 점수는 출력하지 않는다.) 

score = list(map(int, input().split()))
cnt = {}
for x in score:
    ten = (x//10) * 10
    cnt[ten] = cnt.get(ten, 0) + 1
st = sorted(cnt.items(), reverse=True)
for tp in st:
    print(f'%d : %d person' % (tp[0],tp[1]))