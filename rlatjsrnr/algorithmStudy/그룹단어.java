import java.util.Scanner;

public class GroupWord {
    public static void main(String[] args) {

        int answer = 0;
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for(int i =0; i < n; i++){
            boolean result = true;
            String str = scan.next();
            for (int j = 0; j < str.length()-1; j++) {
                // 현재 문자와 다음 문자가 다르다 && 그 이후에 현재 문자가 존재한다. -> 그룹 단어가 아니다.
                if(str.charAt(j) != str.charAt(j+1) && str.indexOf(str.charAt(j),j+1) > 0){
                        result = false;
                        break;
                }
            }            
            if(result) answer++;
        }
        System.out.println(answer);
    }
}
