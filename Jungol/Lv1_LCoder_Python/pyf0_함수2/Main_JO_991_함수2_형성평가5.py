# 세 개의 실수를 입력받아 합계와 평균을 구하여 평균을 반올림한 정수를 출력하고, 
# 다음은 입력받은 수를 각각 먼저 반올림한 후 합계와 평균을 구하여 
# 평균을 반올림한 한 결과를 출력하는 프로그램을 작성하시오. 

def func():
    origin = list(map(float, input().split()))
    print(round(sum(origin)/len(origin)))
    after = list(map(round, origin))
    print(round(sum(after)/len(after)))

func()