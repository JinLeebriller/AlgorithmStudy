import java.util.HashMap;
import java.util.Map;

public class Music2 {
    static public String solution(String m, String[] musicinfos) {
        String[] melody = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
        String[] transArr = {"C","h","D","i","E","F","j","G","k","A","l","B"};
        String[] splitM = m.split("");
        String findMelody = "";
        // 역순으로 변환
        for (int i = splitM.length-1; i>=0; i--) {
            String target = splitM[i];
            if(splitM[i].equals("#")){
                target = splitM[i-1]+"#";
                i--;
            }
            for (int j = 0; j < melody.length; j++) {
                if(target.equals(melody[j])){
                    findMelody += transArr[j];
                    break;
                }
            }
        }
        // 문자 순서 변환
        StringBuffer sb = new StringBuffer(findMelody);
        String reversed = sb.reverse().toString();
        
        // 임시 저장할 자료구조
        Map<String,Integer> findMusic = new HashMap<>();
        String lastKey = null;
        for (int i = 0; i < musicinfos.length; i++) {
            String[] infos = musicinfos[i].split(",");
            String[] startTime = infos[0].split(":");
            String[] endTime = infos[1].split(":");
            int startMin = Integer.parseInt(startTime[0])*60 + Integer.parseInt(startTime[1]);
            int endMin = Integer.parseInt(endTime[0])*60 + Integer.parseInt(endTime[1]);
            int musicTime = endMin - startMin; // 총 시간

            // 주어진 음악 변환
            String[] splitNewMusic = infos[3].split("");
            String transMusic = "";

            for (int j = splitNewMusic.length-1; j>=0; j--) {
                String target = splitNewMusic[j];
                if(splitNewMusic[j].equals("#")){
                    target = splitNewMusic[j-1]+"#";
                    j--;
                }
                for (int k = 0; k < melody.length; k++) {
                    if(target.equals(melody[k])){
                        transMusic += transArr[k];
                        break;
                    }
                }
            }

            StringBuffer sb2 = new StringBuffer(transMusic);
            String reversed2 = sb2.reverse().toString();

            String newMusic = "";
            for (int j = 0; j < musicTime; j++) {
               newMusic += reversed2.charAt(j%reversed2.length());
            }


           if(newMusic.contains(reversed) &&findMusic.isEmpty()){
               findMusic.put(infos[2],musicTime);
               lastKey = infos[2];
           }else if(newMusic.contains(reversed)){
               Integer beforeTime = findMusic.get(lastKey);
               if(beforeTime<musicTime) {
                   findMusic.clear();
                   findMusic.put(infos[2], musicTime);
                   lastKey = infos[2];
               }
           }
        } // END for
        if(findMusic.isEmpty()){
            return "(None)";
        }else{
            return lastKey;
        }
    }

    public static void main(String[] args) {
        String m = "ABC";
        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution(m,musicinfos));
    }

}
