# 1반부터 6반까지의 평균 점수를 저장한 후, 
# 두 반을 입력 받아 두 반 평균 점수의 합을 출력하는 프로그램을 작성하시오. 
# 반 별 평균 점수는 초기 값으로 1반부터 차례로
# 85.6, 79.5, 83.1, 80.0, 78.2, 75.0 으로 초기화하고 출력은 소수 첫째 자리까지 한다.​

score = []
score.append(85.6)
score.append(79.5) 
score.append(83.1) 
score.append(80.0) 
score.append(78.2) 
score.append(75.0)

aa, bb = input().split()
a = int(aa)-1
b = int(bb)-1
sum = score[a] + score[b]
print(f'%.1f' % sum)