import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public void combination(int count, int start, int sum, int n, int[] arr, TreeSet<Integer> tree) {
        // * count : 반복 횟수
        // 1. 종료 조건 : count == 3일때, sum을 tree에 저장
        if(count == 3) {
            tree.add(sum);
            return;
        }

        // 2. 재귀 : 현재 인덱스(start) 선택 -> 현재 인덱스의 값 + sum -> 다음 인덱스 재귀
        for(int i=start; i<n; i++) {
            combination(count+1, i+1, sum+arr[i], n, arr, tree);
        }
    }

    public int solution(int n, int k, int[] arr) {

        // 1. nC3 계산 (재귀) -> 모든 합을 TreeSet에 저장
        // 2. TreeSet의 3번쨰 인덱스 숫자를 출력

        TreeSet<Integer> tree = new TreeSet<>(Collections.reverseOrder());
        combination(0, 0, 0, n, arr, tree);

        if(tree.size() < k) {
            return -1;
        }

        int count = 0;
        for(int answer : tree) {
            count++;

            if(count == k) return answer;
        }

        return -1;
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

        System.out.print(T.solution(N, K, arr));
    }
}