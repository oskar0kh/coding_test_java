import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public int[] solution(int n, int[] arr) {
        int[] answer = new int[2];

        // * 쉬운 방법 (Naive) - O(n^2)
        //  1. 새로운 arr 생성 -> 기존 arr 복사
        //  2. 새로운 arr 정렬
        //  3. 기존 arr랑 비교해서 다른 부분의 index 저장

        int[] arr2 = new int[n];
        for(int i=0; i<n; i++) {
            arr2[i] = arr[i];
        }

        Arrays.sort(arr2);

        int j=0;
        for(int i=0; i<n; i++) {
            if(arr2[i] != arr[i]) {
                answer[j] = i+1;
                j++;
            }
        }

        if(arr2[0] > arr2[1]) {
            int tmp = arr2[1];
            arr2[1] = arr2[0];
            arr2[0] = tmp;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main T = new Main();
        for(int x : T.solution(n, arr)) {
            bw.write(String.format(x+ " "));
        }

        bw.close();
    }
}