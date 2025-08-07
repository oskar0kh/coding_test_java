import java.util.Scanner;

public class Main{
    public int solution(String str){
        int answer = 0;

        ////////////////////////////////////////////////////

        for(char x : str.toCharArray()){
            if(x>=48 && x<=57) answer = answer * 10 + (x-48);
        }

        ///////////////////////////////////////////////////

        return answer;
    }

    public static void main(String args[]){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}