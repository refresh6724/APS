import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
  
public class Main_JO_607_자가진단6 { // 제출일 2021-02-03 22:51
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
  
        // 20자 이하인 두 개의 문자열을 입력받아 
        // 첫 번째 문자열의 앞부분 두자를 두 번째 문자열의 앞부분에 복사하고 
        // 다시 뒷부분에 이어 붙여서 저장한 후 
        // 두 번째 문자열을 출력하는 프로그램을 작성하시오.
        // ABCDE QWERTY
        // ABERTYAB 
  
        st = new StringTokenizer(br.readLine());
        char[] a = st.nextToken().toCharArray();
        char[] b = st.nextToken().toCharArray();
        for(int i = 0; i < 2; i++) {
            b[i] = a[i];
        }
        String c = String.copyValueOf(b);
        c = c.concat(String.copyValueOf(a).substring(0,2));
        sb.append(c);
        bw.write(sb.toString());       
        bw.flush();
    }
  
}
