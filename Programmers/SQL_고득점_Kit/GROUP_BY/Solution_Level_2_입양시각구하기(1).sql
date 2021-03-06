select hour(datetime) as "HOUR", count(*) as "COUNT"
from animal_outs
group by hour(datetime)
having HOUR > 8 and HOUR < 20
order by hour(datetime)