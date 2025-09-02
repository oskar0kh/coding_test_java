import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public String solution(String str1, String str2) {
        String answer = " ";

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        // 1. str1, str2의 알파벳 개수 세기
        for(char x : str1.toCharArray()) {
            map1.put(x, map1.getOrDefault(x, 0) + 1);
        }

        for(char x : str2.toCharArray()) {
            map2.put(x, map2.getOrDefault(x, 0) + 1);
        }

        // 2. str1, str2의 key값에 따른 Value값이 똑같은지 비교
        //    1) map1의 크기 확인
        //    2) 먼저, map1의 Key를 map2도 가지고 있는지 확인
        //    3) 그 다음, 'map1 Key의 Value값 == map2 Key의 Value값' 일때, count++
        //    4) for문 종료 후, count == size 확인

        int size = map1.size();
        int count = 0;

        for(char x : map1.keySet()) {
            if(map2.containsKey(x)) { // str2에 해당 Key값이 있을때
                if(map1.get(x) == map2.get(x)) count++;
            }
            else {                    // str2에 해당 Key값이 없을때
                answer = "NO";
            }
        }

        if(count == size) answer = "YES";
        else answer = "NO";

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