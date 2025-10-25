import java.io.*;
import java.util.*;

// DFS : 1번 노드랑 연결된 노드들 개수 세기

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public int DFS(int start) { // 노드 총 개수 받기
        Stack<Integer> stack = new Stack<>();
        
        stack.push(start); // 시작 지점 넣기

        int count = 0;
        while(!stack.isEmpty()) {
            int node = stack.pop(); // 탐색 시작
            if(visited[node]) continue;
            visited[node] = true;
            
            count++; // 방문 시작한 현재 노드 -> count++

            ArrayList<Integer> neighbors = graph.get(node);
            for(int i=neighbors.size()-1; i>=0; i--) { // 노드 안에 들어있는 ArrayList의 0번 인덱스까지 탐색해야함
                int next = neighbors.get(i);

                if(!visited[next]) {
                    stack.push(next); // 다음에 탐색할 노드들을 stack에 저장해놓기
                    // visited[next] = true; // stack 뒤집을때는 여기에서 visited 판별하면 안됨
                                             // pop 할때 = 탐색 시작할 때 -> 이때 visited=true 처리 해야함!
                }
            }
        }

        if(count > 0) return count-1;
        else return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 노드 개수
        int m = Integer.parseInt(br.readLine()); // 노드 쌍 개수

        visited = new boolean[n+1]; // visited 배열 초기화
        for(int i=0; i<=n; i++) {  // graph의 각 노드에 ArrayList 추가 (1번 노드부터 사용)
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph.get(node1).add(node2); // 양방향 노드 연결
            graph.get(node2).add(node1);
        }

        Main T = new Main();
        bw.write(String.valueOf(T.DFS(1)));

        bw.flush();
        bw.close();
    }
}