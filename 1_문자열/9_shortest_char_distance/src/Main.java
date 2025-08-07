import java.util.Scanner;

public class Main {
    public int[] solution(String str, char c){
        int[] answer = new int[str.length()];

        // 1. p 생성, string을 charArray로 변환
        int p = 1000;
        char[] arr = str.toCharArray();

        // 2. [한 바퀴]
        // charArray랑 char를 1개씩 비교하기
        for(int i=0; i<str.length(); i++){
            if(arr[i] == c){
                p = 0;
                answer[i] = p;
            }
            else{
                ++p;
                answer[i] = p;
            }
        }

        // 3. [두 바퀴]
        // 반대 방향으로 char를 1개씩 비교하기 -> 더 작으면 값 갱신하기
        for(int i=str.length()-1; i>=0; i--){
            if(arr[i] == c){
                p = 0;
                answer[i] = p;
            }
            else if(answer[i] > ++p){    // 기존 거리가 더 큼 -> 새로운 값으로 갱신
                answer[i] = p;
            }
            else{                        // 기존 거리가 더 작음 -> 갱신 X
                ++p;
            }
        }

        return answer;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Main T = new Main();

        String str = sc.next();          // 띄어쓰기 전 (문자열) 저장
        char c = sc.next().charAt(0);    // 띄어쓰기 후 (문자 1개) 저장

        for(int x : T.solution(str, c)){ // 반환되는 int 배열을 하나씩 출력
            System.out.print(x + " ");
        }
    }
}