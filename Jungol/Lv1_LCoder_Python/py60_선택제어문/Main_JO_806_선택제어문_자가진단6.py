# 남자는'M', 여자는 'F'로 나타내기로 하고, 18세 이상을 성인이라고 하자.
# 성별과 나이를 입력받아 "MAN" (성인남자), "WOMAN" (성인여자),
# "BOY" (미성년남자), "GIRL" (미성년여자)을 구분하여 출력하는 프로그램을 작성하시오. 

sex, old = input().split()
if sex == "M":
    if int(old) >= 18:
        print("MAN")
    else:
        print("BOY")
else:
    if int(old) >= 18:
        print("WOMAN")
    else:
        print("GIRL")