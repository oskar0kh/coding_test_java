import java.util.*;

/*
    1. 문자열 입력받고, 문자 1개 입력받기 -> 문자열에서 해당되는 문자의 개수 세기

    [input]
    Computercooler
    c

    [result]
    2
 */

public class Main{

    public int solution(String str, char t){
        int answer = 0;

        /////////////////////////////////////////////////////////////////////////////////////////

        // 1. 문자열, 문자 대문자화
        str = str.toUpperCase();
        t = Character.toUpperCase(t);

        // 2. 문자열에서 1개씩 문자 비교 (charAt 사용)
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == t){
                answer++;
            }
        }

        /////////////////////////////////////////////////////////////////////////////////////////

        return answer;
    }

    public static void main(String args[]){
        Main T = new Main(); // Main 클래스의 객체 만들기 -> solution method 호출 가능
        Scanner sc = new Scanner(System.in);

        /////////////////////////////////////////////////////////////////////////////////////////

        String str = sc.next(); // 1. 문자열 입력받기
        char c = sc.next().charAt(0); // 2. 문자 1개 입력받기 -> 입력하는 문자열의 0번째 index 가져오기

        System.out.print(T.solution(str,c)); // 3. solution 메서드에 값 넘기기

        /////////////////////////////////////////////////////////////////////////////////////////
    }
}