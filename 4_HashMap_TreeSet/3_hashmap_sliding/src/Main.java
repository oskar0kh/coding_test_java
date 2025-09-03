import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public ArrayList<Integer> solution(int n, int k, int[] arr) {

        /////////////////////////////////////////////////////////////////////////////

        // 1. HashMap 1개 생성
        // 2. 0 ~ K까지 map에 저장 (key : 숫자, Value : 카운트 횟수)

        // 3. ** key의 개수 == 서로 다른 종류 개수 ** -> answer에 저장

        // 4. 왼쪽 제거: 맨 왼쪽(start)의 Value값 1만큼 감소
        //  -> 만약 Value == 0이면, map.remove(해당키 제거)
        
        // 5. 오른쪽 추가: 맨 오른쪽(k)의 Key, Value map에 저장

        // 6. map.size를 answer에 추가 (이걸 k<n 될때까지 반복)

        /////////////////////////////////////////////////////////////////////////////

        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // 1. 초기 세팅 : 0 ~ K까지 map에 저장, 'map 크기 (key 개수) == 서로 다른 종류 개수'
        for(int i=0; i<k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        answer.add(map.size());

        int start = 0;
        while(k < n) {
            
            // 2. 왼쪽 제거 : 맨 왼쪽의 value값 1 감소, 만약 value==0 되면 map에서 Key 제거
            map.put(arr[start], map.get(arr[start]) - 1);
            if(map.get(arr[start]) == 0) map.remove(arr[start]);

            // 3. 오른쪽 추가
            map.put(arr[k], map.getOrDefault(arr[k], 0) + 1);

            // 4. 이번 회차의 key 종류대로 answer에 저장
            answer.add(map.size());
            
            k++;
            start++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main T = new Main();

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int x : T.solution(n, k, arr)) {
            System.out.print(x + " ");
        }
    }
}