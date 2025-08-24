import java.util.Scanner;

public class Main {
    public int solution(int num, int[][] arr){
        int result = 0;

        // (i=1, j=1 부터 시작)
        // 자기 자신이랑 '상하좌우' 값 전부 비교 -> 자기가 제일 크다면, peak 카운트 증가

        for(int i=1; i<num+1; i++) {
            for(int j=1; j<num+1; j++) {
                int tmp = arr[i][j];

                if(tmp > arr[i][j-1] && tmp > arr[i-1][j] && tmp > arr[i+1][j] && tmp > arr[i][j+1]) result++;
            }
        }

        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Main T = new Main();

        int num = sc.nextInt();
        int[][] arr = new int[num+2][num+2]; // 가장자리 부분 배열 추가

        for(int i=1; i<num+1; i++) {
            for(int j=1; j<num+1; j++) {
                arr[i][j] = sc.nextInt(); // 2차원 배열
            }
        }

        System.out.println(T.solution(num, arr));
    }
}