import java.io.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static boolean[] visited;

    public void DFS(int node, int n) throws IOException {
        if(node == n+1) { // 현재 재귀 단계가 n보다 큼 : 종료 조건 -> 'visited값 = true' 인 인덱스 번호들 모아서 출력
            StringBuilder sb = new StringBuilder();

            for(int i=1; i<=n; i++) {
                if(visited[i]) sb.append(i + " ");
            }

            if(!sb.isEmpty()) { // 공집합 제외하고 출력
                String str = sb.toString();
                bw.write(str + "\n");
            }
        }
        else { // 'node를 부분집합에 넣을지, 안넣을지' 로 2개의 DFS 경우의 수 만들기
               // ex: 1이 들어간 부분집합 {1, 2, 3}, 1이 안들어간 부분집합 {2, 3}
            visited[node] = true; // 현재 node를 부분집합에 넣는 DFS
            DFS(node+1, n);       // -> 현재 node를 visited 처리하고, 다음 단계로 넘어감 (ex: D(1) -> D(2))

            visited[node] = false; // 현재 node를 부분집합에 안넣는 DFS
            DFS(node+1, n);        // -> 바로 다음 단계로 넘어감 (ex: D(2))
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        int n = Integer.parseInt(T.br.readLine());
        visited = new boolean[n+1];

        T.DFS(1, n);

        T.bw.flush();
        T.bw.close();
    }
}