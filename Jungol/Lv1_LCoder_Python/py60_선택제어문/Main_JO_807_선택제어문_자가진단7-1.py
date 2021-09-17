# 영문 대문자를 입력받아 'A'이면 "Excellent", 
# 'B'이면 "Good", 'C'이면 "Usually", 'D'이면 "Effort",
# 'F'이면 "Failure", 그 외 문자열이면 "Mistake"이라고 출력하는 프로그램을 작성하시오.​

def switch(x):
    print({"A":"Excellent", "B":"Good", "C":"Usually", "D": "Effort", "F":"Failure"}.get(x, "Mistake"))

a = input()
switch(a)
