import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public ArrayList<Integer> solution(int n, int m, int[] A, int[] B) {
        ArrayList<Integer> answer = new ArrayList<>();

        Arrays.sort(A);
        Arrays.sort(B);

        int p1 = 0;
        int p2 = 0;

        while(p1 < n && p2 < m) {
            if(A[p1] == B[p2]) {
                answer.add(A[p1]);
                p1++;
                p2++;
            }
            else if(A[p1] < B[p2]) {
                p1++;
            }
            else {
                p2++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];
        for(int i=0; i<n; i++) {
            A[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] B = new int[m];
        for(int i=0; i<m; i++) {
            B[i] = sc.nextInt();
        }

        Main T = new Main();
        for(int x: T.solution(n,m,A,B)) {
            System.out.print(x + " ");
        }
    }
}