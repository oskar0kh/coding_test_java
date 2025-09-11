import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, int m) {
        int answer = 0;

        // 1. Queue 생성 -> n까지 하나씩 queue에 숫자 넣기

        // 2. while(queue의 size == 1)
        //  1) Queue에서 하나씩 poll한 뒤, 다시 삽입, ++count
        //  2) n번째 count -> 현재값 remove, count = 0으로 초기화
        //  3) '1)' 반복

        Queue<Integer> que = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            que.offer(i);
        }

        int count = 0;
        while(que.size() != 1) {
            count++;

            if(count == m) { // 매 m번째 돌아올 때마다 제거
                que.remove();
                count = 0;
            }
            else { // m번째 아닐 때 : 맨 앞에서 데이터 빼내고, 다시 queue에 집어넣기
                int tmp = que.remove();
                que.offer(tmp);
            }
        }

        answer = que.remove();

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Main T = new Main();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(T.solution(N, M)));

        bw.close();
    }
}