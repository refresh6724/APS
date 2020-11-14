def solution(arr):
    if len(arr) <= 1:
        return [-1]
    else:
        min_val = min(arr)
        arr.remove(min_val)
    return arr
    
def solution1(arr): 
    arr.remove(min(arr))
    return [-1] if arr == [] else arr
    
def solution2(arr):   
    return [i for i in arr if i > min(arr)] if len(arr) > 1 else [-1]

if __name__ == "__main__":
    arr = [4,3,2,1]    
    result = [4,3,2]
    print(result, solution(arr), solution1(arr), solution2(arr))

    arr, result = [10], [-1]
    print(result, solution(arr), solution1(arr), solution2(arr))
    