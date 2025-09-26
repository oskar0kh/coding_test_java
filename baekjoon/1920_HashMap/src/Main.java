import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) { // HashMap에 하나씩 넣기
            int x = Integer.parseInt(st.nextToken());
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            int x = Integer.parseInt(st.nextToken());

            if(map.containsKey(x)) bw.write(String.valueOf(1)); // HashMap에 존재하는지 확인
            else bw.write(String.valueOf(0));

            bw.write("\n");
        }

        bw.close();
    }
}