"""
4가지 함수가 주어질 때 주어진 코드를 완성

1. Map (the mapper function)  
2. EmitIntermediate(the intermediate key,value pairs emitted by the mapper functions)  
3. Reduce (the reducer function)  
4. Emit (the final output, after summarization from the Reduce functions)

입력 형태
    
    [#Rows_Matrix_1] [#Columns_Matrix_1]
    [Row_1_Matrix_1]
    .
    .
    [Row_N_Matrix_1]
    [#Rows_Matrix_2] [#Columns_Matrix_2]
    [Row_1_Matrix_2]
    .
    .
    [Row_N_Matrix_2]

출력 형태

    [#Rows_Matrix_1] 행 [#Columns_Matrix_2] 열 매트릭스

Sample Input

    1
    3 2
    1 2
    2 3
    4 5
    2 3
    2 4 5
    3 6 7

Sample Output

    8 16 19 
    13 26 31 
    23 46 55

"""
import sys
from collections import OrderedDict

class MapReduce:
    def __init__(self):
        self.intermediate = OrderedDict()
        self.result = []

    def emitIntermediate(self, key, value):
        self.intermediate.setdefault(key, [])
        self.intermediate[key].append(value)


    def emit(self, value):
        self.result[value[0]][value[1]] = value[2]


    def execute(self, matrix1, matrix2, mapper, reducer):
        n = len(matrix1)
        m = len(matrix2[0])
        for i in range(0, n):
            self.result.append([0] * m)

        mapper(matrix1, matrix2)

        for key in self.intermediate:
            reducer(key, self.intermediate[key])

        for i in range(0, n):
            row = ""
            for j in range(0, m):
                row += str(self.result[i][j]) + " "
            print(row)

mapReducer = None

def mapper(matrix1, matrix2):
    # Start writing the Map code here
    r1 = len(matrix1)
    c1 = len(matrix1[0])
    c2 = len(matrix2[0])

    for h in range(r1):
        for i in range(c2):
            l = []
            for j in range(c1):
                l.append(matrix1[h][j]*matrix2[j][i])
            mapReducer.emitIntermediate(str(h)+' '+str(i), l)
    return;

def reducer(key, list_of_values):
    # Start writing the Reduce code here
    h, i = map(int, key.split())
    mapReducer.emit([h, i, sum(list_of_values[0])])
    return;

if __name__ == '__main__':
    testcases = int(sys.stdin.readline())
    for _ in range(testcases):
        mapReducer = MapReduce()
        dimensions = sys.stdin.readline().strip().split(" ")
        row = int(dimensions[0])
        column = int(dimensions[1])
        matrix1 = []
        matrix2 = []
        
        for i in range(row):
            read_row = sys.stdin.readline().strip()
            matrix1.append([])
            row_elems = read_row.strip().split()
            for j in range(0, len(row_elems)):
                matrix1[i].append(int(row_elems[j]))
        dimensions = sys.stdin.readline().strip().split(" ")
        row = int(dimensions[0])
        column = int(dimensions[1])
        
        for i in range(row):
            read_row = sys.stdin.readline().strip()
            matrix2.append([])
            row_elems = read_row.strip().split()
            for j in range(0, len(row_elems)):
                matrix2[i].append(int(row_elems[j]))
        
        mapReducer.execute(matrix1, matrix2, mapper, reducer)