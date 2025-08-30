import java.util.Scanner;

public class Main {
    public int solution(int N, int M, int[] arr) {
        int answer = 0; // count 역할

        int p1 = 0; // window의 처음 가리킴
        int p2 = 0; // window의 끝 가리킴
        int sum = 0;

        // sum에 arr[p2]값 하나씩 더하면서, sum 값으로 비교 (p2가 N에 도달할 때까지)
        //  1) sum == M : answer++
        //  2) sum >= M : sum 값이 M보다 작아질 때까지, p1을 오른쪽으로 이동
        //     -> 만약 도중에 sum == M 이 되면, answer++

        for(p2 = 0; p2 < N; p2++) {
            sum += arr[p2];

            if(sum == M) {
                answer++;
            }

            while(sum >= M) {
                sum -= arr[p1];
                p1++;

                if(sum == M) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main T = new Main();

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(N, M, arr));
    }
}