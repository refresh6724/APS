# 2016년의 날짜를 월 일로 입력받아서 
# 입력된 날짜가 존재하면 "OK!", 그렇지 않으면 "BAD!"라고 출력하는 프로그램을 작성하시오. 

def twothousandsixteen(month, day):
    if month in (1, 3, 5, 7, 8, 10, 12):
        if (day >= 1 and day <= 31):
            ok()
        else:
            nok()
    elif month == 2:
        if (day >= 1 and day <= 29):
            ok()
        else:
            nok()
    elif month in (4,6,9,11):
        if (day >= 1 and day <= 30):
            ok()
        else:
            nok()
    else:
        nok()

def ok():
    print("OK!")

def nok():
    print("BAD!")


m, n = map(int, input().split())
twothousandsixteen(m, n)
