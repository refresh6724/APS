# 두 문자열을 입력 받아, 첫 번째 문자열을 두 번째 문자열을 기준으로 분리하여 각 요소들을 여러 줄에 출력하는 프로그램을 작성하라.​ 

a = input()
b = input()
a = a.replace(b, '\n')
for x in a.split():
    print(x)