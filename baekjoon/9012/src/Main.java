import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public String solution(int n, String str) {
        // stack에 String 속 괄호들 하나씩 집어넣기
        // 만약 ')' 괄호 들어올 때 '(' 괄호가 stack의 맨 위에 있으면, pop
        // 마지막에 stack.empty가 아니면, NO 반환

        Stack<Character> stack = new Stack<>();
        for(char x : str.toCharArray()) {
            if(stack.empty()) stack.push(x);
            else if((x == ')') && (stack.peek() == '(')) stack.pop();
            else stack.push(x);
        }

        if(stack.empty()) return "YES";
        else return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Main T = new Main();
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(T.solution(n, br.readLine()));
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(String x : list) {
            bw.write(String.format(x + "\n"));
        }

        bw.flush();
        bw.close();
    }
}