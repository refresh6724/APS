"""
4가지 함수가 주어질 때 주어진 코드를 완성

1. Map (the mapper function)  
2. EmitIntermediate(the intermediate key,value pairs emitted by the mapper functions)  
3. Reduce (the reducer function)  
4. Emit (the final output, after summarization from the Reduce functions)

입력 형태
    
    Employee [Person_Name] [SSN]
    Department [SSN] [Department_Name]

출력 형태

    ([SSN] [Employee_Name] [Department_Name])

Sample Input

    Department,1234,Sales
    Employee,Susan,1234
    Department,1233,Marketing
    Employee,Joe,1233
    Department,1233,Accounts

Sample Output

    ('1233', 'Joe', 'Accounts')
    ('1233', 'Joe', 'Marketing')
    ('1234', 'Susan', 'Sales') 

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
        self.result.append(value) 

    def execute(self, data, mapper, reducer):
        for record in data:
            mapper(record)

        for key in self.intermediate:
            reducer(key, self.intermediate[key])

        self.result.sort()
        for item in self.result:
            print (item)

mapReducer = MapReduce()

def mapper(record):
    #Start writing the Map code here

    w1, w2, w3 = record.rstrip().split(',')
    if w1 == 'Department':
        mapReducer.emitIntermediate(w2, ('D', w3))
    elif w1 == 'Employee':
        mapReducer.emitIntermediate(w3, ('E', w2))

    return;

def reducer(key, list_of_values):
    #Start writing the Reduce code here

    list_of_values.sort()
    name = list_of_values[-1][-1]
    for item in list_of_values:
        if item[0] == 'D':
            mapReducer.emit((key, name, item[-1]))    

    return;

if __name__ == '__main__':
    inputData = []
    for line in sys.stdin:
        inputData.append(line)
    mapReducer.execute(inputData, mapper, reducer)