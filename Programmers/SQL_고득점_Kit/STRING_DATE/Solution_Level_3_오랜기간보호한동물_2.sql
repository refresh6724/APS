# mysql
select i.animal_id, i.name
from animal_ins i
join animal_outs o 
using (animal_id) -- 또는 on (i.animal_id = o.animal_id)
order by (o.datetime - i.datetime) desc
limit 2; 


# oracle
select animal_id, name
from (
    select i.animal_id, i.name, (o.datetime - i.datetime) as t
    from animal_ins i
    join animal_outs o 
    on (i.animal_id = o.animal_id)
    order by t desc
	-- 또는 rownum 대신 FETCH FIRST 2 ROWS ONLY
)
where rownum <= 2