import java.io.*;
import java.util.*;

// HashMap 사용 -> 중복 숫자 개수 세기

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(st.nextToken());
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            int key = Integer.parseInt(st.nextToken());
            if(map.containsKey(key)) bw.write(String.valueOf(map.get(key)) + " ");
            else bw.write("0 ");
        }

        bw.flush();
        bw.close();
    }
}