# 첫 번째 수는 1이고 N번째 수는 (N / 2)번째 수와 (N - 1)번째 수의 합으로 구성된 수열이 있다. 
# 50 이하의 자연수 N을 입력받아 재귀호출을 이용하여 
# 이 수열에서 N번째 수를 출력하는 프로그램을 작성하시오. (1 2 3 5 7 10 13 18 …) 

def recursive(n):
    if n==1:
        return 1
    return recursive(n//2) + recursive(n-1)

# 1 2 3 4 5  6  7 
# 1 2 3 5 7 10 13
# list[1] = list[1] = 1
# list[2] = list[2//2] + list[2-1] = list[1]+list[1] = 2
# list[3] = list[3//2] + list[3-1] = list[1]+list[2] = 3
n = int(input())
print(recursive(n))