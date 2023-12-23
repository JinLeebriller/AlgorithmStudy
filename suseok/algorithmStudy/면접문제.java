package suseok;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Question {

    public static void main(String[] args) {
    	
    	// 이름 저장
        String namesStr = "이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,권종표,최승혁,이유덕,박민호 이재영,이성연,박영서,박민호,권종표,전경헌,송정환,김재성,이유덕,전경헌,권종표,이재영";

        // 저장한 이름을 구분
        List<String> namesList = Arrays.asList(namesStr.split(","));

        // 1. "김씨"와 "이씨"는 각각 몇 명 인가요?
        long kimCount = namesList.stream().filter(name -> name.startsWith("김")).count();
        long leeCount = namesList.stream().filter(name -> name.startsWith("이")).count();
        System.out.println("1. 김씨는 " + kimCount + "명, 이씨는 " + leeCount + "명");

        // 2. "이재영"이란 이름이 몇 번 반복되나요?
        long leeJaeyoungCount = namesList.stream().filter(name -> name.equals("이재영")).count();
        System.out.println("2. 이재영은 " + leeJaeyoungCount + "번 반복됩니다.");

        // 3. 중복을 제거한 이름을 출력
        Set<String> removeName = new HashSet<>(namesList);
        System.out.println("3. 중복을 제거한 이름: " + removeName);

        // 4. 중복을 제거한 이름을 오름차순으로 정렬하여 출력
        List<String> sortremoveName = removeName.stream().sorted().collect(Collectors.toList());
        System.out.println("4. 중복을 제거하고 정렬한 이름: " + sortremoveName);

        // 5. 중복된 이름을 전부 출력
        List<String> duplicateName = namesList.stream()
                .filter(name -> namesList.indexOf(name) != namesList.lastIndexOf(name))
                .distinct()
                .collect(Collectors.toList());
        System.out.println("5. 중복된 이름: " + duplicateName);

        // 6. 중복된 이름의 총 갯수
        long totalduplicateName = duplicateName.size();
        System.out.println("6. 중복된 이름의 총 갯수: " + totalduplicateName);
    }
}




