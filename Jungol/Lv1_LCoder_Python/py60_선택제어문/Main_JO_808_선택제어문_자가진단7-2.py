# 4.5 이하의 평점을 입력받아 그 값에 따라 다음과 같이 출력하는 프로그램을 작성하시오.
# 4.0 이상 : scholarship
# 3.0 이상 : next semester
# 2.0 이상 : seasonal semester
# 2.0 미만 : retake 

a = float(input())
if a >= 4.0:
    print("scholarship")
elif a >= 3.0:
    print("next semester")
elif a >= 2.0:
    print("seasonal semester")
else:
    print("retake")