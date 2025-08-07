import java.util.*;

/*
    대소문자 변환 : 문자열 1개 입력 받고, 그 안에서 소문자는 대문자로, 대문자는 소문자로 변환

    [input]
    sTUdy

    [output]
    StuDY
    
    ** 중요 문법 **
    1. for(char x : str.toCharArray()) : 문자열을 ArrayList 형태로 변환
    2. Character.isLowerCase(x) : x가 소문자인지 확인
 */

public class Main{
    public String solution(String str) {
        String answer = "";

        ///////////////////////////////////////////////////////////
        // str.toCharArray() : string을 ArrayList 형태로 변환 -> ArrayList의 문자 1개씩 가져오는 형태

        for(char x : str.toCharArray()){
            if(Character.isLowerCase(x)) {
                answer += Character.toUpperCase(x); // x가 소문자일때, 대문자로 변환
            } else{
                answer += Character.toLowerCase(x); // x가 대문자일때, 소문자로 변환
            }
        }

        ///////////////////////////////////////////////////////////
        // ** ASCII 값으로 계산하는 방법 **
        // 대문자(A) : 65 ~ 90
        // 소문자(a) : 97 ~ 122
        // -> 대소문자는 32차이!

        /*
        for(char x : str.toCharArray()){
            if(x >= 65 && x <= 90) {
                answer += (char)(x + 32); // 숫자로 계산되니, char로 casting!
            } else{
                answer += (char)(x - 32);
            }
        }*/

        return answer;
    }

    public static void main(String args[]){
        Main T = new Main();

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(T.solution(str));
    }
}