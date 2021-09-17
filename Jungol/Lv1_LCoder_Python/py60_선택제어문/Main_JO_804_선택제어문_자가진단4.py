# 복싱체급은 몸무게가 50.80kg 이하를 Flyweight, 
# 61.23kg 이하 Lightweight, 
# 72.57kg 이하 Middleweight, 
# 88.45kg 이하 Cruiserweight, 
# 그 이상을 Heavyweight이라고 하자. 
# 몸무게를 입력받아 체급을 출력하는 프로그램을 작성하시오.

weight = float(input())
if weight <= 50.8:
    print("Flyweight")
elif weight <= 61.23:
    print("Lightweight")
elif weight <= 72.57:
    print("Middleweight")
elif weight <= 88.45:
    print("Cruiserweight")
else:
    print("Heavyweight")