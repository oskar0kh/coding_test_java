import java.util.Scanner;

/*

    문제: '앞에서 읽을 때 = 뒤에서 읽을 때'인 문자열 판별 (Palindrome)
    (단, 대소문자 구별 X)

    [input]
    gooG

    [output]
    YES

 */

public class Main {
    public String solution(String str){
        String answer = "NO";

        /* 기본 비교 방식
        //////////////////////////////////////////////////////////////////

        str = str.toUpperCase();

        int left = 0;
        int right = str.length()-1;

        for(int i=0; i<str.length()/2; i++){
            if(str.charAt(left) == str.charAt(right)){
                left++;
                right--;
                answer = "YES";
            }
            else{
                answer = "NO";
                break;
            }
        }

        //////////////////////////////////////////////////////////////////
        */

        // 문자 여러개 + 숫자 + 특수문자 + 공백 있을때
        str = str.toUpperCase().replaceAll("[^A-Z]", "");

        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equals(tmp)) answer = "YES";

        return answer;
    }

    public static void main(String args[]){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}