import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stack = new Stack<>();

        while(true) {
            String str = br.readLine();

            if(str.equals(".")) break;

            for(char x : str.toCharArray()) {
                if(x == '(' || x == ')' || x == '[' || x == ']' || x == '.') {
                    if(x == '.') break;

                    if(stack.isEmpty()) {
                        stack.push(x);
                        //bw.write("stack top: " + stack.peek() + "\n");
                    }
                    else if(stack.peek() == '(' && x == ')') {
                        //bw.write("stack top: " + stack.peek() + "\n");
                        stack.pop();
                    }
                    else if(stack.peek() == '[' && x == ']') {
                        //bw.write("stack top: " + stack.peek() + "\n");
                        stack.pop();
                    }
                    else {
                        stack.push(x);
                        //bw.write("stack top: " + stack.peek() + "\n");
                    }
                }
            }

            if(stack.isEmpty()) bw.write("yes\n");
            else bw.write("no\n");

            stack.clear();
        }

        bw.flush();
        bw.close();
    }
}