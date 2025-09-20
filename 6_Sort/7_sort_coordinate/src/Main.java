import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public int[][] solution(int n, int[][] arr) {

        // 1. Comparator<int[]> : 왜 2차원 배열인데 int[]로 사용하는가?
        //  -> 2차원 배열을 int[]로 가져오면, x랑 y값을 하나로 묶어서 사용할 수 있음!
        //     (ex: arr[1] = {3, 7})

        // 2. a[0] - b[0] : 왜 배열 2개를 뺴는 걸까?
        //  -> Java의 정렬함수인 Comparator가 정렬하는 방식
        //      1) 'compare'라는 새로운 함수 만들고, Comparator 함수를 오버라이드
        //          - Comparator의 return값 (a-b) == 음수 : a가 더 작은값 (ex: 2 - 5) -> 정렬 X
        //          - Comparator의 return값 (a-b) == 0 : 똑같은 값 -> 정렬 X
        //          - Comparator의 return값 (a-b) == 양수 : a가 더 큰 값 (ex: 5 - 2) -> 정렬 O

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0] != b[0]) return a[0] - b[0]; // x값이 다를때, x값 기준으로 정렬 (이때, x랑 y는 1개 배열로 묶여서 같이 정렬됨)
                else return a[1] - b[1]; // x가 같고 y가 다를때, y값 기준으로 정렬
            }
        });

        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main T = new Main();

        int[][] answer = T.solution(n, arr);
        for(int i=0; i<n; i++) {
            bw.write(String.format("%d %d\n", arr[i][0], arr[i][1]));
        }

        bw.flush();
        bw.close();
    }
}