# 세 리스트를 입력받은 후, 모두 셋으로 형변환한 후, 세 집합의 교집합과 합집합을 구하여 출력하는 프로그램을 작성하시오.  

# 셋이 아니라 set이었다
a1 = set(list(map(int, input().split())))
a2 = set(list(map(int, input().split())))
a3 = set(list(map(int, input().split())))

print("Intersection:", end=" ")
print(a1.intersection(a2.intersection(a3)))
print("Union:", end=" ")
print(a1.union(a2.union(a3)))