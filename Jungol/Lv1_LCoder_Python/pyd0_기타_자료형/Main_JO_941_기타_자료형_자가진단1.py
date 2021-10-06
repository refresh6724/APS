# 튜플 ('Forest', 'Ocean', 'Mountain', 'Plain')을 만들고, 1부터 4 사이의 정수를 입력 받아,
# 입력 받은 정수 번째 원소를 출력하는 프로그램을 작성하시오. 
# 범위를 벗어나는 정수를 입력 받았을 경우, 'Input Error'를 출력하시오. 

tp = ('Forest', 'Ocean', 'Mountain', 'Plain')
n = int(input())
dic = {}
for i in range(len(tp)):
    dic[i] = tp[i]
print(dic.get(n-1, "Input Error"))
