def solution(a,b):
    answer = 0
    for i in range(len(a)):
        answer += a[i] * b[i]
    return answer

def solution1(a, b):
    answer = 0
    for x, y in zip(a,b):
        answer += x*y
    return answer
    
def solution2(a, b):    
    return sum([a*b for a, b in zip(a,b)])

if __name__ == "__main__":
    a = [1,2,3,4]
    b = [-3,-1,0,2]
    result = 3
    print(result, solution(a,b), solution1(a,b), solution2(a,b))

    a, b, result = [-1,0,1], [1,0,-1], -2
    print(result, solution(a,b), solution1(a,b), solution2(a,b))
    