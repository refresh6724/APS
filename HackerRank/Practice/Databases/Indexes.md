# Index Architecture Types

Q. MS SQL Server의 인덱스 타입 분류는 몇 개인가?

A. 2, 클러스터와 논-클러스터가 있다.

# Indexes - 2

Q. MS SQL Server 의 Non-clustered indexes 의 low locators에 대해 옳은 것은? 3

1. 만약 테이블에 clustered index가 없다면 row locator는 row에 대한 key다.

2. 만약 테이블에 clustered index가 있거나 indexed view에 대한 index가 있다면 row locator는 row에 대한 pointer다.

3. 만약 테이블에 clustered index가 있거나 indexed view에 대한 index가 있다면 row locator는 row에 대한 key다.

4. 위 모두 옳지 않다.

## MSDN
https://docs.microsoft.com/en-us/previous-versions/sql/sql-server-2008-r2/ms177484(v=sql.105)?redirectedfrom=MSDN

# Indexes - 3

Q. MS SQL Server에 클러스터된 인덱스를 사용하여 데이터를 저장하는 두 가지 방법을 고려해보자.
  첫 번째로 fill factor가 20%이며 페이지당 자유행의 전체 개수인 것을 A라 하고
  두 번째는 fill facotr가 40%이며 페이지당 자유행의 전체 개수인 것을 B라 할 때 
  A와 B의 관계로 옳은 것은?
  
1. A = 1.33B
2. B = 1.33A
3. A = 0.67B
4. B = 0.67A

## 해설
https://www.mssqltips.com/sqlservertip/1940/understanding-sql-server-index-fill-factor-setting/

남은 비율 0.8과 0.6의 관계

정답 : A = 1.33B

# Indexes - 4

Q. MS SQL Server에서 composite indexex를 만드는 올바른 문법은?

1. <p>CREATE INDEX index_name</p> <p>ON table_name(column1), table_name(column2);</p>
2. <p>CREATE INDEX index_name</p> <p>ON table_name(column1) and table_name(column2);</p>
3. <p>CREATE INDEX index_name</p> <p>ON table_name(column1, column2);</p>
4. <p>All the above-mentioned syntax are correct.</p>

A. 3

