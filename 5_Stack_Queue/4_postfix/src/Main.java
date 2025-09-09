import java.io.*;
import java.util.Stack;

public class Main {
    public int solution(String str) {
        int answer = 0;

        // 1. String속 문자들을 1개씩 stack에 push

        // 2. 만약 숫자가 아닌 문자를 만나면 (사칙연산 기호)
        //  : 'pop 2번 -> 연산 진행 -> 연산 끝나고 다시 stack에 push'

        // 3. 마지막에 stack에 남은 값 반환

        Stack<Integer> stack = new Stack<>();

        for(char x : str.toCharArray()) {
            int p1 = 0;
            int p2 = 0;

            if(x=='+') {
                p1 = stack.pop();
                p2 = stack.pop();
                stack.push(p2+p1);
            }
            else if(x=='-') {
                p1 = stack.pop();
                p2 = stack.pop();
                stack.push(p2-p1);
            }
            else if(x=='*') {
                p1 = stack.pop();
                p2 = stack.pop();
                stack.push(p2*p1);
            }
            else if(x=='/') {
                p1 = stack.pop();
                p2 = stack.pop();
                stack.push(p2/p1);
            }
            else {
                stack.push(Character.getNumericValue(x));
            }
        }

        answer = stack.pop();

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(T.solution(str)));

        bw.close();
    }
}