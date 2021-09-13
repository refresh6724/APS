from itertools import combinations

def solution(numbers):
    answer = []
    for i in range(len(numbers)):
        for j in range(i+1, len(numbers)):
            ab = numbers[i] + numbers[j]
            if not ab in answer:
                answer.append(ab)
    answer.sort()
    return answer

def solution1(numbers):
    answer = []
    for i in range(len(numbers)):
        for j in range(i+1, len(numbers)):
            answer.append(numbers[i] + numbers[j])   
    return sorted(list(set(answer)))
    
def solution2(numbers):    
    return sorted(list(set([sum(i) for i in combinations(numbers, 2)])))

if __name__ == "__main__":
    numbers = [2,1,3,4,1]	
    result = [2,3,4,5,6,7]
    print(result, solution(numbers), solution1(numbers), solution2(numbers))

    numbers, result = [5,0,2,7], [2,5,7,9,12]
    print(result, solution(numbers), solution1(numbers), solution2(numbers))
    