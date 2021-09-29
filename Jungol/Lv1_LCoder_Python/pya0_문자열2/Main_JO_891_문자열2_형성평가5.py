# 한 개의 단어를 입력받아서 거꾸로 뒤집어서 출력하는 작업을 반복하다가 "END"라고 입력이 되면 종료하는 프로그램을 작성하시오.(입력받는 단어의 길이는 20 이하이고, 단어의 개수는 100개 이하이다.)

a = list(input().strip())
while ''.join(a) != 'END':
    a.reverse()
    print(''.join(a))
    a = list(input().strip())