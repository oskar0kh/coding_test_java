import java.util.Scanner;

public class Main {
    public int solution(int num, int[][] arr){
        int result = 0;

        // 1. 각 행 더하고, max값 찾기
        for(int i=0; i<num; i++) {
            int sum1 = 0;

            for(int j=0; j<num; j++) {
                sum1 += arr[i][j];
            }
            if(sum1 > result) result = sum1;
        }

        // 2. 각 열 더하고, max값 찾기
        for(int i=0; i<num; i++) {
            int sum2 = 0;

            for(int j=0; j<num; j++) {
                sum2 += arr[j][i];
            }
            if(sum2 > result) result = sum2;
        }

        int sum3 = 0;
        int sum4 = 0;

        // 3. 왼->오 대각선 더하고, max값 찾기
        for(int i=0; i<num; i++) {
            sum3 += arr[i][i];
        }
        if(sum3 > result) result = sum3;

        // 4. 오->왼 대각선 더하고, max값 찾기
        for(int i=num-1; i>=0; i--) {
            sum4 += arr[i][i];
        }
        if(sum4 > result) result = sum4;

        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Main T = new Main();

        int num = sc.nextInt();
        int[][] arr = new int[num][num];

        for(int i=0; i<num; i++) {
            for(int j=0; j<num; j++) {
                arr[i][j] = sc.nextInt(); // 2차원 배열
            }
        }

        System.out.println(T.solution(num, arr));
    }
}