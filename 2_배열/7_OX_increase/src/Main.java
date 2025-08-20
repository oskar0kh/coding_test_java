import java.util.Scanner;

public class Main {
    public int solution(int num, int[] arr){
        int result = 0;

        int[] tmp = new int[num+1]; // 점수 저장용 배열

        for(int i=1; i<=num; i++) {
            if(arr[i] == 1) { // 자기 자신 == 1일때
                if(arr[i-1] == 0) tmp[i] = 1; // 1. 앞 자리 = 0일 때 : 1
                else {                        // 2. 앞 자리 = 1일 때,
                    int j = i;
                    int count = 0;

                    while(arr[j] != 0) {      //    2-1. 0인 숫자 나올때까지, 앞 자리 1개씩 줄이면서 count 늘리기
                        count++;
                        j--;
                    }

                    tmp[i] = count;           //    2-2. count를 저장
                }
            }
        }

        // 3. tmp에 저장된 값 전부 더하기
        for(int i=1; i<=num; i++) {
            result += tmp[i];
        }

        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Main T = new Main();

        int num = sc.nextInt();
        int[] arr = new int[num+1];

        for(int i=1; i<=num; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(num, arr));
    }
}