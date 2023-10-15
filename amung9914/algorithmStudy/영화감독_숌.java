import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Movie666 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("몇번째 영화의 제목을 출력할까요?");
        int n = scanner.nextInt();
        System.out.println("solution1 : "+solution(n));
    }

    public static int solution(int n){
        int count=0;
        // 저장공간 선언
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<=1000; i++){
            list.add((i*1000)+666);
            for(int j=0;j<=999; j++){
                count++;
                if(j<=9){
                    list.add((i * 1000 + 666)*10 + j);
                    list.add((i * 1000 + 666)*100 + j);
                    list.add((i * 1000 + 666)*1000 + j);
                }else if(j<=99){
                    list.add((i * 1000 + 666) * 100 + (j%100));
                }else{
                    list.add((i * 1000 + 666) * 1000 + (j%1000));
                }
            }
        }

        // 오름차순정렬 6660 6669 66600 / 66600 10066600 + 10
        // 166699
        Collections.sort(list);
        List<Integer> result = list.stream().distinct().toList();
        return result.get(n-1);

    }
}
