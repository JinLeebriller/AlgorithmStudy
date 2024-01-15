package algorithmStudy;

import java.util.*;

public class Solution {
    public String solution(String m, String[] musicinfos) {
        StringBuilder answer = new StringBuilder("(None)");
        int playingTime = 0;

        for(int i = 0 ; i < musicinfos.length ; i++) {
            String[] music = musicinfos[i].split(",");

            StringBuilder sb = new StringBuilder(music[0] + music[1]);

            int startTime = Integer.parseInt(sb.charAt(0) + "" + sb.charAt(1)) * 60 + Integer.parseInt(sb.charAt(3) + "" + sb.charAt(4));
            int endTime = Integer.parseInt(sb.charAt(5) + "" + sb.charAt(6)) * 60 + Integer.parseInt(sb.charAt(8) + "" + sb.charAt(9));

            int musicTime = endTime - startTime;

            List<String> mList = new ArrayList<>();
            List<String> musicinfoList = new ArrayList<>();

            for (int j = 0 ; j < m.length(); j++) {
                if (m.charAt(j) == '#') {
                    mList.remove(mList.size() - 1);
                    mList.add(String.valueOf(m.charAt(j - 1)) + m.charAt(j));
                } else {
                    mList.add(String.valueOf(m.charAt(j)));
                }
            }

            StringBuilder sb2 = new StringBuilder();
            for(int j = 0 ; j < mList.size() ; j++) {
                sb2.append(mList.get(j) + " ");
            }

            for(int j = 0 ; j < music[3].length() ; j++) {
                if(music[3].charAt(j) == '#') {
                    musicinfoList.remove(musicinfoList.size() - 1);
                    musicinfoList.add(String.valueOf(music[3].charAt(j - 1)) + music[3].charAt(j));
                } else {
                    musicinfoList.add(String.valueOf(music[3].charAt(j)));
                }
            }

            StringBuilder sb3 = new StringBuilder();
            if(musicTime / musicinfoList.size() == 0) {
                for(int j = 0 ; j < musicTime % musicinfoList.size() ; j++) {
                    sb3.append(musicinfoList.get(j) + " ");
                }
            } else {
                for(int j = 0 ; j < musicTime / musicinfoList.size() ; j++) {
                    for(int k = 0 ; k < musicinfoList.size() ; k++) {
                        sb3.append(musicinfoList.get(k) + " ");
                    }
                }
                for(int j = 0 ; j < musicTime % musicinfoList.size() ; j++) {
                    sb3.append(musicinfoList.get(j) + " ");
                }
            }

            if(sb3.indexOf(sb2.toString()) != -1) {
                if(playingTime < musicTime) {
                    answer.setLength(0);
                    answer.append(music[2]);
                    playingTime = musicTime;
                }
            }
        }

        return answer.toString();
    }
}