import java.util.Scanner;
import java.util.Stack;

public class Main {
    public int solution(int N, int[][] board, int M, int[] moves) {
        int answer = 0;

        // 1. moves 배열 속 (int값 - 1) == board 배열의 j (세로열)
        //  : 만약 board[i][int값] == 0
        //      -> i++
        //      -> 0이 아닌 값 찾으면, 해당 int값 뺴와서 stack에 push, 그 자리를 0으로 초기화
        //      -> 만약 해당 j열이 전부 0이면, 다음 moves 배열로 넘어감

        // 2. stack에 값 push할 떄, '현재 stack의 맨 위값(peek) == push하는 값'
        //  -> pop 1번, answer++

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<M; i++) { // moves 배열 순회 -> board 배열의 j값
            int crane = moves[i] - 1; // crane 세로열 위치 == (moves값 - 1)번 인덱스
            int tmp = 0;

            for(int j=0; j<N; j++) {
                if(board[j][crane] != 0) { // board 내부 값이 0이 아닐떄, 해당 값 빼오기
                    tmp = board[j][crane];
                    //System.out.printf("board[%d][%d] : %d, tmp: %d\n", j, crane, board[j][crane], tmp);
                    board[j][crane] = 0; // 값 빼온 뒤, 그 위치 0으로 초기화

                    if(stack.empty()) {
                        stack.push(tmp);
                        tmp = 0;
                    }
                    else {
                        if(stack.peek() == tmp) {
                            stack.pop();
                            tmp = 0;
                            answer++;
                        }
                        else {
                            stack.push(tmp);
                            tmp = 0;
                        }
                    }

                    //System.out.printf("stack: %d, answer: %d\n", stack.peek(), answer);
                    break;
                }
            }
        }

        return answer * 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main T = new Main();

        int N = sc.nextInt();
        int[][] board = new int[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int M  = sc.nextInt();
        int[] moves = new int[M];
        for(int i=0; i<M; i++) {
            moves[i] = sc.nextInt();
        }

        System.out.println(T.solution(N, board, M, moves));
    }
}