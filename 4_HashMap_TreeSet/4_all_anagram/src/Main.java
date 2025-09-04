import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public int solution(String str1, String str2) {
        int answer = 0;

        // 1. str2를 map2에 저장
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char x : str2.toCharArray()) {
            map2.put(x, map2.getOrDefault(x, 0) + 1);
        }

        // 2. str1, str2의 길이 구하기
        int str1_len = str1.length();
        int str2_len = str2.length();

        // 3. 초기 : str1을 str2_len까지 map1에 저장
        //          & 2개 map이 완전히 같은지 비교
        HashMap<Character, Integer> map1 = new HashMap<>();
        char[] arr = str1.toCharArray();

        for(int i=0; i<str2_len; i++) {
            map1.put(arr[i], map1.getOrDefault(arr[i], 0) + 1);
        }

        if(map1.equals(map2)) answer++;

        // 4. 'i = 1 ~ str1_len-str2_len' 까지,
        //  1) map1 왼쪽 제거 (i=0) : 이때, Value==0이 되면 해당 Key값을 map1에서 제거
        //  2) map1 오른쪽 추가 (i=str1_len - str2_len)
        //  3) map1, map2 완전히 똑같은지 비교
        //     -> 똑같으면 count++
        
        for(int i=0; i<str1_len - str2_len; i++) {
            map1.put(arr[i], map1.get(arr[i]) - 1);
            if(map1.get(arr[i]) == 0) map1.remove(arr[i]); // Value가 0이 되면, map1에서 제거

            map1.put(arr[i+str2_len], map1.getOrDefault(arr[i+str2_len], 0) + 1);

            if(map1.equals(map2)) answer++;
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