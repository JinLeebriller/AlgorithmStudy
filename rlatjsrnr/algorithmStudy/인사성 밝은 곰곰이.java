import java.util.ArrayList;
import java.util.Scanner;

public class SayHi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        int answer = 0;
        int n = scan.nextInt();
        for(int i = 0; i < n; i++){
            String user = scan.next();
            if(user.equals("ENTER")){
                list.clear();
                continue;
            }
            if(!list.contains(user)){
                list.add(user);
                answer++;
            }
        }

        System.out.println(answer);
    }
}
