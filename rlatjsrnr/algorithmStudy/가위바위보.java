import java.util.*;
import java.util.stream.Collectors;

public class Algorithm_9_4_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 플레이어 목록
        Map<String, String> players = new HashMap<>();

        for(int i=1; i<=5; i++){
            players.put("p"+i,"");
        }

        int round = 0;

        while (players.size() != 1) {
            round++;

            // 사용자에게 값을 입력받는 반복문
            while (true) {
                System.out.print(players.size() + "개의 자연수를 입력하세요.(1 : 가위, 2 : 바위, 3 : 보) : ");
                String input = sc.next();
                String[] RSP = input.split("");

                // 입력한 자연수 값이 잘 입력 되었다면
                if (Arrays.stream(RSP).allMatch(s -> s.equals("1") || s.equals("2") || s.equals("3"))) {
                    Set<String> player = players.keySet();
                    // 플레이어 수와 입력한 값의 개수를 비교하여 일치하면
                    if (RSP.length == players.size()) {
                        int index = 0;
                        for (String s : player) {
                            players.put(s, RSP[index]);
                            index++;
                        }
                        break;
                    } else {
                        System.out.println("입력 개수가 이상합니다. 다시 입력해주세요~!");
                    }
                } else {
                    System.out.println("입력 값이 이상합니다. 다시 입력해주세요~!");
                }
                System.out.println();
            }

            // 사용자가 값을 잘 입력하면 진행
            // 무승부
            if (players.containsValue("1") && players.containsKey("2") && players.containsValue("3")){
                System.out.println("무승부!!");

            }else if (players.values().stream().filter(i -> i.equals("1")).count() == players.size() ||
                    players.values().stream().filter(i -> i.equals("2")).count() == players.size() ||
                    players.values().stream().filter(i -> i.equals("3")).count() == players.size()
            ) {
                System.out.println("무승부!!");

                // 보가 이긴 경우
            } else if (players.values().stream().noneMatch(i -> i.equals("1"))) {
                System.out.println("승자 : " + players.values().stream().filter(i -> i.equals("3")).count() + "명");
                removePlayer(players, "2");

                // 가위가 이긴 경우
            } else if (players.values().stream().noneMatch(i -> i.equals("2"))) {
                System.out.println("승자 : " + players.values().stream().filter(i -> i.equals("1")).count() + "명");
                removePlayer(players, "3");

                // 바위가 이긴 경우
            } else if (players.values().stream().noneMatch(i -> i.equals("3"))) {
                System.out.println("승자 : " + players.values().stream().filter(i -> i.equals("2")).count() + "명");
                removePlayer(players, "1");
            }
            System.out.println();
        }
        // 게임 종료

        Set<String> winner = players.keySet();

        System.out.println("게임 종료!");
        System.out.println("총 시행 횟수 : " + round +"회");
        System.out.println("최종 승자 : " + winner);

    }

    /**
     * 패배한 플레이어의 키값으로 플레이어 목록에서 삭제
     * @param players - 플레이어 목록
     * @param value - 게임에서 패배한 값
     */
    public static void removePlayer(Map<String, String> players, String value){
        List<String> removeKey = players.entrySet().stream()
                .filter(entry -> Objects.equals(entry.getValue(), value))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("탈락한 player : "+removeKey);

        for(String key : removeKey){
            players.remove(key);
        }
    }
}
