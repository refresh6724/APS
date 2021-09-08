# 네 단어로 된 문장을 한 줄에 입력받아, 순서를 거꾸로 출력하는 프로그램을 작성하라.​

s = input()
ss = s.split()
ss.reverse()
print(' '.join(ss))
