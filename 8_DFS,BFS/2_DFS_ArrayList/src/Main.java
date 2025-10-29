import java.util.*;

public class Main {
    static boolean[] visited;            // 방문한 노드 저장하는 배열
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public void DFS(int start) {
        Stack<Integer> stack = new Stack<>();

        stack.push(start);
        visited[start] = true;

        while(!stack.isEmpty()) { // stack이 빌 때까지 반복
            int node = stack.pop(); // 현재 탐색하는 노드
            System.out.print(node + " ");

            for(int next : graph.get(node)) {
                if(!visited[next]) { // node랑 연결된 여러 노드들 중, 탐색 안한 노드 찾기
                    stack.push(next);
                    visited[next] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 총 노드 개수 받기
        visited = new boolean[n+1];

        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(2); // 2 먼저 push 되고,
        graph.get(1).add(3); // 그 다음에 3이 push 됨 -> 나중에는 stack에서 3이 먼저 출력됨

        Main T = new Main();
        T.DFS(1);
    }
}