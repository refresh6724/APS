#include <stdio.h>

int main() {
	int T, N, min, input, count;
	scanf("%d", &T);
	for(int t=1; t<=T; t++) {
		count = 0;
		min = 100001;
		scanf("%d", &N);
		for(int i=0; i<N; i++) {
			scanf("%d", &input);
			if(input<0) input = -input;
			if(min > input) {
				count = 1;
				min = input;
			} else if(min == input) {
				count++;
			}
		}
		printf("#%d %d %d\n", t, min, count);	
	}
}