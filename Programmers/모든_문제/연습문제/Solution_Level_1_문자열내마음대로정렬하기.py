def solution(strings, n):
    strings.sort()
    lst = []
    from string import ascii_lowercase
    ls = list(ascii_lowercase)
    for i in ls:
        for j in strings:
            if j[n] == i:
                lst.append(j)         
    return lst
    
def solution1(strings, n):   
    new =[]
    answer =[]
    for i in range(len(strings)):
        a = strings[i][n]
        b = a+strings[i]
        new.append(b)
    new.sort()
    for i in range(len(new)):
        c = new[i][1:]
        answer.append(c)
    return answer
    
def solution2(strings, n): 
    return sorted(sorted(strings), key=lambda x: x[n])

if __name__ == "__main__":
    strings = ["sun", "bed", "car"]
    n = 1
    result = ["car", "bed", "sun"]
    print(result, solution(strings, n), solution1(strings, n), solution2(strings, n))

    strings, n, result = ["ccd", "ccc", "cc", "ccb"], 1, ["ccb", "cc", "ccc", "ccd"]
    print(result, solution(strings, n), solution1(strings, n), solution2(strings, n))
    