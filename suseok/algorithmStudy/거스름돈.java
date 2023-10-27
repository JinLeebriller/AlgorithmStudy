// 단점 1000엔이 넘으면 계산이 안되는게 단점 
// 물론 문제가 1000엔이었지만 유기적으로 계산할수 있게 만들수 있을거 같았는데
// 일단 멈췄음..
// 처음에 접근을 배열에 500,100,50,10,5,1 을 넣고 
// 1000에서 뺀 숫자를 그 배열을 통해 몇개가 되는지 나누고 그 갯수를 합치는 걸로 접근을 했습니다

package suseok;

import java.util.Scanner;

public class ChangeMoney {
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);

      // 잔돈의 종류와 개수를 저장할 배열
        int[] arr = {500, 100, 50, 10, 5, 1};
        int[] count = new int[arr.length];

        // 입력 받기
        System.out.println("계산을 위해 낸 돈(1000엔 안으로)");
        int pay = scanner.nextInt();

        // 1000엔 지폐를 한 장 냈을 때, 거스름돈 계산
        int change = 1000 - pay;

        // 거스름돈 계산
        for (int i = 0; i < arr.length; i++) {
            if (change >= arr[i]) {
            	count[i] = change / arr[i];
                change -= count[i] * arr[i];
            }
        }

        // 결과 출력
        System.out.println("거스름돈의 총 개수: " + totalCount(count));
        System.out.print("\n");
        changeCount(arr, count);
    }

    // 잔돈의 개수 합산
    private static int totalCount(int[] totalCount) {
        int totalChangeCount = 0;
        for (int count : totalCount) {
            totalChangeCount += count;
        }
        return totalChangeCount;
    }

    // 각 잔돈의 개수 표시
    private static void changeCount(int[] arr, int[] count) {
    	System.out.println("각 잔돈의 갯수는");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "엔 : " + count[i]);
        }
    }
}
