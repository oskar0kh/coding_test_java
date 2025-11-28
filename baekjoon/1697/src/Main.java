import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1차원 최단 거리 구하기

public class Main {

    static int[] dir = {-1, 1}; // 이동 방향 (순간이동 제외)
    static boolean[] visited; // n이 방문한 위치 저장
    static Queue<Integer> que;

    static int BFS(int n, int k) {
        int level = 0; // 최소 탐색 횟수 (깊이)

        que.offer(n);
        visited[n] = true;

        while(!que.isEmpty()) {
            int size = que.size(); // 현재 level에 포함되어 있는 노드들 개수만큼 탐색

            for(int i=0; i<size; i++) {
                int node = que.poll();

                if(node == k) return level; // 현재 node가 찾는 값 -> 바로 종료

                for(int j=0; j<3; j++) {
                    int nx;

                    if(j<2) {
                        nx = node + dir[j]; // -1, 1 방향 탐색
                    }
                    else {
                        nx = 2*node; // 순간이동 탐색
                    }

                    if(nx == k) return level+1; // k 찾음 -> 값 반환

                    if(nx >= 0 && nx <= 100000 && !visited[nx]) { // k 못찾음 -> que에 다음 노드 넣기
                        que.offer(nx);
                        visited[nx] = true;
                    }
                }
            }

            level++; // 다음 level로 이동
        }

        return level;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        visited = new boolean[100001]; // 0~100000 범위의 값 사용 -> 100001 생성
        que = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(BFS(n, k)));

        bw.flush();
        bw.close();
    }
}