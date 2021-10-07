# 매 년 피아노 콩쿠르 최우수상을 받은 학생들의 이름과 정수 하나를 입력 받아,
# 입력받은 정수 만큼 최우수상을 받은 학생들을 모두 출력하는 프로그램을 작성하시오. 
# (먼저 입력된 이름을 우선하여 출력한다.) 

dict = {}
for x in input().split():
    dict[x] = dict.get(x, 0) + 1
n = int(input())
for k, v in dict.items():
    if(v==n):
        print(k)
  