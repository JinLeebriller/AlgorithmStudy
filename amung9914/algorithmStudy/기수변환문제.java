import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
문제1.

아래 예시처럼 기수 변환 과정을
자세히 나타내는 프로그램을
작성하세요. (아래 예시의 59, 2라는 값은 Scanner로 입력 받은 값입니다.)

Console창)

10진수를 기수 변환합니다.
변환하는 음이 아닌 정수 : 59
어떤 진수로 변환할까요? (2~36): 2

2 |        59
  +————-
2 |        29    •••1
  +————-
(•••생략•••)
2 |           1    •••1
  +————-
               0    •••1
2진수로 111011입니다.

*/
public class Main2 {
    public static void main(String[] args) {

        solution();
    }

    // 59 : x , 2 : y

    public static void solution () {

        String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        List<String> dchar = Arrays.asList(str.split(""));
        System.out.println(dchar.get(14));

        Scanner scanner = new Scanner(System.in);

        System.out.println("10진수 입력 : ");
        int target = scanner.nextInt();
        System.out.println("변환할 진수 입력 : ");
        int jinsu = scanner.nextInt();

        int nameoji = target%jinsu;
        StringBuilder sb = new StringBuilder();
        System.out.printf("%d|   %d%n",jinsu,target);
        System.out.println(" +---------");

        while(true){
            // System.out.printf("%d|   %d ... %d %n",jinsu,target/jinsu,target%jinsu);
            System.out.printf("%d|   %d ... %s %n",jinsu,target/jinsu,dchar.get(target%jinsu));
            System.out.println(" +---------");
            sb.append(dchar.get(target%jinsu));
            target = target/jinsu;
            if(target/jinsu<=1){
                System.out.printf("       %d ... %s%n",target/jinsu,dchar.get(target%jinsu));
                sb.append(dchar.get(target%jinsu));
                break;
            }
        }
        System.out.println(jinsu+"진수로 "+ sb.reverse()+"입니다.");

    }
}
