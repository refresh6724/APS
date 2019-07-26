import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.StringBuilder;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main { // 제출일 2019-07-26 11:33
	
	public static StringBuilder sb = new StringBuilder();
	private static BufferedReader br; 
	private static StringTokenizer st; 
    public static void main(String[] args) throws IOException{
    	br = new BufferedReader(new InputStreamReader(System.in));	
		st = new StringTokenizer(" ");
        String word = br.readLine();        
        sb.append(word);
        int cnt = 1; 
        while ((word=br.readLine())!=null ) {
        	if (word.startsWith(" ") || word.endsWith(" ") || cnt==100 || word.isEmpty()) {
                break;
            }
        	sb.append("\n");
        	sb.append(word);
        	cnt++;
        }       
    	System.out.println(sb);
    }
}

