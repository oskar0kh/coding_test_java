import java.util.Scanner;

// 가위 = 1, 바위 = 2, 보 = 3

public class Main {
    public String solution(int n, int[] a, int[] b){
        String result = "";

        for(int i=0; i<n; i++){
            if(a[i]==1 && b[i]==3) result += 'A';
            else if(a[i]==1 && b[i]==2) result += 'B';
            else if(a[i]==2 && b[i]==1) result += 'A';
            else if(a[i]==2 && b[i]==3) result += 'B';
            else if(a[i]==3 && b[i]==1) result += 'B';
            else if(a[i]==3 && b[i]==2) result += 'A';
            else result += 'D';
        }

        return result;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Main T = new Main();

        int num = sc.nextInt(); // 게임 횟수
        int[] A = new int[num];
        int[] B = new int[num];

        for(int i=0; i<num; i++){
            A[i] = sc.nextInt();
        }

        for(int i=0; i<num; i++){
            B[i] = sc.nextInt();
        }

        for(char x: T.solution(num, A, B).toCharArray()){
            System.out.println(x);
        }
    }
}