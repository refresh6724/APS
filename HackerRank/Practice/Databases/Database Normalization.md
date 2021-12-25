도부이결다조

# #1 - 1NF

제1정규형은 도메인이 원자값이어야 한다는 것이다.
따라서 Color가 콤마로 구분된 경우의 tuple을 나누어 표시해야 한다


## 주어진 테이블 PRODUCT

*Product-ID*    *Colors*    *Price*
1               Red,Green   15.0
2               Blue        18.0
3               Yellow,Pink 2.5

## 1정규형 분해

*Product-ID*   *Price*
1              15.0
2              18.0
3              2.5

*Product-ID*    *Colors*    
1               Red
1               Green 
2               Blue        
3               Yellow
3               Pink

A. X=3, Y=5, Z=2


# #2 - 1/2/3 NF

Q. 어떤 테이블이 도시와 우편 번호 컬럼을 가지고 있을 때 Many-to-One 관계이다.
이 테이블은 x 정규형(NF)이 아니다. x는? 

A. 3

# #3

Q. 학생과 과목 테이블이 Many-to-Many 관계이다. 
2정규형을 만족하기 위해 분해할 때 필요한 최소한의 테이블 수는?

A. 3

# #4

Q. 어떤 데이터베이스의 모든 테이블이 최소 2정규형을 만족할 때 테이블 개수가 10개이다.
각 테이블은 오직 키와, non키 2개의 컬럼으로 이루어져 있을 때 3정규형으로 표현하기 위한 최소 테이블 개수는?

A. 10
문제의 의미가 뭔지 잘 모르겠다.

# #5

Q. Relation R(a,b,c,d) 와 관계식이 존재할 때 
a,c -> b,d
a,d -> b
a,b는 primary key

이 릴레이션은 1,2,3,BC(3.5)NF 중 하나이다. 가능한 최대값은?

A. 3

해설 
```
Any R is in 2NF, if every non-key (or non-prime) attribute is fully functionally dependent on the whole key (not a subset of it). Note that a, b, and c are all prime attributes (part of candidate key), because ab and ac are candidate keys. That leaves us to check d only. There is nothing to suggest that a->d or b->d or c->d, i.e. there is no FD from a subset of the key(s) to d.

Hence, the given R is in 2NF.
```

