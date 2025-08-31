import java.util.Scanner;

public class Main {
    public int solution(int n) {
        int answer = 0;

        int p1 = 1; // window의 처음
        int p2 = 1; // window의 끝
        int sum = 0;

        for(int i=1; i<=n/2 + 1; i++) {
            sum += i;
            p2++;

            if(sum == n) answer++;

            while(sum >= n) {
                sum -= p1;
                p1++;

                if(sum == n) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Main T = new Main();
        System.out.println(T.solution(n));
    }
}