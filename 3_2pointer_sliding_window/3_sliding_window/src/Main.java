import java.util.Scanner;

public class Main {
    public int solution(int n, int k, int[] arr) {

        // 1. 시작 : i=0~K-1 까지 합 먼저 구하기
        int sum = 0;
        for(int i=0; i<k; i++) {
            sum += arr[i];
        }

        int answer = sum; // 2. 처음 sum값을 answer에 저장

        // 3. i=K ~ N 까지, 다음 순서의 숫자 더하고, 맨 처음 숫자 빼기
        for(int i=k; i<n; i++) {
            sum = sum + arr[i] - arr[i-k];

            if(sum > answer) { // 만약 sum이 최댓값이면, answer랑 바꾸기
                answer = sum;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main T = new Main();

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(N, K, arr));
    }
}