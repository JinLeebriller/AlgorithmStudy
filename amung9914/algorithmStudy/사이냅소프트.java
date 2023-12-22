import java.util.*;
import java.util.stream.Collectors;

public class Synap {

    public static void main(String[] args) {
        String input = "이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,권종표,최승혁,이유덕,박민호,이재영,이성연,박영서,박민호,권종표,전경헌,송정환,김재성,이유덕,전경헌,권종표,이재영";
        String[] array = input.split(",");

        System.out.println("1. 김씨와 이씨는 각각 몇 명인가요?");
        System.out.println("김씨 : "+countForFirstName(array,"김")+"명");
        System.out.println("이씨 : "+countForFirstName(array,"이")+"명");
        System.out.println("'이재영'이라는 이름이 몇 번 반복되나요?");
        System.out.println((duplicateForName(array,"이재영")-1) +"번 반복됩니다");
        System.out.println("중복을 제거한 이름을 출력하세요");
        Set<String> names = makeSet(array);
        for (String s : names) {
            System.out.print(s+",");
        }
        System.out.println();
        System.out.println("중복을 제거한 이름을 오름차순으로 정렬하여 출력하세요");
        List<String> namelist = names.stream().collect(Collectors.toList());
        Collections.sort(namelist);
        for (String s : namelist) {
            System.out.print(s+",");
        }
        System.out.println();
        System.out.println("중복된 이름을 전부 출력하세요");
        Set<String> duplicatedList = countDuplicated(array);
        for (String s : duplicatedList) {
            System.out.print(s+",");
        }
        System.out.println();
        System.out.println("중복된 이름의 개수는 총 몇개 인가요?");
        System.out.println(duplicatedList.size()+"개 입니다.");
    }

    static int countForFirstName(String[] array, String firstName){
        int count = 0;
        for (String s : array) {
            if(s.startsWith(firstName)){
                count++;
            }
        }
        return count;
    }

    static int duplicateForName(String[] array, String name){
        int count = 0;
        for (String s : array) {
            if(s.equals(name)){
                count++;
            }
        }
        return count;
    }

    static Set<String> makeSet(String[] array){
        Set<String> set = new HashSet<>();
        for (String s : array) {
            set.add(s);
        }
        return set;
    }

    static Set<String> countDuplicated(String[] array){
        List<String> original = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String s : array) {
            if(original.contains(s)){
                set.add(s);
            }else{
                original.add(s);
            }
        }
        return set;
    }

}
