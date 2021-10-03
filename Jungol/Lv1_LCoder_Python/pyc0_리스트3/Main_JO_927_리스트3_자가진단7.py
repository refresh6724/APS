# 5명 학생의 국어, 영어, 수학, 과학 4과목의 점수를 입력 받아서 
# 각 개인별로 평균이 80 이상이면"pass", 그렇지 않으면 "fail"을 출력하고, 
# 합격한 사람의 수를 출력하는 프로그램을 작성하시오 

suc = 0
for x in range(5):
    y = list(map(int, input().split()))
    if (sum(y)/4) >= 80:
        print("pass")
        suc += 1
    else:
        print("fail")
print("Successful :", suc)