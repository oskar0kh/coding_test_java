import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[][] maze;

    int[] dx = {-1,1,0,0}; // 상하좌우 탐색 방향 (x는 좌우)
    int[] dy = {0,0,-1,1}; // 상하좌우 탐색 방향 (y는 상하)

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void BFS(int[] start, int n, int m) {
        Queue<int[]> que = new LinkedList<>(); // 1. int 배열 Queue 생성

        que.offer(start);     // 2. que에 {0,0} 시작위치 집어넣기
        visited[0][0] = true; // '시작 위치 == 방문함' 처리

        while(!que.isEmpty()) { // 3. que에서 맨 위 꺼내기 -> x,y 좌표값 저장 -> 4방향으로 돌면서 통과 가능한지, 방문한 노드인지 확인
            int[] node = que.poll();

            int x = node[0];
            int y = node[1];

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {    // nx와 ny의 좌표 범위 확인 : {0,0} ~ {n-1,m-1} 사이
                    if(maze[nx][ny] == 1 && !visited[nx][ny]) { // 탐색할 위치의 값이 1인지 확인 & 방문한 노드인지 확인
                        visited[nx][ny] = true;
                        maze[nx][ny] = maze[x][y] + 1; // 해당 위치에 현재까지 이동한 거리 저장 (지금 탐색중인 노드의 현재까지의 깊이를 각 칸에 기록시키는 방식임)
                        que.offer(new int[]{nx, ny});  // que에 다음 탐색할 노드로 현재 좌표 저장
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main T = new Main();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m]; // 전역변수 초기화 (앞에 타입명 선언 X)
        maze = new int[n][m];
        
        for(int i=0; i<n; i++) {
            String[] str = br.readLine().split("");

            for(int j=0; j<m; j++) {
                maze[i][j] = Integer.parseInt(str[j]);
            }
        }

        // 탐색 시작 지점 전달
        int[] start = {0, 0};

        T.BFS(start, n, m);
        T.bw.write(String.valueOf(maze[n-1][m-1])); // 배열 인덱스는 n-1,m-1 까지임 -> 도착 좌표에 기록된 '이동 거리' 출력

        T.bw.flush();
        T.bw.close();
    }
}