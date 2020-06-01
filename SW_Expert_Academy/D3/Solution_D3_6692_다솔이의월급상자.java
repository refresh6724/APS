import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Solution_D3_6692_다솔이의월급상자 { // 제출일 2020-06-01 22:13 31,084 kb 151 ms
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
 
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
        	int n =Integer.parseInt(br.readLine());
        	double ans = 0;
        	for (int i = 0; i < n; i++) {
        		st = new StringTokenizer(br.readLine());
        		ans += Double.parseDouble(st.nextToken()) * Integer.parseInt(st.nextToken());				
			}        	
            sb.append('#').append(tc).append(' ').append(ans).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
