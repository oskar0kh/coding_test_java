import java.util.Scanner;

public class Main {
    public int solution(int n, int[] arr){
        int result = 1; // 첫 번째 학생은 무조건 보임

        int max = arr[0]; // 1. 첫 번째 학생의 키 저장

        for(int i=1; i<n; i++){
            if((arr[i] > arr[i-1]) && arr[i] > max) { // 2. 만약 앞 사람보다 키 큼 && max값보다 키 큼
                result++;                             //    -> result 증가 && 새로운 max로 지정
                max = arr[i];
            }
        }

        return result; // 3. result값 반환
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Main T = new Main();

        int num = sc.nextInt();
        int[] arr = new int[num];

        for(int i=0; i<num; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(num, arr));
    }
}