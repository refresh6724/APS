# 세 개의 정수를 전달받아 최대값을 구하여 리턴하는 함수를 작성하고 
# 세 정수를 입력받아 최대값을 출력하는 프로그램을 작성하시오. 

def returnMax(a, b, c):
    return max(a, max(b, c))

aa, bb, cc = input().split()
print(returnMax(int(aa), int(bb), int(cc)))
