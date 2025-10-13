import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited; // 방문한 노드 저장하는 배열
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void DFS(int start) throws IOException { // stack DFS (중간에 node들을 역순으로 정렬 해줘야지 재귀 결과랑 같아짐)
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while(!stack.isEmpty()) { // stack이 빌 때까지 반복
            int node = stack.pop();

            if(visited[node]) continue; // 이미 방문한 노드는 stack에 안들어가게 막기
            visited[node] = true; // 이제 현재 노드 탐색 시작!
            bw.write(node + " "); // 1. 현재 노드 출력
            
            ArrayList<Integer> neighbors = graph.get(node); // 2. 현재 노드랑 연결된 모든 노드 저장
            for(int i = neighbors.size()-1; i>=0; i--) {    // 3. 역순으로 노드 탐색 시작 (그래야지 재귀랑 출력순서 같아짐)
                int next = neighbors.get(i);

                if(!visited[next]) {
                    stack.push(next);
                }
            }
        }
    }

    /*
    public void DFS(int node) throws IOException { // 재귀 DFS
        visited[node] = true;
        bw.write(node + " ");

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                DFS(next);
            }
        }
    }
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 총 노드 개수 받기
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];

        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph.get(node1).add(node2); // 1줄 : 한쪽 방향으로만 연결 -> 방향 그래프 설정
            graph.get(node2).add(node1); // 2줄 : 양쪽 노드 연결 -> 무방향 그래프 설정
        }

        for(int i=0; i<=n; i++) { // 방문할 수 있는 정점이 여러개 일때, 정점 번호가 작은거 순서대로 방문하기 -> 오름차순 정렬!
            Collections.sort(graph.get(i));
        }

        Main T = new Main();
        T.DFS(v);

        T.bw.flush();
        T.bw.close();
    }
}