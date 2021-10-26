# 10개의 실수를 입력받아 첫 번째 입력 값과 마지막 입력 값의 평균을 반올림하여 소수 첫째자리까지 출력하는 프로그램을 작성하시오.  

# f = open("io_442.txt", "r") # VS Code에서 열려있는 편집기 위치에 따라 상대경로가 결정된다
 
# a = list(map(float, f.readline().split()))
a = list(map(float, input().split()))

print(f'%.1f' % ((a[0] + a[-1])/2))
 
# f.close()