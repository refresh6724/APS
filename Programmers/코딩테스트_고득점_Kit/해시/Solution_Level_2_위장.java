import java.util.*;

public class Solution_Level_2_위장 { // 제출일 2020-07-30 23:10
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++) {
            if(map.containsKey(clothes[i][1])) {
                 map.put(clothes[i][1], map.get(clothes[i][1])+1);
            }else {
                 map.put(clothes[i][1], 1);
            }
           
        }
        
        for(Map.Entry val : map.entrySet()) {
            answer *= ((int)val.getValue()+1);
        }
        
        return answer-1;
    }
}