# 세 개의 실수를 입력받아, 그 합, 곱으로 이루어진 튜플을 출력하는 프로그램을 작성하시오. (소수점 셋째 자리까지​)

flist = list(map(float, input().split()))
ftp = (sum(flist), eval('*'.join((str(x) for x in flist))))
# print(ftp)
# print(f'(%.3f, %.3f)' % (ftp[0], ftp[1]))
# print(f'(%f, %f)' % (round(ftp[0], 3), round(ftp[1], 3))) # error
ftp3 = (round(ftp[0],3), round(ftp[1],3))
print(ftp3)
# 이유는 알 수 없지만 테스트케이스 1개가 잘못되어 있었다
# 9.244 6.291 4.518
# => Solution Data top 100 lines
# (20.053, 262.74)
# => User Output top 100 lines
# (20.053, 262.740)