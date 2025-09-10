import java.io.*;
import java.util.Stack;

public class Main {
    public int solution(String str) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '(') stack.push('(');
            else { // ')' 만났을때
                if(str.charAt(i-1) == '(') { // 1. 레이저 괄호
                    stack.pop();
                    answer += stack.size();
                }
                else {
                    stack.pop();
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main T = new Main();

        String str = br.readLine();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(T.solution(str))); // int형 -> String형 변환

        bw.close();
    }
}