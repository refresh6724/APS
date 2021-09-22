# 아래와 같이 나라 이름을 출력하고 
# 숫자를 입력받아 해당하는 나라의 수도를 출력하는 작업을 반복하다가 
# 해당하는 번호 이외의 숫자가 입력되면 "none"이라고 출력한 후 종료하는 프로그램을 작성하시오.

countryString = "1. Korea\n2. USA\n3. Japan\n4. China"
country = {
    1 : "Seoul",
    2 : "Washington",
    3 : "Tokyo",
    4 : "Beijing"
}
while True:
    print(countryString)
    print("number?", end=" ")
    a = int(input())
    print(country.get(a, "none"))
    if a not in (1,2,3,4):
        break;