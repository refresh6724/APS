# 주차장에 세워진 자동차의 차종을 모두 입력 받아, 
# 중복되어 입력된 이름을 제거한 후, 
# 알파벳 순서대로 출력하고, 그 개수를 출력하는 프로그램을 작성하시오. 

a = set(input().split())
b = sorted(list(a))
print(*b, sep=" ")
print(len(b))