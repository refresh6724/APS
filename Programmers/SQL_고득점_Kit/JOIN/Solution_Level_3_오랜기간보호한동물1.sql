# 아직 입양되지 않고 오랫동안 보호소에 있던 동물 3
select i.name, i.datetime
from animal_ins i
left outer join animal_outs o
on (i.animal_id = o.animal_id)
where o.datetime is null
order by i.datetime asc
limit 3
