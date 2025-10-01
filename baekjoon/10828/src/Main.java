import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<String> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if(cmd.equals("push")) {
                stack.push(st.nextToken());
            }
            else if(cmd.equals("pop")) {
                if(stack.isEmpty()) bw.write("-1\n");
                else bw.write(stack.pop() + "\n");
            }
            else if(cmd.equals("size")) {
                bw.write(String.valueOf(stack.size()) + "\n");
            }
            else if(cmd.equals("empty")) {
                if(stack.isEmpty()) bw.write("1\n");
                else bw.write("0\n");
            }
            else if(cmd.equals("top")) {
                if(stack.isEmpty()) bw.write("-1\n");
                else bw.write(stack.peek() + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}