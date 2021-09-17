# 두 개의 실수를 입력받아 모두 4.0 이상이면 "A",
# 모두 3.0 이상이면 "B", 아니면 "C" 라고 출력하는 프로그램을 작성하시오.​

a = float(input())
b = float(input())

if a >= 4.0 and b >= 4.0:
    print("A")
elif a >= 3.0 and b >= 3.0:
    print("B")
else:
    print("C")