package algorithmStudy;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("기준 시간을 입력해주세요. (예시. 23:55:45) : ");
        String[] time = sc.nextLine().split(":");
        System.out.print("추가할 시간을 입력해주세요. (예시. 00:07:03) : ");
        String[] addTime = sc.nextLine().split(":");

        int hour = Integer.parseInt(time[0]) + Integer.parseInt(addTime[0]);
        int minute = Integer.parseInt(time[1]) + Integer.parseInt(addTime[1]);
        int second = Integer.parseInt(time[2]) + Integer.parseInt(addTime[2]);

        if(second >= 60) minute += second / 60;
        if(minute >= 60) hour += minute / 60;

        System.out.printf("결과 : %02d:%02d:%02d", hour % 24, minute % 60, second % 60);
    }
}