# 3개의 정수를 입력받아 합계와 평균을 구하여 출력하되 평균은 정수부분만 출력하고 나머지를 예와 같이 출력하시오. 

lin = list(map(int, input().split()))

print(f'%d %d...%d' % (sum(lin), (sum(lin)//3), (sum(lin)%3)))