import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test11051 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("입력하세요");
        // l1 = [2,4,3], l2 = [5,6,4]
        // index 1 = l1, index 3 = l2
        String[] arr = scanner.nextLine().split("[\\[\\]]");

        String[] l1 = arr[1].split(",");
        String[] l2 = arr[3].split(",");

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        // 입력받은 배열을 역순 처리 & 정수로 변환
        for(int i= l1.length-1; i >=0;i--){
            sb1.append(l1[i]);
        }
        for(int i= l2.length-1; i >=0;i--){
            sb2.append(l2[i]);
        }
        int result = Integer.parseInt(sb1.toString())+Integer.parseInt(sb2.toString());

        // 다시 역순으로 연산결과 담기
        List<Integer> list = new ArrayList<>();
        while(result>1){
            list.add(result%10);
            result/=10;
        }
        if(result!=0)
            list.add(result);
        System.out.println(list);

    }
}
