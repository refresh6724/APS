import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_D0_1767_프로세서연결하기 { // 제출일 2019-07-30 13:38
	// D없음 1767
	// map 크기는 7이상 12이하
	// core 개수는 1이상 12이하
	// 모든 코어가 연결되지 않을 수 있다
	public static int T; //테스트케이스 수
	public static int N; //배열 길이
	public static int[][] Map = new int[12][12]; // 맵을 저장할 배열
	public static boolean[][] Check = new boolean[12][12]; // 
	public static int Answer; // MaxCore일때 가장 짧게 연결된 길이
	public static int MaxCore; // 가장 많이 연결되었을때의 코어 수
	public static int[] MaxLength = new int[13];// 코어개수 1-12에 따른 길이 저장
	//public static int AlreadyConnectedCore;// 가장자리에 있는 코어 수
	public static ArrayList<int[]> Core; // 가장자리 코어를 제외한 코어의 위치를 저장할 배열
	public static int CoreSize;
	public static int[][] CheckDirection = new int[12][4]; // 0~11번 코어가 사방 탐색이 가능한지 여부를 저장할 배열
	public static int[] dx = {-1, 1, 0, 0}; // 상하좌우
	public static int[] dy = {0, 0, -1, 1}; // 상하좌우
	public static int[] CoreDirection = new int[12]; // 코어의 출발 방향 저장
	public static void main(String[] args) {
		sc.init();
		// 테스트케이스
		T = sc.nextInt();
				
		for(int t=1; t<=T; t++) {
			// 테스트케이스 시작시 초기화해야하는 변수			
			Answer = 0;			
			MaxCore = 0;
			Arrays.fill(MaxLength, -1); // 코어개수가 0개일때부터 12개일때까지 최대 길이를 저장할 배열
			//AlreadyConnectedCore = 0; // 이건 굳이 필요한가?
			Core = new ArrayList<int[]>();
			for(int[] row:CheckDirection) {
				Arrays.fill(row, -1); //기본적으로 모든 방향으로의 연결이 불가능 -1 하다고 설정하고 시작
			}
			//Arrays.fill(CoreDirection, 0);
			// 새로 만들어 넘겨줘야 하는 변수
			// boolean[][] Check = new boolean[12][12]; 
			// 각각의 코어 연결 시도 중에 지도가 계속 바뀌므로
			// 전역 또는 정적 변수로 선언시 백트래킹이 필요하다.
			// 메모리에 여유가 있다면 매개변수로 전해주는 것이 더 좋을 듯
			
			// 입력 시작
			N = sc.nextInt(); // 경계조건 이내에서 매번 덮어쓰기하므로 맵의 나머지 부분을 건드릴 필요는 없다
			for(int row =0 ;row <N; row++) {
				for(int col=0; col<N; col++) {
					Map[row][col] = sc.nextInt(); // 맵 입력
					if(Map[row][col] == 1) { // 코어가 입력 되었다면
						if(row != 0 && row != N-1 && col != 0 && col != N-1) {
							int[] newCore= {row, col};
							Core.add(newCore);
						} // 가장자리일 경우 스킵, 아닐 경우 Core에 위치를 추가한다
						// else AlreadyConnectedCore++;		
					} 
				}
			} // map 입력 끝
			CoreSize = Core.size();
			// 코어마다 상하좌우로 얼마나 가야 연결되는지 체크
			for(int coreIdx =0; coreIdx < CoreSize; coreIdx++) {
				check4direction(coreIdx);
			}
			Arrays.fill(CoreDirection, -1); // 0상 1하 2좌 3우
			run(0);			
			System.out.printf("#%d %d\n",t, Answer);
		} // testcase end	
	} // main end
	
	public static void check4direction(int coreIdx) {
		int row = Core.get(coreIdx)[0];
		int col = Core.get(coreIdx)[1];
		for(int dir=0; dir<4; dir++) { // 방향 상하좌우
			boolean isReach = false;
			int len = 1;
			while(true) {
				int nextRow = row+len*dx[dir];
				int nextCol = col+len*dy[dir];
				if(nextRow<0 || nextCol<0 || nextRow == N || nextCol == N) {
					isReach = true;
					break;
				} else { // 가장자리를 넘을 때 까지 0이외의 수를 만났는가
					if(Map[nextRow][nextCol] != 0)
						break;
				}	
				len++; // 다음 길이를 확인한다
			}
			if(isReach) {
				len--;
				CheckDirection[coreIdx][dir] = len; // 코어번호 idx가 방향 dir로 len만큼 가면 전력이 공급된다
			} // ChcekDirection이 -1이면 해당 방향에 장애물이 존재하여 dfs시 return 조건으로 사용할것
		} // for end
		return;
	} // check4direction end

	public static void run(int coreIdx) {
		// 모든 코어 방향을 체크했다면 실제 경로를 계산한다
		if(coreIdx == CoreSize) { 
			// 단, 방향이 정해진 코어의 수가 MaxCore수보다 적다면 계산하지 않는다.
			int cntCore = 0;
			for(int i=0; i<CoreSize; i++) {
				if(CoreDirection[i] != -1) cntCore++;
			}	
			if(cntCore < MaxCore) return;
			calc();
			return;
		}
				
		// 0번 코어부터 방향을 기록한다
		// 상하좌우 + -1 움직이지 않음 
		
		for(int dir=0; dir<5; dir++) { // 상하좌우
			if(dir == 4) {
				CoreDirection[coreIdx] = -1;
				run(coreIdx+1); 
			}else if(CheckDirection[coreIdx][dir] != -1) {
				//-1이 아니면 갈 수 있는 방향이므로 방향을 넣고 다음 코어로 넘어간다
				//CoreDirection.set(idx+1, dir);// ArrayList에서 index = 0을 허용하지 않음
				CoreDirection[coreIdx] = dir;
				run(coreIdx+1);
			} 
		}
		
	} // run end
	
	public static void calc() {
		// 모든 코어의 방향이 정해졌을 때 계산을 시작
		// 이전 탐색에서 경로로 체크한 길을 모두 해제
		for(boolean[] row:Check) {
			Arrays.fill(row, false);
		}
		// 현재 연결된 코어와 경로 길이
		int connected =0;
		int line =0;
		for(int idx=0; idx<CoreSize; idx++) {
			if(CoreDirection[idx] == -1) continue; // 연결되지 않으면 다음 코어 확인
			int row = Core.get(idx)[0];
			int col = Core.get(idx)[1];			
			int dir = CoreDirection[idx];
			int len=1;
			boolean isConnect = false;
			
			while(!isConnect) {
				int nextRow = row+len*dx[dir];
				int nextCol = col+len*dy[dir];
				if(nextRow<0 || nextCol<0 || nextRow == N || nextCol == N) {
					isConnect = true;
					break;
				} else {
					if(Map[nextRow][nextCol] != 0) break;
					else if(Check[nextRow][nextCol] == true) break;
				}
				len++;
			} // while end
			// 연결되었다면 현재 연결된 코어를 증가시켜주고
			if (isConnect == true)connected++;
			// Check에 기록해준다
			len =1;
			while(isConnect == true) {
				int nextRow = row+len*dx[dir];
				int nextCol = col+len*dy[dir];
				if(nextRow<0 || nextCol<0 || nextRow == N || nextCol == N) {					
					break;
				} else {
					Check[nextRow][nextCol] = true;
					line++;
				}
				len++;
			} // while end
		}// for end
		
		if(MaxCore <= connected) { // MaxCore개수가 이전과 같거나 많다면
			MaxCore = connected;
			if(MaxLength[MaxCore] == -1) { // 처음 저장한다면
				MaxLength[MaxCore] = line;
				Answer = MaxLength[MaxCore];
			} else if(MaxLength[MaxCore] > line) { // 두번째부터는 더 짧은 길이일때만
				MaxLength[MaxCore] = line;
				Answer = MaxLength[MaxCore];
			}
		}
		
	} // make end
	
	// 키보드 입력
	static class sc{
		private static BufferedReader br;
		private static StringTokenizer st;
		static void init() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer(" ");
		}
		static String readLine() {
			try {
				return br.readLine();
			} catch (IOException e) {}
			return null;
		}
		static String next() {
			while(!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {}				
			} return st.nextToken();
			
		}
		static int nextInt() {
			return Integer.parseInt(next());
		}
		static long nextLong() {
			return Long.parseLong(next());
		}
	}
} // solution end
