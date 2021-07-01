import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_JO_3293_비트연산1 { // 제출일 2021-07-01 23:57

	// 비트연산 bitwise operation
	// 1. ~ tilde, wave, not, 1을 0으로 0을 1로
	// 2. & ampersand, and, 둘 다 1이어야만 1
	// 3. | vertical bar, or, 둘 중 하나가 1이면 1
	// 4. ^ caret, xor, 둘이 다르면 1
	// 5. << left shift, 1당 2배
	// 6. >> right shift, 1당 반배(버림)
	//	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		// (1) a가 홀수인지 if문과 비트 연산자를 이용하여 판별하고자 한다. ?자리에 들어갈 비트연산자​는?
		// if(a ? 1){} /// c, c++인 경우
		// if((a ?1) == 1 )) {} /// java의 경우
		// 비트 마지막 첫자리(LSB)가 1이면 홀수 0이면 짝수이다
		// 따라서 해당자리 이외의 0이나 1은 모두 0으로 만들어야 하므로
		// 둘 다 1이어야만 1인 &를 사용해야 한다
		sb.append('&').append('\n');

		// (2) a가 짝수인지 if문과 비트 연산자를 이용하여 판별하고자 한다. ?자리에 들어갈 비트​연산자​는?
		// if(?a ? 1) {} /// c, c++인 경우
		// if((?a ?1) == 1 )) {} /// java의 경우​
		// (1)번 문제와 반대이므로 not연산자 ~를 사용한다
		sb.append('~').append('&').append('\n');

		// (3) a와 2의 k제곱을 곱한 결과(결과는 int 범위를 넘지 않는다.)를 구하고자 한다.​ ?자리에 들어갈 비트​연산자​는?
		// result = a ? k;
		// 단순 시프트 연산
		sb.append("<<").append('\n');

		// (4) a를 2의 k제곱으로 나눈 몫 p와 나머지 r 을 구하고자 한다. ?자리에 들어갈 비트​연산자​들은?
		// p = a ? k, r = a ? ((1 ? k) - 1);
		//
		sb.append(">>").append("&").append("<<").append('\n');

		// (5) 다음은 a와 b의 값을 서로 바꾸는 코드이다. ?자리에 들어갈 비트​연산자들은​?
		// a = a ? b, b = a ? b, a = a ? b;
		sb.append("^^^\n");

		// (6) a의 k번째(2의 k제곱 ​자리) 비트가 0인지 1인지 알아보고자 한다. ?자리에 들어갈 비트​연산자​들은​?
		// result = (a ? k) ? 1;
		sb.append(">>").append("&").append("\n");

		// (7) a의 k번째(2의 k제곱 ​자리) 비트만 0으로 바꾸고자 한다. ?자리에 들어갈 비트​연산자​들은​?
		// a = a ? (?(1 ? k));
		sb.append('&').append('~').append("<<").append('\n');

		// (8) a의 k번째(2의 k제곱 ​자리) 비트만 0이면 1로, 1이면 0으로 바꾸고자 한다. ?자리에 들어갈 비트​연산자​들은​?
		// a = a ? (1 ? k);
		sb.append('^').append("<<").append('\n');

		// (9) a가 2의 제곱수인지 판별하고자 한다. ?자리에 들어갈 비트​연산자들은​?
		// result = a ? (a - 1);
		// if( a > 0 && result==0) printf("%d is the power of 2.\n", a);
		sb.append('&').append('\n');

		// (10) a와 b의 같은 자리 비트를 비교한 결과 서로 다른 비트가 1개 이하인지 알아보고자 한다. ?자리에 들어갈 비트​연산자​들은​?
		// bit = a ? b; result = bit ? (bit -1); //
		// if(result==0) printf("%d and %d differ by below 1bit.\n", a, b); ​
		// 둘이 다른 비트가 1표시
		// a			1101 1101 1001
		// b 			1011 1100 0001
		// a^b 			0110 0001 1000
		// bit-1 		0101 0000 0111
		// bit&bit-1 	0111 0000 0000
		sb.append('^').append('&').append('\n');

		bw.write(sb.toString());
		bw.flush();

	}

}