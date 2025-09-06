import java.util.Scanner;
import java.util.Stack;

public class Main {
    public String solution(String str) {
        String answer = " ";

        Stack<Character> stackStr = new Stack<>();

        // 1. String에서 1개씩 Stack에 넣음
        // 2. '(' 위에 ')'가 쌓이면, pop 2번 실행
        //      -> peek의 반환값이 '(' 일때, ')'가 들어오는지 확인
        // 3. String의 끝까지 다 돌았을 때, Stack에 남은 괄호가 있으면 "NO" 반환

        for(char x : str.toCharArray()) {
            if(stackStr.empty()) { // stack이 비어있으면, 첫 번째 데이터는 그냥 넣기
                stackStr.push(x);
            }
            else { // stack이 안 비어있을때
                if(stackStr.peek() == '(' && x == ')') {
                    stackStr.pop();
                }
                else {
                    stackStr.push(x);
                }
            }
        }

        if(stackStr.empty()) answer = "YES";
        else answer = "NO";

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main T = new Main();

        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}