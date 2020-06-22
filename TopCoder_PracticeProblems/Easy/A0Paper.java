public class A0Paper { // 제출일 2020-06-22 20:50
    public String canBuild(int[] A){
        for(int i=A.length-1; i>0; i--){
			A[i-1] += A[i]/2;
        }
        if(A[0] > 0) {
            return "Possible";
        } else {
            return "Impossible";
        }
    }
}