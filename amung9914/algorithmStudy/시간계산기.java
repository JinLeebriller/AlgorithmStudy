/*
※ 손으로 풀고 깃허브에 옮겨 적어주세요
(풀이시간10분~15분 제한)

기준 시간이 존재하고, 추가할 시간을 나타내는 인자가 주어지면 그것을 더해 시간을 나타내는 메소드를 만들어주세요.
예시) 현재 시간은 23:55:45입니다. 이때 00:07:03이 주어지면
00:02:48 로 리턴하는 메소드를 만들어주세요. (단, DecimalFormat,SimpleDateFormat은 사용할 수 없습니다.)
*/

public class Time {
    public static void main(String[] args) {
        System.out.println(solution("23:55:45","00:07:03"));
    }

    // 문자열 -> 초 계산 메소드 (아스키코드로 char -> int 변환)
    public static int cal(String time){
        char[] arr = time.toCharArray();
        int sum = 0;
        sum += (arr[0]-48)*10*3600;
        sum += (arr[1]-48)*3600;
        sum += (arr[3]-48)*10*60;
        sum += (arr[4]-48)*60;
        sum += (arr[6]-48)*10;
        sum += (arr[7]-48);
        return sum;
    }

    // 시간 더하는 메소드
    public static String solution(String time1, String time2){
        int result = cal(time1)+cal(time2);
        int[] tArr = new int[3];
        tArr[0] = result/3600; //hour
        if(tArr[0] >=24){
            tArr[0] -=24;
        }
        tArr[1]  = (result%3600)/60; //min
        tArr[2]  = (result%3600)%60; //sec

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<tArr.length;i++){
            if(tArr[i]<10)
                sb.append("0");
            sb.append(tArr[i]);
            if(i!=tArr.length-1)
                sb.append(":");
        }
        return sb.toString();
    }
}
