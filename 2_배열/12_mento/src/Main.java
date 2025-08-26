import java.util.Scanner;

public class Main {
    public int solution(int n, int m, int[][] arr) {
        int result = 0;

        // 인덱스 번호가 M번 연속 상대방보다 작으면, count++

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main T = new Main();

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(T.solution(n, m, arr));
    }
}