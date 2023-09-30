import java.util.*;
/* 손코딩 버전 */
public class Jinsu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] arr = new char[35];
        String sample = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int count = 0;

        System.out.println("10진수를 기수변환합니다");
        System.out.print("변환하는 음이 아닌 정수:");
        int target = scan.nextInt();

        System.out.print("어떤 진수로 변환할까요?(2~36)");
        int n = scan.nextInt();

        System.out.println(n+"|         "+target);
        System.out.println(" +-------------------");
        do{
            // String타입.charAt(인덱스번호) == 문자열에서 원하는 위치의 문자를 char타입으로 변환한다
            arr[count]=sample.charAt(target%n);
            target = target/n;
            if(target==0){
                System.out.println("         "+target+"..."+arr[count]);
            }else{
                System.out.println(n+"|         "+target+"..."+arr[count]);
                System.out.println(" +-------------------");
                count++;
            }
        }while(target>0);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<=count;i++){
            sb.append(arr[i]);
        }
        System.out.println(n+"진수로"+sb.reverse()+"입니다.");
    }
}
