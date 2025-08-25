import java.util.Scanner;

public class Main {
    public int solution(int num, int[][] arr) {
        int result = 0;
        int max = Integer.MIN_VALUE;

        for(int i=1; i<=num; i++) {             // 1. i번 학생 선택
            int count = 0;                      //  i번 학생과 숫자 같은 j번 학생이 몇 명 있는지 세기

            for(int j=1; j<=num; j++) {         // 2. j번 학생 선택
                for(int k=1; k<=5; k++) {       //  i번 학생과 j번 학생 -> 'k학년' 단위로 비교

                    if(arr[i][k] == arr[j][k]) {// 3. 'i번 학생의 k학년 숫자 == j번 학생의 k학년 숫자' 일때,
                        count++;                //  학생수 count 증가
                        break;                  //  j번 학생 -> j+1번 학생으로 넘어가기
                    }
                }
            }

            if(count > max) { // 4. 제일 count가 큰 i번째 학생 찾기
                max = count;
                result = i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main T = new Main();

        int num = sc.nextInt();
        int[][] arr = new int[num+1][6];

        // i : 학생 (세로)
        // j : 학년 (가로)
        for(int i=1; i<=num; i++) {
            for(int j=1; j<=5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.print(T.solution(num, arr));
    }
}