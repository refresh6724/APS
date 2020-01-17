#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

string x, y, z="";
int carry = 0;
int len = 0;

int main(int argc, char* argv[]) 
{
	cin >> x >> y;
	
	// 뒤집어서 
	reverse(x.begin(), x.end());
	reverse(y.begin(), y.end());
 
	// 길이를 맞춰준다
	while (x.length() < y.length()) {
		x += '0';
	}
	while (x.length() > y.length()) {
		y += '0';
	}
	
	// 매 자리마다 계산해서 z에 붙여준다
	len = x.length();
	for(int i=0; i<len; i++) {
		carry = x[i] - '0' + y[i] - '0' + carry;
		if(carry >= 10) {
			carry -= 10;
			z += to_string(carry);
			carry = 1;
		} else {
			z += to_string(carry);
			carry = 0;
		}
	}
	if(carry == 1) {
		z += '1';
	}
	
	// 다시 뒤집어서 출력
	reverse(z.begin(), z.end());
	cout << z;
	
	return 0;
}