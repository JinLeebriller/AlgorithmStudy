import java.util.Scanner;

public class 기수변환문제 {
    Scanner scan = new Scanner(System.in);
    System.out.println("10진수를 기수 변환합니다.");
    System.out.print("변환하는 음이 아닌 정수 : ");
    int num = scan.nextInt();
    System.out.print("어떤 진수로 변환할까요? (2~36) : ");
    int n = scan.nextInt();

    System.out.println();

    StringBuilder sb = new StringBuilder();
    int mod = 0;
    System.out.printf("%d | %d%n", n,num);
    System.out.println("  +------");

    do{
        if(num < n){
            sb.append(num);
            System.out.printf("    %d  ... %d%n", num/n,mod);
            break;
        }else{
            mod = num % n;
            num /= n;

            if(mod < 10){
                sb.append(mod);
                System.out.printf("%d | %d  ... %d%n", n,num,mod);

            }else{
                mod += 54;
                sb.append((char)mod);
                System.out.printf("%d | %d  ... %c%n", n,num,(char)mod);
            }
            System.out.println("  +------");
        }
    }while (num > 0);

    sb.reverse();
    System.out.printf("%d 진수로 %s 입니다.", n, sb.toString());
}
