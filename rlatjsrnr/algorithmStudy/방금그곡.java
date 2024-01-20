public class 방금그곡 {

    // # 제거 후 소문자로 변환
    public static String replace_music(String music){
        StringBuilder sb_music = new StringBuilder(music);
        for(int i = 0; i < music.length(); i++){
            if(sb_music.charAt(i) == '#'){
                sb_music.replace(i-1, i, String.valueOf(sb_music.charAt(i-1)).toLowerCase());
            }
        }
        return sb_music.toString().replaceAll("#", "");
    }

    public static void main(String[] args) {
        String m = "CC#BCC#BCC#BCC#B";
        String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        String answer = "";
        int answer_play_time = 0;
        m = replace_music(m);

        for(String s : musicinfos) {
            String[] musicinfo = s.split(",");
            int start = Integer.parseInt(musicinfo[0].split(":")[0]) * 60 + Integer.parseInt(musicinfo[0].split(":")[1]);
            int end = Integer.parseInt(musicinfo[1].split(":")[0]) * 60 + Integer.parseInt(musicinfo[1].split(":")[1]);
            String title = musicinfo[2];
            String music = replace_music(musicinfo[3]);

            // 음악 재생 시간을 분으로
            int play_time = end - start;

            StringBuilder sb_music = new StringBuilder(music);
            int music_length = music.length();
            // 재생 시간 보다 악보가 길면 자른다
            if (music_length >= play_time) {
                sb_music = new StringBuilder(sb_music.substring(0, play_time));
            // 짧으면 반복한다.
            } else {
                for (int i = music_length; i < play_time; i++) {
                    sb_music.append(music.charAt(i % music_length));
                }
            }
            // 일치하는 음악이 여러개면 재생 시간이 가장 긴 음악 선택
            if (sb_music.indexOf(m) > -1) {
                if(answer.equals("(None)")){
                    answer_play_time = play_time;
                    answer = title;
                }else{
                    if(play_time > answer_play_time){
                        answer = title;
                        answer_play_time = play_time;
                    }
                }
            }
        }
        System.out.println("answer = " + answer);
    }
}
