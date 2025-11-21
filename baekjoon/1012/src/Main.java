import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};

    static int[][] graph;
    static boolean[][] visited;
    ArrayList<Integer> list = new ArrayList<>(); // 결과값 저장하는 list

    public void BFS(int x, int y, int col, int row) {
        Queue<int[]> que = new LinkedList<>();

        que.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!que.isEmpty()) {
            int[] node = que.poll();

            int new_x = node[0];
            int new_y = node[1];

            for(int i=0; i<4; i++) {
                int nx = new_x + dx[i];
                int ny = new_y + dy[i];

                if(nx>=0 && ny>=0 && nx<col && ny<row) {
                    if(graph[nx][ny] == 1 && !visited[nx][ny]) {
                        que.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();

        int n = Integer.parseInt(T.br.readLine()); // 전체 테스트 케이스 수
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(T.br.readLine());

            int col = Integer.parseInt(st.nextToken()); // 배열 가로
            int row = Integer.parseInt(st.nextToken()); // 배열 세로
            int k = Integer.parseInt(st.nextToken());   // 배추 심어진 개수

            graph = new int[col][row];
            visited = new boolean[col][row];

            for(int j=0; j<k; j++) {
                st = new StringTokenizer(T.br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x][y] = 1;
            }

            // BFS 시작 지점 찾기 -> BFS 실행 -> 반환값을 list에 저장
            int count = 0;

            for(int j=0; j<col; j++) {
                for(int m=0; m<row; m++) {
                    if (graph[j][m] == 1 && !visited[j][m]) {
                        T.BFS(j, m, col, row); // BFS 실행 (탐색 시작 지점 건내주기)
                        count++;
                    }
                }
            }
            
            T.list.add(count); // 한 배열에서 전체 BFS를 돈 이후, 결과값을 list에 저장
        }

        for(int x : T.list) {
            T.bw.write(String.valueOf(x) + "\n");
        }

        T.bw.flush();
        T.bw.close();
    }
}