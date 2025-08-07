import java.util.*;

/*
    문장 1개 주어졌을 때, 가장 긴 단어 출력 (길이 같으면 가장 앞쪽 단어 출력)

    [input]
    It is time to study

    [output]
    study

    ** 주요 문법 **
    1. String[] s = str.split(" ") : str 문자열을 띄어쓰기 단위로 나눠서, 문자 1개씩 s배열에 저장

    2. int pos = str.indexOf(' ') : 띄어쓰기의 index를 pos에 저장
    3. String tmp = str.substring(0, pos) : (0 ~ pos 이전) 범위의 문자열을 tmp에 저장
 */

public class Main{
    public String solution(String str){
        String answer = "";

        ////////////////////////////////////////////////////////////////////
        // split 사용 -> 문자열 단어 단위로 쪼개기

        // 1. 최소 int값으로 초기화
        int max = Integer.MIN_VALUE;

        // 2. 문자열을 띄어쓰기 단위로 나눠서, s 배열에 저장
        String[] s = str.split(" ");

        // 3. 문자 1개 길이 게산 -> 길이 긴거 찾기
        for(String x : s){
            int len = x.length();

            if(len > max){ // 길이 긴거 찾음
              max = len;
              answer = x; // 해당 문자를 answer로 지정
            }
        }

        ////////////////////////////////////////////////////////////////////
        // 다른방법: indexOf(), substring() 사용
        
        int max = Integer.MIN_VALUE;
        int pos;

        // 1. str 문자열에서, 띄어쓰기의 index 위치를 pos에 저장 -> 처음으로 발견된 띄어쓰기 기준
        while((pos = str.indexOf(' ')) != -1){

            // 2. substring : (0 ~ pos 이전) 까지의 범위를 잘라서 tmp에 저장
            String tmp = str.substring(0, pos);

            int len = tmp.length();
            if(len > max){
                max = len;
                answer = tmp;
            }

            // 3. 문장 길이 줄이기
            // ex: 'It is the' -> 'is the' 로 줄여서 탐색
            str = str.substring(pos+1);
        }

        // 4. while문 빠져나가면, 마지막 단어는 tmp에 안들어와서 계산 못함
        // -> 한번 더 계산하도록 설정
        if(str.length() > max) answer = str;

        ////////////////////////////////////////////////////////////////////

        return answer;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine(); // 한 줄 입력받기

        Main T = new Main();
        System.out.print(T.solution(str));
    }
}