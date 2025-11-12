import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 1. 커스텀 클래스 구현
    static class Number {
        int real; // 실제 값
        int abs; // 절댓값

        Number(int real, int abs) {
            this.real = real;
            this.abs = abs;
        }
    }

    // 2. 커스텀 Comparator 구현
    static class NumberComparator implements Comparator<Number> {
        @Override
        public int compare(Number n1, Number n2) {
            if(n1.abs != n2.abs) { // 절댓값 더 작은값 -> 우선순위 높음
                return Integer.compare(n1.abs, n2.abs);
            }
            else { // 절댓값이 같을 때, 실제 값으로 비교
                return Integer.compare(n1.real, n2.real);
            }
        }
    }

    // 3. 커스텀 클래스, Comparator -> Priority Queue 생성
    public static void main(String[] args) throws Exception {
        Main T = new Main();

        // Number 클래스의 Priority Queue 생성 (정렬 방식은 NumberComparator 사용)
        PriorityQueue<Number> pQ = new PriorityQueue<>(new NumberComparator());

        int n = Integer.parseInt(T.br.readLine());
        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(T.br.readLine());

            if(x!=0) {
                pQ.offer(new Number(x, Math.abs(x))); // Priority Queue에 Number 객체 넣기
            }
            else if(x==0 && pQ.isEmpty()) { // Priority Queue가 비어있는데, 값 출력하라고 함 -> 그냥 0 출력
                T.bw.write("0\n");
            }
            else { // 절댓값 가장 작은값 출력 -> 값 들어갈 때, 이미 NumberComparator 사용해서 정렬되어진 상태
                Number answer = pQ.poll();
                T.bw.write(String.valueOf(answer.real) + "\n"); // 그냥 맨 위에거 출력하면 됨 (우선순위 젤 높음)
            }
        }

        T.bw.flush();
        T.bw.close();
    }
}