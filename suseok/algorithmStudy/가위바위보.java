
package suseok;

import java.util.Random;

public class RSPGame {

    public static void main(String[] args) {
        int[] choices = new int[5];
        Random random = new Random();

        int round = 1;
        int eliminatedCount = 0;

        while (eliminatedCount < 4) {
            System.out.println("라운드 " + round);
            round++;

            // 초기 랜덤 숫자 부여 (1: 가위, 2: 바위, 3: 보)
            for (int i = 0; i < 5; i++) {
                choices[i] = random.nextInt(3) + 1;
                System.out.println((i + 1) + "번째 참가자: " + choiceToString(choices[i]));
            }

            // 가위바위보 결과 계산
            int[] winners = playRSP(choices);

            // 승자와 탈락자 처리
            if (winners.length == 0) {
                System.out.println("무승부입니다. 다음 라운드로 진행합니다.");
            } else {
                for (int winnerIndex : winners) {
                    System.out.println((winnerIndex + 1) + "번째 참가자 승리!");
                    choices[winnerIndex] = -1; // 탈락 처리
                    eliminatedCount++;
                }
            }
        }

        // 최종 승자 출력
        for (int i = 0; i < 5; i++) {
            if (choices[i] != -1) {
                System.out.println("최종 승자는 " + (i + 1) + "번째 참가자입니다.");
                break;
            }
        }
    }

    private static boolean compare(int a, int b) {
        return (a == 1 && b == 2) || (a == 2 && b == 3) || (a == 3 && b == 1);
    }

    public static int[] playRSP(int[] choices) {
        int[] winners = new int[5]; // 승자 인덱스 배열
        boolean[] eliminated = new boolean[5]; // 탈락한 참가자를 체크하는 배열

        // 1라운드에서 탈락한 참가자를 체크하기 위해 초기화
        for (int i = 0; i < 5; i++) {
            eliminated[i] = false;
        }

        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                if (eliminated[i] || eliminated[j] || choices[i] == -1 || choices[j] == -1) {
                    // 이미 탈락한 참가자이거나 이번 라운드에서 이미 처리한 참가자는 건너뛰기
                    continue;
                }
                if (compare(choices[i], choices[j])) {
                    // i번째 참가자 승리
                    winners[i] = i;
                    eliminated[j] = true;
                } else if (choices[i] == choices[j]) {
                    // 무승부
                    winners = new int[0];
                    eliminated = new boolean[5];
                    for (int k = 0; k < 5; k++) {
                        eliminated[k] = false;
                    }
                    break;
                } else {
                    // j번째 참가자 승리
                    winners[j] = j;
                    eliminated[i] = true;
                }
            }
            if (winners.length == 0) {
                break;
            }
        }

        // 탈락자 처리
        for (int i = 0; i < 5; i++) {
            if (eliminated[i]) {
                choices[i] = -1;
            }
        }

        return winners;
    }

    public static String choiceToString(int choice) {
        switch (choice) {
            case 1:
                return "가위";
            case 2:
                return "바위";
            case 3:
                return "보";
            default:
                return "탈락";
        }
    }
}
