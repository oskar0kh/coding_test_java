import java.io.*;
import java.util.*;

// HashMap으로 중복 판별, TreeSet으로 사전순으로 정렬해서 String 출력

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<n+m; i++) {
            String x = br.readLine();
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        TreeSet<String> tree = new TreeSet<>();
        int count = 0;

        for(String x : map.keySet()) {
            if(map.get(x) > 1) {
                count++;
                tree.add(x);
            }
        }

        bw.write(String.valueOf(count + "\n"));
        for(String x : tree) {
            bw.write(x + "\n");
        }

        bw.flush();
        bw.close();
    }
}