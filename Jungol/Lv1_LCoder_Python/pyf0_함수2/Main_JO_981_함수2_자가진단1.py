# 10 이하의 자연수 n을 입력받고 n개의 정수를 입력받아 
# 내림차순으로 정렬하여 출력하는 프로그램을 작성하시오. (리스트를 전달하는 함수를 이용한다.) 

def descendingOrder(x):
    return sorted(x, reverse=True)

n = int(input())
a = list(map(int, input().split()))
b = descendingOrder(a)
print(*b, sep=" ")
