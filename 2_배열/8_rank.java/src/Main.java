import java.util.Scanner;

public class Main {
    public int[] solution(int num, int[] arr){
        int[] result = new int[num];

        // 상대 등수로 확인
        // 1. 자기 자신을 다른 요소들과 하나씩 비교 (자기 자신과 만나면 그냥 패스)
        //    1) 자기보다 큼 : rank++
        //    2) 자기보다 작음 : rank 그대로 (아무것도 안함)
        //    3) 자기랑 같음 : rank 그대로 (아무것도 안함)
        //
        // 2. rank를 저장

        for(int i=0; i<num; i++) {

            int tmp = arr[i];

            int rank = 1;

            for(int j=0; j<num; j++) {
                if(j == i) continue;   // 1) 자기 자신은 건너뜀
                else {
                    if(tmp < arr[j]) { // 2) 자기보다 큼 : rank 증가
                        rank++;
                    }
                }
            }

            result[i] = rank; // 3) rank 저장
        }

        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Main T = new Main();

        int num = sc.nextInt();
        int[] arr = new int[num+1];

        for(int i=0; i<num; i++){
            arr[i] = sc.nextInt();
        }

       for(int x : T.solution(num, arr)) {
           System.out.print(x + " ");
       }
    }
}