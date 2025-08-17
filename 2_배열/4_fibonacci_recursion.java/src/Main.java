import java.util.Scanner;

public class Main {
    public static int solution(int n) {
        if(n==1) return 1;
        else if(n==2) return 1;
        else return solution(n-2) + solution(n-1);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Main T = new Main();

        int num = sc.nextInt();

        for(int i=1; i<=num; i++){
            System.out.println(T.solution(i)); // 1개씩 일일이 재귀 출력
        }
    }
}