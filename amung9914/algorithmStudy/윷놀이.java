import java.util.*;

public class Yutnori {

    public static void main(String[] args) {
        int sum = 0;
        int[] arr = new int[5]; // 결과값을 담을 배열
        for(int i=0; i<10; i++){
            String input = generateYut(); // 입력값 생성
            int result = game(input); // 윳 개수 카운팅
            arr[result]++;
            sum += result;
        }
        String[] resultYutStr = {"모","도","개","걸","윷"};
        for(int i=0; i< resultYutStr.length; i++){
            printYut(resultYutStr,arr,i);
        }
        System.out.println();
        System.out.println("총"+sum+"칸 전진하였습니다.");
    }

    // 윷 게임 결과 출력
    private static void printYut(String[] resultYutStr, int[] arr, int i) {
        if(arr[i]>0){
            System.out.print(resultYutStr[i]+" "+arr[i]+"회 ");
        }
    }

    // 뒤집힌 윷 카운트
    private static int game(String input) {
        String[] arr = input.split(" ");
        int result = 0;
        for(String s : arr){
            result += Integer.parseInt(s);
        }
        return result;
    }

    // 입력값 생성
    // 0 : 안뒤집힘, 1: 뒤집어진 상태
    public static String generateYut(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append(random.nextInt(2));
        for(int i=0;i<3;i++){
            sb.append(" ");
            sb.append(random.nextInt(2));
        }
        return sb.toString();
    }
}
