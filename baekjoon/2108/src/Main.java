import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(br.readLine());
            arr[i] = x;
            map.put(x, map.getOrDefault(x,0) + 1); // 입력값 카운팅
        }

        double sum = 0; // 1. 산술평균
        for(int i=0; i<n; i++) {
            sum += arr[i];
        }
        sum /= n;
        bw.write(String.valueOf(Math.round(sum)) + "\n");

        int mid = 0; // 2. 중앙값
        Arrays.sort(arr);

        if(n == 1) mid = arr[0];
        else mid = arr[n/2];
        bw.write(String.valueOf(mid) + "\n");

        int frequent = 0; // 3. 최빈값 -> HashMap (최빈값의 key 저장)

        List<Integer> list = new ArrayList<>(map.keySet()); // HashMap의 key들 가져와서 ArrayList 생성
        Collections.sort(list); // key값 중심으로 정렬

        int max = Integer.MIN_VALUE; // 최빈값 찾기
        int count = 0; // 두번째 최빈값 찾기 위함 (빈도수 같은 값 찾으면, count++)
        for(int key : list) { // 정렬된 key값의 빈도수 확인
            int x = map.get(key);
            //bw.write("현재 key: " + key + ", 현재 빈도 수: " + x + "\n");
            //bw.write("현재 min: " + max + "\n");

            if(max == x && count == 0) { // '현재 빈도수 == 다음 빈도수' && '처음으로 만나는 동일 빈도수' 일때
                count++;
                frequent = key; // 두 번째로 등장한 최빈값으로 갱신
            }

            if(max < x) {
                max = x;
                frequent = key;
                count = 0; // 새로운 최대 빈도수를 찾으면, count를 0으로 초기화
            }
        }
        bw.write(String.valueOf(frequent) + "\n");

        int range = arr[n-1] - arr[0]; // 4. 범위
        bw.write(String.valueOf(range) + "\n");

        bw.flush();
        bw.close();
    }
}