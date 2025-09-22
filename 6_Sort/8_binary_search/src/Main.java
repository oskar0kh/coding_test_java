import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public int BSearch(int m, int left, int right, int[] arr) {
        if(left > right) { // 찾는값 없을 때 : 0 반환
            return 0;
        }

        // 1. mid값 지정
        int mid = (left + right)/2;

        // 2. 재귀
        if(m > arr[mid]) {      // 찾는값 > 중간값 : left -> mid + 1
            return BSearch(m, mid+1, right, arr);
        }
        else if(m < arr[mid]) { // 찾는값 < 중간값 : right -> mid - 1
            return BSearch(m, left, mid-1, arr);
        }
        else { // 찾는값 == 중간값 : 해당 index 반환
            return mid + 1;
        }
    }

    public int solution(int n, int m, int[] arr) {
        // 1. 먼저 배열 정렬
        Arrays.sort(arr);

        // 2. left, right 지정
        int left = 0;
        int right = n-1;

        // 3. 이진 탐색 재귀 : (찾는값, left, right, 배열) 전달
        return BSearch(m, left, right, arr);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); // 찾는 값

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main T = new Main();
        bw.write(String.valueOf(T.solution(n, m, arr)));

        bw.close();
    }
}