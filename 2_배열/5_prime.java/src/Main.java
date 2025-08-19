import java.util.Scanner;

public class Main {
    public int solution(int num) {
        int result = 0;

        int[] check = new int[num+1]; // n번 index까지 배열 만들기

        for(int i=2; i<=num; i++){ // 1. 숫자 2부터 시작
            if(check[i]==0) {      // 2. 해당 index의 값이 0 == 해당 수가 소수일 때,
                result++;          //    -> 카운트 증가
                
                for(int j=i; j<=num; j=j+i) { // 3. 그리고, 해당 수의 배수들을 전부 1로 처리
                    check[j] = 1;             //    -> 값=1 == 소수가 아닌 수들
                }
            }
        }

        return result;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Main T = new Main();

        int num = sc.nextInt();
        System.out.print(T.solution(num));
    }
}