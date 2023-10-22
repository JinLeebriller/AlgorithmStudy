package suseok;

import java.util.Scanner;

public class Time {
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("현재 시간을 입력하세요 (hh:mm:ss): ");
        String nowTime = scanner.next();

        System.out.print("추가할 시간을 입력하세요 (hh:mm:ss): ");
        String enterTime = scanner.next();

        String result = clock(nowTime, enterTime);
        System.out.println("결과: " + result);

        scanner.close();
    }
	
    public static String clock(String nowTime, String enterTime) {
    	
        String[] nowTimePart = nowTime.split(":");
        int firstHour = Integer.parseInt(nowTimePart[0]);
        int firstMinute = Integer.parseInt(nowTimePart[1]);
        int firstSecond = Integer.parseInt(nowTimePart[2]);

        String[] enterTimePart = enterTime.split(":");
        int secondHour = Integer.parseInt(enterTimePart[0]);
        int secondMinute = Integer.parseInt(enterTimePart[1]);
        int secondSecond = Integer.parseInt(enterTimePart[2]);

        int totalSeconds = firstSecond + secondSecond;
        int totalMinutes = firstMinute + secondMinute + totalSeconds / 60;
        int totalHours = firstHour + secondHour + totalMinutes / 60;

        totalSeconds = totalSeconds % 60;
        totalMinutes = totalMinutes % 60;
        totalHours = totalHours % 24;

        String resultHour = String.format("%02d", totalHours);
        String resultMinute = String.format("%02d", totalMinutes);
        String resultSecond = String.format("%02d", totalSeconds);

        return resultHour + ":" + resultMinute + ":" + resultSecond;
    }

}

