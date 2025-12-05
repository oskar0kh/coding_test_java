import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int count = 0; // 연결된 그래프가 몇개인지 세기
    
    public static void DFS(int start) {
        Stack<Integer> stack = new Stack<>();

        stack.push(start); // stack에 1번 노드 넣기
        
        while(!stack.isEmpty()) {
            int node = stack.pop(); // 노드 1개 빼내기
            visited[node] = true;

            ArrayList<Integer> neighbors = graph.get(node); // 노드랑 연결된 다른 노드들 다 탐색
            for(int i=neighbors.size()-1; i>=0; i--) { // 1개 노드 안에 들어있는 ArrayList에는, 0번부터 연결된 노드들이 저장되어 있음
                int next = neighbors.get(i);

                if(!visited[next]) {
                    stack.push(next);
                }
            }
        }

        count++; // 1개 노드랑 연결된 모든 노드 탐색 끝나면, count 증가
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // vertex 개수
        int m = Integer.parseInt(st.nextToken()); // edge 개수

        visited = new boolean[n+1]; // 1~n번째 노드
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>()); // 0~n번째 노드까지 ArrayList는 전부 만들지만, 사용하는건 1번 노드부터
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph.get(node1).add(node2); // 방향 없는 그래프 -> 양쪽 노드에 값 다 넣어야함
            graph.get(node2).add(node1);
        }

        for(int i=1; i<=n; i++) {
            if(!visited[i]) DFS(i);
        }

        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
    }
}