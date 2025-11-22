import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 여러 지점에서 동시에 BFS 시작 + 전체 탐색한 level 중 최댓값 출력하기
//  1. 처음에 값이 1인 지점을 전부 Queue에 넣고, 다 넣은 다음에 BFS 돌리기
//  2. BFS 도중, 다음 칸이 0이면, '현재 칸의 값 + 1' 만큼 저장 (level 계산)

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};

    static int[][] graph;
    Queue<int[]> que = new LinkedList<>();

    int maxLevel = 0;

    public void BFS(int col, int row) throws Exception {
        while(!que.isEmpty()) {
            int[] node = que.poll();

            int new_x = node[0];
            int new_y = node[1];

            for(int i=0; i<4; i++) {
                int nx = new_x + dx[i];
                int ny = new_y + dy[i];

                if(nx>=0 && ny>=0 && nx<col && ny<row) {
                    if(graph[nx][ny] == 0) {
                        que.offer(new int[]{nx, ny});
                        graph[nx][ny] = graph[new_x][new_y] + 1; // 다음 위치에 '현재 level + 1' 저장
                    }

                    if(graph[nx][ny] > maxLevel) { // 현재 최대 탐색 level보다 더 깊이 탐색하면, 최대 level로 갱신
                        maxLevel = graph[nx][ny];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();

        StringTokenizer st = new StringTokenizer(T.br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 가로 (0,x)
        int n = Integer.parseInt(st.nextToken()); // 세로 (x,0)

        graph = new int[n][m];

        boolean isZeroContain = false;
        for(int i=0; i<n; i++) {
            String[] str = T.br.readLine().split(" "); // 한줄을 공백 단위로 파싱

            for(int j=0; j<m; j++) { // 파싱한 값을 graph 배열에 한개씩 넣기
                int num = Integer.parseInt(str[j]);
                graph[i][j] = num;

                if(num == 0) isZeroContain = true;
            }
        }

        if(!isZeroContain) { // 배열 속 모든 요소에 0이 없음 : 바로 종료
            T.bw.write("0");
        }
        else {
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(graph[i][j] == 1) { // 배열 속에 1인값 찾기 -> Queue에 해당 좌표들 전부 넣기
                        T.que.offer(new int[]{i, j});
                    }
                }
            }

            T.BFS(n, m); // 시작값이 1인 지점 전부 찾고, Queue에 넣은 뒤, BFS 진행

            boolean isZero = false; // BFS 종료 후, 배열 속에 0이 있는지 확인
            
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(graph[i][j] == 0) { // BFS 종료 후, 배열 속에 0이 남았는지 확인
                        isZero = true; // 배열 속에 0이 남았으면, for문 종료
                        break;
                    }
                }
            }

            if(isZero) T.bw.write("-1"); // 배열 속에 0 남아있을 때
            else T.bw.write(String.valueOf(T.maxLevel - 1)); // 배열 속에 0 없을 때 : '최대 level - 1' 출력
        }                                                    // (BFS 시작할 때, 시작점이 1부터 시작하기 때문)

        T.bw.flush();
        T.bw.close();
    }
}