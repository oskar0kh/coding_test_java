import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public boolean isPrime(int n) { // 소수 판별 함수
        if(n == 1) return false;

        // 1. 2부터 자기 자신 전까지, 전부 나눠보면서 '나머지가 0'인 경우가 한번이라도 나오면, 해당 수는 소수 아님
        //    (나머지 == 0) -> 자기 자신의 약수
        for(int i=2; i<n; i++) {
            if(n % i == 0) return false;
        }

        // 2. 만약 약수 발견 안되면, 해당 수는 소수가 맞음
        return true;
    }

    public ArrayList<Integer> solution(int num, int[] arr){
        ArrayList<Integer> result = new ArrayList<>();

        int[] tmp = new int[num]; // 뒤집은 숫자 저장용 배열

        for(int i=0; i<num; i++){

            // 1. 숫자 뒤집기 /////////////////////////////////////////////////////

            int reverse = 0; // 1-1. 뒤집은 숫자를 저장

            while(arr[i] != 0) {                      // 1-4. 기존 숫자가 0이 되기 전까지, 10으로 계속 나누기
                reverse = reverse * 10 + arr[i] % 10; // 1-2. 10으로 나눈 나머지 (1의 자리수)를 reverse에 저장
                arr[i] /= 10;                         // 1-3. 기존 숫자는 10으로 나눈 몫으로 저장
            }

            tmp[i] = reverse; // 1-5. 기존 숫자 배열에, 뒤집은 숫자를 저장

            // 2. 소수 판별 ///////////////////////////////////////////////////////

            if(isPrime(tmp[i])) { // 만약 tmp[i]가 소수 -> result에 추가
                result.add(tmp[i]);
            }
        }

        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Main T = new Main();

        int num = sc.nextInt();
        int[] arr = new int[num];

        for(int i=0; i<num; i++){
            arr[i] = sc.nextInt();
        }

        for(int x : T.solution(num, arr)) {
            System.out.print(x + " ");
        }
    }
}