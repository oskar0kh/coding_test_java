import java.util.Scanner;

public class Main{

    public String solution(String str){
        String answer = "";

        str += " ";

        // 2. (현재 문자, 다음 문자) 비교 -> 같으면 count 증가, 다르면 알파벳이랑 count를 answer에 넣기
        int count = 1;

        for(int i=0; i<str.length()-1; i++){
            if(str.charAt(i) == str.charAt(i+1)){                           // 1. (현재 문자 == 다음 문자) 일때 : count 증가
                count++;
            }
            else if((str.charAt(i) != str.charAt(i+1)) && (count != 1)){    // 2. (현재 문자 != 다음 문자) & (같은 문자 한번이라도 만났을때)
                answer += String.valueOf(str.charAt(i));                        // 2-1. 현재 알파벳 넣기
                answer += String.valueOf(count);                                // 2-2. 현재 count값 넣기
                count = 1;                                                      // 2-3. count = 1로 초기화
            }                                                                   // ex) K K H -> K2
            else{                                                           // 3. 그 외 경우
                answer += String.valueOf(str.charAt(i));
            }
        }

        return answer;
    }

    public static void main(String args[]){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(T.solution(str));
    }

}