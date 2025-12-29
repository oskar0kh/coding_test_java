import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> LeftStack = new Stack<>();
        Stack<Character> RightStack = new Stack<>();

        String str = br.readLine();
        for(int i=0; i<str.length(); i++) {
            LeftStack.push(str.charAt(i)); // 문자열에서 1개씩 LeftStack에 넣기
        }

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch(cmd) {
                case "P":
                    String input = st.nextToken();
                    LeftStack.push(input.charAt(0)); // input의 문자 1개를 LeftStack에 넣기
                    break;

                case "L": // 커서 왼쪽으로 옮기기 -> LeftStack의 맨 위 문자를 RightStack으로 옮기기
                    if(!LeftStack.isEmpty()) {
                        RightStack.push(LeftStack.pop());
                    }
                    break;

                case "D": // 커서 오른쪽으로 옮기기 -> RightStack의 맨 위 문자를 LeftStack으로 옮기기
                    if(!RightStack.isEmpty()) {
                        LeftStack.push(RightStack.pop());
                    }
                    break;

                case "B": // 커서 왼쪽 문자 삭제 -> LeftStack의 맨 위 문자 삭제
                    if(!LeftStack.isEmpty()) {
                        LeftStack.pop();
                    }
                    break;
            }
        }
        
        // LeftStack을 RightStack으로 모으고, StringBuilder로 String 변환
        while(!LeftStack.isEmpty()) {
            RightStack.push(LeftStack.pop());
        }

        StringBuilder sb = new StringBuilder();
        while(!RightStack.isEmpty()) {
            sb.append(RightStack.pop());
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}