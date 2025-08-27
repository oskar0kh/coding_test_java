import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public ArrayList<Integer> solution(int n, int m, int[] A, int[] B) {
        ArrayList<Integer> result = new ArrayList<>();

        int p1 = 0; // 배열 A의 첫부분 가리키는 포인터
        int p2 = 0; // 배열 B의 첫부분 가리키는 포인터

        while(p1 < n && p2 < m) { // 2개 포인터 중 하나라도 배열의 끝에 도달하면 종료
            if(A[p1] <= B[p2]) { // 1. A 배열 값 <= B 배열 값 -> result에 추가, p1 오른쪽 한칸 이동
                result.add(A[p1]);
                p1++;
            }
            else {               // 2. A 배열 값 > B 배열 값 -> result에 추가, p2 오른쪽 한칸 이동
                result.add(B[p2]);
                p2++;
            }
        }

        while(p1 < n) { // p1이 아직 배열 끝에 도달 안했을 때 -> A 배열의 남은 요소들 다 넣기
            result.add(A[p1]);
            p1++;
        }

        while(p2 < m) { // p2가 아직 배열 끝에 도달 안했을 때 -> B 배열의 남은 요소들 다 넣기
            result.add(B[p2]);
            p2++;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main T = new Main();

        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for(int i=0; i<n; i++){
            arr1[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for(int i=0; i<m; i++){
            arr2[i] = sc.nextInt();
        }

        for(int x: T.solution(n,m,arr1,arr2)) {
            System.out.print(x + " ");
        }
    }
}