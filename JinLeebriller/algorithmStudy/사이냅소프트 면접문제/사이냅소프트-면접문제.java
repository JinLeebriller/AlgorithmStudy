package algorithmStudy;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        String input = "이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,권종표,최승혁,이유덕,박민호,이재영,이성연,박영서,박민호,권종표,전경헌,송정환,김재성,이유덕,전경헌,권종표,이재영";
        String[] names = input.split(",");

        System.out.println("1. 김씨와 이씨는 각각 몇 명 인가요?");
        System.out.printf("김씨는 %d명, 이씨는 %d명 %n", countLastName(names, "김"), countLastName(names, "이"));

        System.out.println("2. \"이재영\"이란 이름이 몇 번 반복되나요?");
        System.out.printf("%d번 반복 %n", countDuplication(names, "이재영"));

        System.out.println("3. 중복을 제거한 이름을 출력하세요.");
        System.out.println(removeDulicates(names));

        System.out.println("4. 중복을 제거한 이름을 오름차순으로 정렬하여 출력하세요.");
        System.out.println(removeAndSortDuplicates(removeDulicates(names)));

        System.out.println("5. 중복된 이름을 전부 출력하세요.");
        System.out.println(outputDuplicates(names));

        System.out.println("6. 그리고 그 갯수는 총 몇 개인가요?");
        System.out.println(outputDuplicates(names).size());
    }

    // 특정 성씨가 몇 명인지 구하는 메서드
    static int countLastName(String[] names, String lastName) {
        int count = 0;
        for(String name : names) {
            if(name.startsWith(lastName)) {
                count++;
            }
        }
        return count;
    }

    // 특정 이름이 몇 번 반복되는지 구하는 메서드
    static int countDuplication(String[] names, String duplicateName) {
        int count = 0;
        for(String name : names) {
            if(name.equals(duplicateName)) {
                count++;
            }
        }
        return count;
    }

    // 중복을 제거한 이름 출력
    static Set<String> removeDulicates(String[] names) {
        Set<String> deduplication = new HashSet<>();
        for(String name : names) {
            deduplication.add(name);
        }
        return deduplication;
    }

    // 중복을 제거한 이름을 오름차순으로 정렬하여 출력
    static Set<String> removeAndSortDuplicates(Set<String> deduplication) {
        Set<String> sortedDeduplication = new TreeSet<>(deduplication);
        return sortedDeduplication;
    }

    // 중복된 이름을 전부 출력
    static Set<String> outputDuplicates(String[] names) {
        Set<String> allNames = new HashSet<>();
        Set<String> duplicateNames = new TreeSet<>();
        for(String name : names) {
            if(!allNames.add(name)) {
                duplicateNames.add(name);
            }
        }
        return duplicateNames;
    }
}