import java.util.Scanner;

/*
    문제: 문자열에서 영어 알파벳들만 위치 바꾸고, 특수문자는 냅두기

    [input]
    a#b!GE*T@S

    [output]
    S#T!EG*b@a

    ** 중요 문법 **
    String을 char array로 바꾸고, lt - rt 사용 -> [ lt==알파벳 & rt==알파벳 ] 일때만 교환

    1. 특수문자 일때는 그냥 넘어감
    2. lt, rt 둘 중 하나가 알파벳일 경우, 해당 변수는 그대로 두고, 나머지 하나만 이동
 */

public class Main{
    public String solution(String str){
        String answer = "";

        //////////////////////////////////////////////////////////////////

        // 1. String -> char array 변환
        char[] arr = str.toCharArray();

        // 2. left, right 인덱스 설정
        int left = 0;
        int right = str.length()-1;

        // 3. char array 돌면서 알파벳 위치 바꾸기
        while(left < right){
            if(!Character.isAlphabetic(arr[left])) left++;        // left == 특수문자 일때 : 그냥 다음으로 넘어가기
            else if(!Character.isAlphabetic(arr[right])) right--; // right == 특수문자 일때 : 그냥 왼쪽으로 넘어가기
            else{                                                 // 둘다 알파벳 가리킬 때 -> Swap!
                char tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;

                left++;
                right--;
            }
        }

        // 4. char array -> String 변환
        answer = String.valueOf(arr);

        //////////////////////////////////////////////////////////////////

        return answer;
    }

    public static void main(String args[]){
        Main T = new Main();

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.print(T.solution(str));
    }
}