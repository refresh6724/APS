# Relational Algebra - 3

- equality operator(=) 를 사용하는 join 조건은 무엇인가? 1

1. Equijoins 
  SELECT * FROM A JOIN B ON A.id = B.id
2. Cartesian
  SELECT * FROM A, B WHERE A.id = B.id
3. Natural
  SELECT * FROM A NATURAL JOIN B
4. Left
  SELECT * FROM A LEFT JOIN B ON A.id = B.id
  
# Relational Algebra - 4

- set operators(집합 연산자)의 순서는? 2

1. 수식에 따라 다르다
2. 좌에서 우로
3. 우에서 좌로
4. 유저 설정에 따라 다르다

# Database Query Languages

- 유저가 DB에 정보를 요청하는 언어는? 1

1. Query
2. Relational
3. Structural
4. Compiler

# Procedural Language

- 다음 중 절차적 언어는? 3

1. Domain relational calculus
  https://www.geeksforgeeks.org/domain-relational-calculus-in-dbms/
2. Tuple relational calculus
  https://www.geeksforgeeks.org/tuple-relational-calculus-trc-in-dbms/
3. Relational algebra
  https://www.geeksforgeeks.org/basic-operators-in-relational-algebra-2/
4. Query language

# Relations - 1

- 이 연산은 두 개의 릴레이션을 튜플의 집합으로 합치며, 각 릴레이션에서 튜플을 하나씩 가져와 하나의 튜플로 만든다. 2

1. Select
2. Join
3. Union
4. Intersection

# Relations - 2

- 이 연산의 결과는 두 릴레이션의 모든 튜플 페어를 포함하되 각 속성의 값이 일치하는 경우만 포함한다. 2

1. Join
2. Cartesian product
3. Intersection
4. Set difference

