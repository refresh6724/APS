# 2021-10-12 23:53:45
# 문자열 "~!@#$^&*()_+|"를 출력하는 함수를 작성하고 
# 정수를 입력받아 입력받은 수만큼 함수를 호출하는 프로그램을 작성하시오.  

def special(x):
    s = "~!@#$^&*()_+|\n"   
    print(s * x)

n = int(input())
special(n)