import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GroupCount {

    static int sum = 0; //그룹단어가 아닌 수 합계

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = scanner.nextInt();
        for(int i = 0; i<max; i++){
            count(scanner.next());
        }
        System.out.println(max-sum);
    }

    private static void count (String s){
        char[] arr = s.toCharArray();
        List<Character> lastList = new ArrayList<>();
        char temp = arr[0];
        for(int i=0; i<arr.length; i++){
            if(temp==arr[i]){
                continue;
            }else{ //다른 문자인 경우
                if(lastList.contains(arr[i])){
                    sum++;
                   break;
                }
                lastList.add(temp);
                temp = arr[i];
            }

        }

    }
}
