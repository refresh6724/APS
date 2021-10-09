# 입력된 수 만큼 반복하며 놀이기구 이름과 격렬함의 정도를 입력받아
# 다음과 같이 튜플의 리스트로 만들어 출력하는 프로그램을 작성하시오.

n = int(input())
list = []
for i in range(n):
    a, b = input().split()     
    list.append((a,b))
print(list)
