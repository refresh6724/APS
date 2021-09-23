# 몇 가지 과목의 점수를 입력받아서 평균을 구하여 출력하고
# 평균이 80점 이상이면 "pass", 아니면 "fail"이라고 출력하는 프로그램을 작성하시오. 
# 평균은 반올림하여 소수 첫째자리까지 출력한다.​

sum = 0
cnt = 0
for x in input().split():
	a = int(x)
	sum += a
	cnt += 1
	
avg = sum/cnt;
print(f'avg : %.1f' % avg)
print("pass" if avg >= 80 else "fail")