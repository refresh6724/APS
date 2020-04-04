import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //System.out.println("1 이상의 정수를 입력하세요");
        Scanner scan = new Scanner(System.in);
        for (;;) {
            int total = 0;
            int many = 0;
            float average = 0.0f;
            int num = scan.nextInt();   
            while(num < 100) {
                total += num;
                //System.out.println(total);
                //System.out.println(num);
                //System.out.println(many);
                many++;
                num = scan.nextInt();
            }
            total += num;
            many++;
            System.out.println(total);
            average = (float)((float)total/many);
            System.out.printf("%.1f", average);
             
            break;
        }
    }
}