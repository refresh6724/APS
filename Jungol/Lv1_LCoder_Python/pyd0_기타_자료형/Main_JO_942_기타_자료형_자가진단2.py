# 세 튜플 ('Dolphin','Oh My Girl'), ('Pallette','IU'), ('Yes or Yes', 'Twice')을 만들고 아래 출력 예처럼 출력
# 하는 프로그램을 작성하시오. (중간의 구분선에는 '='가 10개 들어가 있다.) 

tp_li = [('Dolphin','Oh My Girl'), ('Pallette','IU'), ('Yes or Yes', 'Twice')]
print("[Song by Artist]")
print("==========")
for x in tp_li:
    print(f'%s by %s' % (x[0], x[1]))
    