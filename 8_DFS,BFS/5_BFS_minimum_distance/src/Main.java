import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int answer = 0; // 탐색 횟수
    int[] dir = {1, -1, 5}; // 현재 노드에서 이동할 수 있는 방향 및 거리값
    boolean[] check; // 방문한 노드인지 확인
    Queue<Integer> que = new LinkedList<>();

    public int BFS(int start, int des) {
        check = new boolean[10001]; // 입력값이 1~10000 사이 -> 10001까지 초기화
        check[start] = true; // 시작 지점 - 방문 처리

        que.offer(start); // 1. que에 시작 지점 넣기
        int level = 0;    //    현재 level = 0

        while(!que.isEmpty()) { // 2. queue가 빌 때까지
            int len = que.size(); // 1) 현재 level에 몇개의 노드가 들어있는지 계산 (ex: level 0 - 1개 (시작노드))

            for(int i=0; i<len; i++) {     // 2) 현재 level에 들어있는 모든 노드들 탐색
                int x = que.poll(); // 노드 1개 꺼내기

                for(int j : dir) {         // 3) dir 배열에서 값 1개씩 꺼내서, x에다가 더하고 check 배열에 저장
                    int nx = x + j;

                    if(nx == des) return level+1; // 4) 만약 자식 노드 == 목표값 : '현재 level' + 1 반환!

                    if(nx >= 1 && nx <= 10000 && !check[nx]) { // nx가 1~10000 범위 안벗어나기 & 방문 안한 값이면,
                        check[nx] = true;
                        que.offer(nx); // 해당 노드를 queue에 넣음 -> 다음 level때 탐색
                    }
                }
            }

            level++; // 현재 level에서 목표값 못찾음 -> 다음 level로 이동
        }

        return level;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        StringTokenizer st = new StringTokenizer(T.br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int des = Integer.parseInt(st.nextToken());

        T.bw.write(String.valueOf(T.BFS(start, des)));

        T.bw.flush();
        T.bw.close();
    }
}