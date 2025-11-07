import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int answer = 0;
    static int[][] graph;
    static boolean[][] visited;

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    ArrayList<Integer> list = new ArrayList<>();

    public int BFS(int x, int y, int n) {
        Queue<int[]> que = new LinkedList<>();
        
        int count = 1; // 한번 BFS 돌때, que에 넣은 노드 개수 세기
                       // (시작 지점을 찾아서 BFS를 시작하는 것이므로, 1에서 시작)

        que.offer(new int[]{x, y}); // Queue에 시작 지점 저장
        visited[x][y] = true;

        while(!que.isEmpty()) {
            int[] node = que.poll();

            int new_x = node[0];
            int new_y = node[1];

            for(int i=0; i<4; i++) {
                int nx = new_x + dx[i];
                int ny = new_y + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<n) {
                    if(graph[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        que.offer(new int[]{nx, ny});
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        int n = Integer.parseInt(T.br.readLine());
        graph = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++) {
            String[] str = T.br.readLine().split("");

            for(int j=0; j<n; j++) {
                graph[i][j] = Integer.parseInt(str[j]);
            }
        }

        // 배열에서 BFS 시작 지점 찾기 (값==1 && 방문 안한 노드)
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(graph[i][j] == 1 && !visited[i][j]) {
                    T.answer++; // BFS 시작 구역 추가
                    int count = T.BFS(i, j, n); // BFS 시작 (시작 지점 전달)
                    T.list.add(count);
                }
            }
        }
        
        Collections.sort(T.list); // ArrayList 오름차순 정렬

        T.bw.write(T.answer + "\n");
        for(int x : T.list) {
            T.bw.write(x + "\n");
        }

        T.bw.flush();
        T.bw.close();
    }
}