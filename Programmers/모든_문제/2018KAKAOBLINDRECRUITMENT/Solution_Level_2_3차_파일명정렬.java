import java.util.Arrays;
import java.util.Comparator;

public class Solution_Level_2_3차_파일명정렬 {

	// test
	public static void main(String[] args) {
		String[] files;
		
		files = new String[] {"foo9.txt", "foo010bar020.zip","F-15"};
		System.out.println(Arrays.toString(solution(files)));
		files = new String[] {"MUZI01.zip","muzi1.png"};
		System.out.println(Arrays.toString(solution(files)));
		files = new String[] {"muzi1.txt","MUZI1.txt","muzi001.txt","muzi1.TXT"};
		System.out.println(Arrays.toString(solution(files)));
		files = new String[] {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		System.out.println(Arrays.toString(solution(files))); // {"img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"};
		files = new String[] {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
		System.out.println(Arrays.toString(solution(files))); // {"A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"};
	}

	public static String[] solution(String[] files) {
		String[] ret = files.clone();		
		Arrays.sort(ret, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {				
				String[] hn1 = headNum(o1);
				String[] hn2 = headNum(o2);
				
				if(hn1[0].compareTo(hn2[0]) == 0) {
					return Integer.parseInt(hn1[1]) - Integer.parseInt(hn2[1]);
				}
				return hn1[0].compareTo(hn2[0]);				
			}			
		});        
        return ret;
    }
	private static String[] headNum(String o) {
		char[] c = o.toCharArray();
		int idx = 0;
		StringBuilder sb = new StringBuilder();
		for (idx = 0; idx < c.length ; idx++) {
			if(!Character.isDigit(c[idx])) {
				sb.append(c[idx]);
			} else {
				break;
			}
		}
		String h = sb.toString().toLowerCase();
		sb = new StringBuilder();
		for ( ; idx < c.length; idx++) {
			if(Character.isDigit(c[idx])) {
				sb.append(c[idx]);
			} else {
				break;
			}
		}
		String n = sb.toString();
		
		return new String[] {h, n};
	}
}