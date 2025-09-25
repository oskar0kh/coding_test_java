import java.io.*;
import java.util.*;

public class Main {
    public static Deque<Integer> StringToDequeChanger(int n, String str) { // [1,2,3] 같은 String 배열 -> deque로 변환
        Deque<Integer> deque = new ArrayDeque<>();

        // 1. 양 끝 [, ] 삭제
        String deleteStr = str.substring(1, str.length()-1);

        // 2. 배열 비어있으면 바로 deque 반환
        if(deleteStr.isEmpty()) return deque;

        // 3. StringTokenizer에서 "," 기준으로 토큰 나누고, deque에 저장
        StringTokenizer st = new StringTokenizer(deleteStr, ",");
        while(st.hasMoreTokens()) { // token 다 자를때까지
            deque.add(Integer.parseInt(st.nextToken()));
        }

        return deque;
    }

    public String solution(String func, int arr_num, Deque<Integer> deque) {
        if(arr_num != deque.size()) { // 1. 먼저 '배열 길이 == 실제 입력한 배열 길이' 인지 확인
            return "error";
        }

        // 2. 'func'에 적힌 Character 한 글자씩 확인
        boolean isReverse = false; // false : 안 뒤집힌 상태, true : 뒤집힌 상태
        for(char x : func.toCharArray()) {
            if(!isReverse) { // 안 뒤집힌 상태일때
                if(x == 'R') isReverse = true;
                else if(x == 'D' && !deque.isEmpty()) {
                    deque.remove();
                }
                else {
                    return "error";
                }
            }
            else { // 뒤집힌 상태일때
                if(x == 'R') isReverse = false;
                else if(x == 'D' && !deque.isEmpty()) {
                    deque.removeLast();
                }
                else {
                    return "error";
                }
            }
        }

        // StringBuilder 사용 -> 출력 문자열 만들기
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        // isReverse 상태에 따라 요소 추가
        while(!deque.isEmpty()) {
            if(!isReverse) { // 안 뒤집힌 상태일때 : 앞에서부터 빼내기
                sb.append(deque.remove());
            }
            else { // 뒤집힌 상태일때 : 뒤에서부터 빼내기
                sb.append(deque.removeLast());
            }
            
            if(!deque.isEmpty()) { // 맨 마지막 요소 아니라면, "," 추가하기
                sb.append(",");
            }
        }

        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main T = new Main();

        // 1. 전체 testcase 개수 받기
        int testcase = Integer.parseInt(br.readLine());

        // 2. 1개 testcase씩 입력 받기 (3줄 단위)
        for(int i=0; i<testcase; i++) {
            String func = br.readLine(); // 1) RDD 받기
            int arr_num = Integer.parseInt(br.readLine()); // 2) 배열 요소 개수 받기

            Deque<Integer> deque = StringToDequeChanger(arr_num, br.readLine()); // 3) 배열을 String 형태로 받고, Integer list로 변환
            bw.write(String.format(T.solution(func, arr_num, deque) + "\n"));
        }

        bw.close();
    }
}