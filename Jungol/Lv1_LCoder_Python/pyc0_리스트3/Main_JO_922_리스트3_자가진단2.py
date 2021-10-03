# 영문 대문자를 한 줄로 입력받아 1번 이상 입력된 각 문자의 개수를 사전 순으로 출력하는 프로그램을 작성하시오.

word = dict()
for x in input().split():
    word[x] = word.get(x, 0) + 1
sword = sorted(word.items())
for tp in sword:
    print(f'%s : %d' % (tp[0], tp[1]))