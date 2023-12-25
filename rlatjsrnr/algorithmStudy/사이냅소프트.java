import java.util.*;

public class 사이냅소프트 {
    public static void main(String[] args) {
        String names = "이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,권종표,최승혁,이유덕,박민호,이재영,이성연,박영서,박민호,권종표,전경헌,송정환,김재성,이유덕,전경헌,권종표,이재영";

        int kimCount = 0;
        int leeCount = 0;
        int leejeayoungCount = 0;

        List<String> nameList = new ArrayList<>();
        Set<String> duplicateNameList = new HashSet<>();

        for(String s : names.split(",")){
            if(s.startsWith("김")) kimCount++;
            else if(s.startsWith("이")) {
                leeCount++;
                if(s.equals("이재영")) leejeayoungCount++;
            }
            if(nameList.contains(s)){
                duplicateNameList.add(s);
            }else{
                nameList.add(s);
            }
        }

        System.out.println("김씨와 이씨는 각각 몇명인가요?");
        System.out.println("김씨 : " + kimCount + "명");
        System.out.println("이씨 : " + leeCount + "명");

        System.out.println("\"이재영\"이란 이름이 몇 번 반복되나요? " + leejeayoungCount + "번");
        System.out.println("중복을 제거한 이름을 출력하세요");
        System.out.println(nameList);
        System.out.println("중복을 제거한 이름을 오름차순으로 정렬하여 출력하세요");
        Collections.sort(nameList);
        System.out.println(nameList);

        System.out.println("중복된 이름을 전부 출력하세요");
        System.out.println(duplicateNameList);
        System.out.println("그리고 그 갯수는 총 몇개인가요?");
        System.out.println(duplicateNameList.size() + "개");

    }

}
