package lotto;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Random;

public class LottoApiIntegration {

    public static void main(String[] args) {
        // 로또 회차 번호 지정
        int drawNo = 100;

        // API에서 로또 회차 정보 가져오기
        JSONObject lottoInfo = getLottoInfo(drawNo);

        if (lottoInfo != null) {
            // 로또 회차 정보에서 번호 가져오기
            int[] winningNumbers = getWinningNumbers(lottoInfo);

            if (winningNumbers != null) {
                // 생성된 로또 번호 출력
                System.out.println("로또 회차 " + drawNo + "의 당첨 번호: " + Arrays.toString(winningNumbers));
            } else {
                System.out.println("로또 번호를 가져올 수 없습니다.");
            }
        } else {
            System.out.println("로또 회차 정보를 가져올 수 없습니다.");
        }
    }

    // API에서 로또 회차 정보 가져오기
    private static JSONObject getLottoInfo(int drawNo) {
        try {
            URL url = new URL("http://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=" + drawNo);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            connection.disconnect();

            return new JSONObject(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    // 로또 회차 정보에서 당첨 번호 가져오기
    private static int[] getWinningNumbers(JSONObject lottoInfo) {
        int[] winningNumbers = new int[6];

        try {
            for (int i = 0; i < 6; i++) {
                winningNumbers[i] = lottoInfo.getInt("drwtNo" + (i + 1));
            }
            Arrays.sort(winningNumbers);

            return winningNumbers;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // 복권 번호를 생성하는 메서드
    private static int[] generateLotteryNumbers(int min, int max) {
        Random random = new Random();
        int[] lotteryNumbers = new int[6]; // 6개의 숫자로 이루어진 복권

        for (int i = 0; i < 6; i++) {
            lotteryNumbers[i] = random.nextInt((max - min) + 1) + min;
        }

        return lotteryNumbers;
    }

    // 배열에 특정 값이 포함되어 있는지 확인하는 메서드
    private static boolean contains(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }
}
