import java.util.Scanner;
import java.util.Stack;

public class Main {
    public String solution(String str) {
        String answer = " ";

        Stack<Character> stack = new Stack<>();

        // 1. stack에 String속 요소들 1개씩 push
        // 2. ')'가 들어오면, '('가 나올때까지 pop
        // 3. stack에 남은 문자열 == answer

        // 1. 메인 알고리즘
        for(char x : str.toCharArray()) {
            if(x == ')') {
                while(stack.peek() != '(') { // '(' 등장 직전까지, 전부 pop
                    stack.pop();
                }

                stack.pop(); // 마지막에 '('도 pop
            }
            else { // ')' 등장 전까지는 전부 push
                stack.push(x);
            }
        }

        // 2. stack에서 1개씩 pop해서 sb에 저장
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()) {
            sb.append(stack.pop());
        }

        String tmp = sb.toString();

        // 3. tmp를 뒤집기 (LIFO 순서대로 저장되어있음)
        StringBuilder sb2 = new StringBuilder();
        for(int i=tmp.length()-1; i>=0; i--) {
            sb2.append(tmp.charAt(i));
        }

        answer = sb2.toString();

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main T = new Main();

        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}