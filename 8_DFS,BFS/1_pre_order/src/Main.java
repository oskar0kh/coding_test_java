import java.util.*;

class Node {
    int data;    // Node의 값 저장하는 변수
    Node lt, rt; // Node가 가리키는 왼쪽, 오른쪽 노드 저장

    public Node(int val) { // 노드를 처음 생성할 때
        data = val; // val로 받은 값을 Node의 data로 저장
        lt=rt=null; // Node의 lt, rt는 null로 초기화 (나중에 다른 노드 가리킴)
    }
}

public class Main {
    Node root;

    public void DFS(Node root) { // root 노드에서부터 탐색 시작
        if(root == null) return; // 단말 노드에 도달 (아래 DFS(root.lt), DFS(root.rt) 에서 반환받은 null)
        else {

            // <전위 순회> 구현
            // root 노드 -> 왼쪽 -> 오른쪽 방향으로 가야함
            // (함수 호출 횟수 == 노드의 가지 수) -> 총 2번 함수 호출!

            System.out.print(root.data + " "); // 1. 부모 노드의 data 출력
            DFS(root.lt); // 2. root노드의 왼쪽 노드로 이동 (단말 노드면, 다음 DFS에 root==null 반환)
            DFS(root.rt); // 3. 다음으로 root노드의 오른쪽 노드로 이동 (단말 노드면, 다음 DFS에 root==null 반환)
        }
    }

    public static void main(String[] args) {
        // < tree 구현 >
        Main tree = new Main();

        tree.root = new Node(1); // root노드 (1번 노드) 생성
        tree.root.lt = new Node(2); // root노드의 왼쪽 노드 (2번 노드) 생성 & 지정
        tree.root.rt = new Node(3); // root노드의 오른쪽 노드 (3번 노드) 생성 & 지정

        tree.root.lt.lt = new Node(4); // 2번 노드의 왼쪽 노드 (4번 노드) 생성 & 지정
        tree.root.lt.rt = new Node(5); // 2번 노드의 오른쪽 노드 (5번 노드) 생성 & 지정

        tree.root.rt.lt = new Node(6); // 3번 노드의 왼쪽 노드 (6번 노드) 생성 & 지정
        tree.root.rt.rt = new Node(7); // 3번 노드의 오른쪽 노드 (7번 노드) 생성 & 지정

        // 현재 4,5,6,7번 노드는 단말 노드로, lt랑 rt가 지정되지 않아서 null인 상태

        tree.DFS(tree.root); // root 노드에서부터 탐색 시장
    }
}