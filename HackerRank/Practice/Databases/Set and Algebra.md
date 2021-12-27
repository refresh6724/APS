# 1. Databases - Relational Calculus

Q. S = {4,5,6,7,10,11,19,18,3}
$$
\{x|\forall_y S(x) \land S(y) \rarr y \le x\}
$$

A. 19

# 2. Databases - Keys

Q. Primary key가 될 수 있는 컬럼

A. bookname

# 3. Databases - Natural Joins

Q. 릴레이션 R과 S가 natural join 했을 때
한 튜플 값이 27, x, y, z 이다. 각 값은?

```
R(A,B)
3 3
16 4
12 3
3 15
27 1

S(B,C,D)
50 1 6
1 55 8
4 3 9
```

A. x=50 y=1 z=6

# 4. Databases - Differences

Q. 릴레이션 R과 S의 차집합 R-S 의 한 튜플 값이 4, b, c 이다. 각 값은?

```
R(A,B,C)
1 2 3
4 2 3
4 5 6
2 5 3
1 2 6

S(A,B,C)
2 5 3
2 5 4
4 5 6
1 2 3
```

A. b=2 c=3
