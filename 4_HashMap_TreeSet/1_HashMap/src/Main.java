import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public char solution(int n, String str) {
        char answer = ' ';

        HashMap<Character, Integer> map = new HashMap<>();

        // 1. String의 A,B,C,D,E 개수 카운팅
        for(char x : str.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0)+1); // A, B, C, D, E 만날때 마다, Value를 1씩 증가시켜서 카운팅
        }

        int max  = Integer.MIN_VALUE;

        // 2. Value값 제일 큰 Key 찾기
        for(char key : map.keySet()) {
            if(map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main T = new Main();

        int n = sc.nextInt();
        String s = sc.next();

        System.out.println(T.solution(n, s));
    }
}