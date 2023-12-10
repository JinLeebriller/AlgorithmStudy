import java.util.*;

public class RoundQueue {

    static int count = 0;

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int max = scanner.nextInt();
        int targetCount = scanner.nextInt();

        List<Integer> targetList = new ArrayList<>();
        for (int i = 0; i < targetCount; i++) {
            targetList.add(scanner.nextInt()); //뽑는수
        }
        //큐생성
        for (int i = 0; i < max; i++) {
            arr.add(i+1);
        }

        //연산을 한다.
        while(!targetList.isEmpty()){
            if(targetList.get(0).equals(arr.get(0))){
                arr.remove(arr.get(0));
                targetList.remove(targetList.get(0));
            }else{
                int normal = arr.indexOf(targetList.get(0));
                int reverse = arr.size()-normal;
                if(normal>reverse){
                   arr = toRight(arr);
                }else{
                    arr = toLeft(arr);
                }
            }
        }
        System.out.println(count);
    }

    static public List<Integer> toLeft(List<Integer> list){
        count++;
        List<Integer> list2 = new ArrayList<>();
        int first = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            list2.add(list.get(i));
        }
        list2.add(first);
        return list2;
    }

    static public List<Integer> toRight(List<Integer> list){
        count++;
        List<Integer> list2 = new ArrayList<>();
        list2.add(list.get(list.size()-1));
        for (int i = 0; i < list.size()-1; i++) {
            list2.add(list.get(i));
        }
        return list2;
    }
}
