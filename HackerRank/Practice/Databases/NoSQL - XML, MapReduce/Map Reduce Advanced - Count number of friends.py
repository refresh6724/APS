"""
4가지 함수가 주어질 때 주어진 코드를 완성

1. Map (the mapper function)  
2. EmitIntermediate(the intermediate key,value pairs emitted by the mapper functions)  
3. Reduce (the reducer function)  
4. Emit (the final output, after summarization from the Reduce functions)

Sample Input

Joe Sue
Sue Phi
Phi Joe
Phi Alice

Sample Output

{"key":"Alice","value":"1"}
{"key":"Joe","value":"2"}
{"key":"Phi","value":"3"}
{"key":"Sue","value":"2"}

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
            print ("{\"key\":\""+item[0]+"\",\"value\":\"" + str(item[1]) + "\"}")

mapReducer = MapReduce()

def mapper(record):
    #Start writing the Map code here

    # a = record.split() 
    # mapReducer.emitIntermediate(a[0],a[1]) 
    # mapReducer.emitIntermediate(a[1],a[0])

    v1, v2 = record.split()
    mapReducer.emitIntermediate(v1, v2)
    mapReducer.emitIntermediate(v2, v1)

    return;

def reducer(key, list_of_values):
    #Start writing the Reduce code here

    mapReducer.emit((key,len(list_of_values))) # tuple - immutable

    # mapReducer.emit([key, len(list_of_values)]) # list - mutable - not recommend

    return;

if __name__ == '__main__':
    inputData = []
    for line in sys.stdin:
        inputData.append(line)
    mapReducer.execute(inputData, mapper, reducer)