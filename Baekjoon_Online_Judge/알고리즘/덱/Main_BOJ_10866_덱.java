import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main { // 제출일 2019-07-26 12:45
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		Deque<Integer> deck = new LinkedList<>();
		int loopCount = Integer.valueOf(reader.readLine());
		
		while(loopCount > 0){
			String line = reader.readLine();
			if(line.equals(""))continue;
			
			StringTokenizer tokenizer = new StringTokenizer(line, " ");
			//String next = tokenizer.nextToken();
			switch (tokenizer.nextToken()) {
			case "push_back":
				deck.addLast(Integer.valueOf(tokenizer.nextToken()));
				break;

			case "push_front":
				deck.addFirst(Integer.valueOf(tokenizer.nextToken()));
				break;
				
			case "pop_front":
				writer.write(String.valueOf(deck.peekFirst() == null? -1 : deck.pollFirst()));
				writer.write("\n");
				break;
				
			case "pop_back":
				writer.write(String.valueOf(deck.peekLast() == null? -1 : deck.pollLast()));
				writer.write("\n");
				break;
			
			case "size":
				writer.write(String.valueOf(deck.size()));
				writer.write("\n");
				break;
				
			case "empty":
				writer.write(String.valueOf((deck.isEmpty()? "1" : "0")));
				writer.write("\n");
				break;
				
			case "front":
				writer.write(String.valueOf(deck.peekFirst() == null? -1 : deck.peekFirst()));
				writer.write("\n");
				break;
				
			case "back":
				writer.write(String.valueOf(deck.peekLast() == null? -1 : deck.peekLast()));
				writer.write("\n");
				break;
//			default:
//				writer.write(next);
//				writer.write("\n");
//				break;
			}			
			loopCount--;
		}
		writer.flush();
	}
}