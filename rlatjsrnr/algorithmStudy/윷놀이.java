import java.util.Scanner;

public class Yutnori {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("지금부터 윷을 열 번 던질 거에요~");

        // 던져서 나온 결과 카운트
        // result[0] : 모 , result[1] : 도 , result[2] : 개 ....
        int[] result = new int[5];

        for(int i=0; i<10; i++){
            String[] s = scan.nextLine().split(" ");

            // 1의 개수를 센다
            int count = 0;
            for(String yut : s){
                if(yut.equals("1")){
                    count++;
                }
            }
            result[count]++;
        }
        printResult(result);
    }
    
    public static void printResult(int[] result){
        String[] yut = {"모", "도", "개", "걸", "윷"};
        int sum = 0;
        for(int i = 1; i <= 5; i++){
            System.out.println(yut[i%5] + " : " + result[i%5] + "회");
            sum += (result[i%5] * i);
        }
        System.out.println("전진한 칸 수 : " + sum);
    }
}
