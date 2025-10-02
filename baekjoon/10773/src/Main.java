import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<String> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            String num = br.readLine();

            if(Integer.parseInt(num) == 0) {
                stack.pop();
            }
            else {
                stack.push(num);
            }
        }

        int sum = 0;
        if(stack.isEmpty()) bw.write("0");
        else {
            int count = stack.size();
            while(count != 0) {
                sum += Integer.parseInt(stack.pop());
                count--;
                //bw.write("sum: " + String.valueOf(sum) + "\n");
            }

            bw.write(String.valueOf(sum));
        }

        bw.flush();
        bw.close();
    }
}