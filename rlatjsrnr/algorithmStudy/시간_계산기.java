public class Time {
    public static void main(String[] args) {
        String curr = "23:55:45";
        String time = "00:07:03";
        String result = sol(curr, time);
        System.out.println(result);
    }

    public static String sol(String curr, String time){
        String[] times = time.split(":");
        int sec = Integer.parseInt(times[0]) * 3600 + Integer.parseInt(times[1]) * 60 + Integer.parseInt(times[2]);

        String[] currTime = curr.split(":");
        int answerSec = Integer.parseInt(currTime[2]) + sec;
        int answerMin = Integer.parseInt(currTime[1]);
        int answerHour = Integer.parseInt(currTime[0]);

        String result = "";
        if(answerSec >= 60){
            int temp = answerSec / 60;
            answerSec %= 60;

            answerMin += temp;

            if(answerMin >= 60){
                temp = answerMin / 60;
                answerMin %= 60;

                answerHour += temp;

                if(answerHour >= 24){
                    answerHour -= 24;
                }
            }
        }
        return plus0(answerHour) + ":" + plus0(answerMin) + ":" + plus0(answerSec);
    }

    public static String plus0(int time){
        String result = "";
        if(time < 10) return result + "0" + time;
        else return result + time;
    }
}
