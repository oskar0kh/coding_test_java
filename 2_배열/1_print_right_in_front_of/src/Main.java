import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public ArrayList<Integer> solution(int n, int[] arr){
        ArrayList<Integer> result = new ArrayList<Integer>();

        result.add(arr[0]); // 첫 번째 값은 무조건 출력

        for(int i=1; i<n; i++){
            if(arr[i] > arr[i-1]) result.add(arr[i]);
        }

        return result; // ArrayList로 반환
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Main T = new Main();

        int num = sc.nextInt();

        int[] arr = new int[num];

        for(int i=0; i<num; i++){
            arr[i] = sc.nextInt();
        }

        for(int x: T.solution(num, arr)){ // ArrayList로 하나씩 출력
            System.out.print(x+" ");
        }
    }
}