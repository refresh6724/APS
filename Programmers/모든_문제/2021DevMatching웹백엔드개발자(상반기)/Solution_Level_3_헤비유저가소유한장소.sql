--mysql 
select id, name, p.host_id
from places p, 
	(
	select pp.host_id, count(*) as c
	from places pp
	group by pp.host_id
	having c > 1
	) a
where p.host_id = a.host_id
order by id;

--oracle
select id, name, p.host_id
from places p, 
	(
	select pp.host_id -- mysql과 다르게 count as 일 경우 ambigous가 뜬다
	from places pp
	group by pp.host_id
	having count(pp.id) > 1
	) a
where p.host_id = a.host_id
order by id;