import java.util.Scanner;

/*

    문제: 소문자 문자열 받으면, 중복된 문자 제거하고 출력하기

    [input]
    ksekkset

    [output]
    kset

    ** 중요 문법 **
    1. str.indexOf(str.charAt(i)) : i번째 index에 있는 문자의, 처음으로 등장한 index 번호를 출력
    2. answer += str.charAt(i) : String에 문자 1개 저장하기

 */

public class Main{
    public String solution(String str){
        String answer = "";

        //////////////////////////////////////////////////////

        for(int i=0; i<str.length(); i++){

            // [현재 index 번호 == 처음으로 발견된 index 번호] : 이 경우만 answer에 포함!
            if(i == str.indexOf(str.charAt(i))) answer += str.charAt(i);
        }

        //////////////////////////////////////////////////////

        return answer;
    }

    public static void main(String args[]){
        Main T = new Main();

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}