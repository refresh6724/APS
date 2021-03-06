set @HOUR:=-1; # 0 에서 23 까지, 세미콜론 필수
select @HOUR:=@HOUR+1 as "HOUR",
	(select count(*)
	 from animal_outs
	 where hour(datetime) = @HOUR) as "COUNT"
from animal_outs
where @HOUR < 23;