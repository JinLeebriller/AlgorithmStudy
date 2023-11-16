import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Yutnori {
    
    public static void main(String[] args) {
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<10; i++){
            String input = generateYut();
            int result = game(input);
            map.merge(result, 1, Integer::sum);
            sum += result;
        }
        String[] resultYutStr = {"모","도","개","걸","윷"};
        for(int i=0; i< resultYutStr.length; i++){
            printYut(resultYutStr,map,i);
        }
        System.out.println();
        System.out.println("총"+sum+"칸 전진하였습니다.");
    }

    // 윷 게임 결과 출력
    private static void printYut(String[] resultYutStr, Map<Integer, Integer> map, int i) {
        if(map.containsKey(i)){
            System.out.print(resultYutStr[i]+" "+map.get(i)+"회 ");
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
