import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public String solution(String str1, String str2) {
        String answer = "YES";

        HashMap<Character, Integer> map = new HashMap<>();

        // 1. str1의 알파벳 개수 세기
        for(char x : str1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        // 2. str2의 알파벳 개수 세면서, map에 똑같은 Key 있으면 Value 1 감소
        for(char x : str2.toCharArray()) {
            if(map.containsKey(x)) map.put(x, map.get(x) - 1);
        }

        // 3. map의 전체 Value 값이 0이면, answer == YES
        for(char x : map.keySet()) {
            if(map.get(x) != 0) {
                answer = "NO";
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main T = new Main();

        String str1 = sc.next();
        String str2 = sc.next();

        System.out.println(T.solution(str1, str2));
    }
}