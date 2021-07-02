import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_JO_1419_엔디안 { // 제출일 2021-07-02 23:56

	// 32bit unsigned int 305,419,896 (0x12345678)
	// 00010010 00110100 01010110 01111000 (Big Endian)
	// 01111000 01010110 00110100 00010010 (Little Endian)
	// Big Endian의 값을 그대로 Little Endian 방식으로 읽었을 경우 2,018,915,346 (0x78563412)

	static char[] data;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = 0;

		String s = br.readLine().trim();
		try {
			input = Integer.parseUnsignedInt(s);
		} catch (Exception e) {
			input = Integer.parseUnsignedInt(s, 16);
		}

		data = new char[8];
		Arrays.fill(data, '0');
		// toHexString은 8자리가 되지 않으면 0을 채우지 않고 1~7자리 숫자를 만들기 때문에
		// %08X 포맷을 사용해 빈자리를 0으로 채워준다
		String hexStr = Integer.toHexString(input);
		if (hexStr.length() < 8) {
			data = String.format("%08X", hexStr).toCharArray(); // 12345678 을 78563412 로 바꾸기
		} else { // 이미  8자리인 경우 오류 발생
			data = hexStr.toCharArray(); // 12345678 을 78563412 로 바꾸기
		}

		int[] order = { 7, 8, 5, 6, 3, 4, 1, 2 };
		for (int i = 0; i < 4; i++) {
			swap(i, order[i] - 1);
		}
		// 주의점 마스킹 데이터를 받을때는 한단계 높은 데이터 타입을 사용해야한다
		System.out.println(Long.parseUnsignedLong(String.copyValueOf(data), 16));
	}

	private static void swap(int i, int j) {
		char tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}

}