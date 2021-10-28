# 첫째 줄에 정수 n(2 ≤ n ≤ 100)을 입력받고 
# 다음 줄부터 n명 학생의 3과목 점수를 입력받아 평균을 구하여 점수가 높은 순으로 출력하시오.
# (평균은 소수 둘째 자리에서 반올림하여 소수 첫째 자리까지 출력한다.) 

n = int(input())
avg = []
for i in range(n):
    line = list(map(int, input().split()))
    avg.append(sum(line)/3)

avg.sort(reverse=True)
for i in avg:
    print(f'%.1f' % i)