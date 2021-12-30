import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * 주어진 단어와 빈 칸을 조합하여 크로스워드 퍼즐을 완성하기
     * 위치에 단어를 배치할 수 있는지 확인하고
	 * 가능하면 배치 
     * 불가능하다면 다음칸 
     * 모든 칸이 불가능하면 이전으로 돌아가기
     */
	
	static char[][] map;
	static int[][] chk;
	static List<int[]> start;
	static String[] word;
	static boolean[] visited;
	static boolean finished;
	static Set<String> crossPoint;


    public static List<String> crosswordPuzzle(List<String> crossword, String words) {
    
    	map = new char[10][10];
    	chk = new int[10][10];
    	int idx = 0;
    	for (String line : crossword) {
			map[idx++] = line.toCharArray();
		}
    	start = new ArrayList<>();
    	// 가로
    	for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(map[i][j] == '-' && chk[i][j] == 0) {
					start.add(new int[] {i,j,1});
					while(j < 10 && map[i][j] == '-') {
						chk[i][j++] = 1;
					}
				}
			}
		}
    	// 세로
    	for (int j = 0; j < 10; j++) {
    		for (int i = 0; i < 10; i++) {
    			if(map[i][j] == '-' && chk[i][j] < 2) {
					start.add(new int[] {i,j,2});
					while(i < 10 && map[i][j] == '-') {
						chk[i++][j] = 2;
					}
				}
			}
		}
    	word = words.split(";"); 
    	visited = new boolean[word.length];
    	finished = false;
    	crossPoint = new HashSet<>();
    	dfs(0);
    	return puzzle();
    }

	private static List<String> puzzle() {
		List<String> ret = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			ret.add(String.copyValueOf(map[i]));
		}
		return ret;
	}

	private static void dfs(int now) {
		
		if(now == word.length) {
			finished = true;
			return;
		}
		
		// word[now]가 들어갈 수 있는 장소에 넣기
		for (int i = 0; i < start.size(); i++) {
			if(!visited[now] && isPossible(now, start.get(i))) {
				visited[now] = true;
				replace(now, start.get(i));
				dfs(now+1);
				if(finished) {
					return;
				}
				undo(now, start.get(i));
				visited[now] = false;				
			}
		}
		
	}

	private static void undo(int now, int[] pos) {
		int i = pos[0];
		int j = pos[1];
		int d = pos[2];
		if(d == 1) {
			
			for (int k = 0; k < word[now].length(); k++) {
				if(crossPoint.contains(String.format("%d_%d", i,j+k))) {
					crossPoint.remove(String.format("%d_%d", i,j+k));
				} else {
					map[i][j+k] = '-';
				}				
			}
			
		} else {
			
			for (int k = 0; k < word[now].length(); k++) {
				if(crossPoint.contains(String.format("%d_%d", i+k,j))) {
					crossPoint.remove(String.format("%d_%d", i+k,j));
				} else {
					map[i+k][j] = '-';
				}
			}
			
		}
		
	}

	private static void replace(int now, int[] pos) {
		int i = pos[0];
		int j = pos[1];
		int d = pos[2];
		if(d == 1) {
			
			for (int k = 0; k < word[now].length(); k++) {
				if(map[i][j+k] != '-') {
					crossPoint.add(String.format("%d_%d", i,j+k));
				} else {
					map[i][j+k] = word[now].charAt(k);					
				}
			}
			
		} else {
			
			for (int k = 0; k < word[now].length(); k++) {
				if(map[i+k][j] != '-') {
					crossPoint.add(String.format("%d_%d", i+k,j));
				} else {
					map[i+k][j] = word[now].charAt(k);					
				}
			}
			
		}
		
	}

	private static boolean isPossible(int now, int[] pos) {
		int i = pos[0];
		int j = pos[1];
		int d = pos[2];
		if(d == 1) {
			
			int last = j + word[now].length();
			
			if(last > 10) {
				return false;
			}
			
			for (int k = j; k < last; k++) {
				if(map[i][k] != '-' && map[i][k] != word[now].charAt(k-j)) {
					return false;
				}
			}
			
			if(last < 10 && map[i][last] == '-') {
				return false;
			}			
			
		} else {
			
			int last = i + word[now].length();
			
			if(last > 10) {
				return false;
			}
			
			for (int k = i; k < last; k++) {
				if(map[k][j] != '-' && map[k][j] != word[now].charAt(k-i)) {
					return false;
				}
			}
			
			if(last < 10 && map[last][j] == '-') {
				return false;
			}	
			
		}
		
		return true;
		
	}

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<String> crossword = IntStream.range(0, 10).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        String words = bufferedReader.readLine();

        List<String> result = Result.crosswordPuzzle(crossword, words);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
