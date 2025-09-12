import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public String solution(String str1, String str2) {
        String answer = "NO";

        // 1. Queue1, Queue2에 str1, str2 저장
        // 2. 맨 앞에서부터 하나씩 비교하면서, 데이터가 똑같은지 확인
        //  -> 만약 같으면, queue1에서 해당 데이터 제거
        //  -> 만약 다르면, queue2에서 해당 데이터 뺴내고, 다시 삽입
        //  -> str2의 길이만큼 한바퀴 돌리거나, queue1이 전부 빌때까지 반복

        Queue<Character> queue1 = new LinkedList<>();
        for(char x : str1.toCharArray()) {
            queue1.offer(x);
        }

        Queue<Character> queue2 = new LinkedList<>();
        for(char x : str2.toCharArray()) {

            queue2.offer(x);
        }

        int count = 0;
        while(count != str2.length()) {
            if(queue1.isEmpty()) {
                answer = "YES";
                break;
            }

            if(queue1.peek() == queue2.peek()) { // 맨 앞 데이터 똑같을 떄
                queue1.poll();
                queue2.poll();
            }
            else { // 맨 앞 데이터 다를 떄
                char tmp = queue2.remove();
                queue2.offer(tmp);
            }

            count++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        Main T = new Main();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(T.solution(str1, str2));

        bw.close();
    }
}