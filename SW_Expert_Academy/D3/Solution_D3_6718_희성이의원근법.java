import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class Solution_D3_6718_희성이의원근법 { // 제출일 2020-05-31 22:47 38,472 kb 169 ms
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
 
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            sb.append("#").append(tc).append(" ");
             
            int len = br.readLine().length();
            switch(len) {
            case 1:
                sb.append(0);
                break;
            case 2:             
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(len-2);
                break;
            default:
                sb.append(5);
                break;
            }           
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}