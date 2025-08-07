import java.util.Scanner;
import java.util.ArrayList;

/*

    문자 여러개 입력했을 때, 입력 순서대로 거꾸로 문자 출력하기

    [input]
    3
    good
    Time
    book

    [output]
    doog
    emiT
    koob

    ** 중요 문법 **
    1. char[] s = x.toCharArray() : string 1개를 char 배열로 바꾸기
    2. answer.add(String.valueOf(s[i]) : char 배열 속 char를, ArrayList에 String 형태로 넣기

    ** char배열에서 ArrayList에 값 추가하기 : 'char배열 -> String에 저장 -> answer에 add' 과정 거치기 **

 */

public class Main{
    // String array를 parameter로 받기 -> String[] str
    public ArrayList<String> solution(int n, String[] str){
        ArrayList<String> answer = new ArrayList<>();

        //////////////////////////////////////////////////////////

        for(String x : str){

            // 1. string을 char 배열로 변환하기
            char[] s = x.toCharArray();

            // 2. s 배열 속 문자를 1개씩 거꾸로 tmp String에 하나씩 넣기
            String tmp = "";

            for(int i=s.length-1; i>=0; i--){
                tmp += s[i];
            }

            // 3. 거꾸로 뒤집은 1개 단어를 answer에 저장
            answer.add(tmp);
        }

        //////////////////////////////////////////////////////////

        return answer;
    }

    public static void main(String args[]){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        String[] str = new String[num];

        for(int i=0; i<num; i++){
            str[i] = sc.next();
        }

        for(String x : T.solution(num, str)){
            System.out.println(x);
        }

    }
}