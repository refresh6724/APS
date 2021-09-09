# (각 요소들은 10칸씩 공간을 확보하여 오른쪽으로 정렬하여 출력한다.)​ 
# 공백도 한 칸을 차지한다. "%10s %10s …" 또는 "{' pen ':10} {20:10}…​" 이렇게 하면 두 번째 요소는 공백을 포함하여 11칸을 확보하게 되므로 틀린 결과가 된다.

a = []
a.append(('item', 'count', 'price', 'rate'))
a.append(('pen', 20, 100, 50.5))
a.append(('note', 5, 95, 35.3))
a.append(('eraser', 110, 97, 14.2))

for x in a:
    print(f'{x[0]:>10}{x[1]:>10}{x[2]:>10}{x[3]:>10}')
