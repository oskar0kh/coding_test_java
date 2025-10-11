import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] sequence = new int[n];

        for(int i=0; i<n; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }

        boolean isSerial = true;
        int remember = 0;
        for(int num : sequence) {
            if(stack.isEmpty()) { // stack이 비어있을 때: 입력한 숫자만큼 push하고, 맨 위에거 하나 pop
                for(int k=remember+1; k<=num; k++) {
                    //bw.write("push: " + stack.push(k) + "\n");
                    stack.push(k);
                    sb.append("+\n");
                    remember = k;
                }
                //bw.write("pop: " + stack.pop() + "\n");
                stack.pop();
                sb.append("-\n");
            }
            else if(stack.peek() == num) { // stack의 맨 윗부분 == 입력한 숫자: 맨 위에거 하나 pop
                //bw.write("pop: " + stack.pop() + "\n");
                stack.pop();
                sb.append("-\n");
            }
            else if(stack.peek() < num) {
                for(int k=remember+1; k<=num; k++) {
                    //bw.write("push: " + stack.push(k) + "\n");
                    stack.push(k);
                    sb.append("+\n");
                    remember = k;
                }
                //bw.write("pop: " + stack.pop() + "\n");
                stack.pop();
                sb.append("-\n");
            }
            else {
                bw.write("NO");
                isSerial = false;
                break;
            }
        }

        if(isSerial) {
            String str = sb.toString();
            bw.write(str);
        }

        bw.flush();
        bw.close();
    }
}