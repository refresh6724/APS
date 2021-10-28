# 3000 이하의 정수로 된 시작 연도와 끝 연도를 입력받아서 윤년이 몇 번인지를 구하여 출력하시오. 

def isleaf(y):
    if y%4 == 0:
        if y%100 == 0:
            if y%400 == 0:
                return True
            return False
        return True
    

a, b = map(int, input().split())

cnt = 0
for i in range(a, b+1):
    if isleaf(i):
        cnt += 1

print(cnt)