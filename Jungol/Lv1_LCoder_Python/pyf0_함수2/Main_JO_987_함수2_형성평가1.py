# 정수 N을 입력받고 다시 N개의 정수를 입력받아 
# 내림차순으로 정렬하여 출력하는 프로그램을 작성하시오.
# (1 ≤ N ≤ 15, 입력과 출력, 정렬은 모두 함수를 이용할 것)

def lineinput(x):
    return list(map(int, input().split()))

def linereversesort(x):
    return sorted(x, reverse=True)

def lineprint(x):
    print(*x, sep=" ")

n = int(input())
lineprint(linereversesort(lineinput(n)))
