package suseok;

import java.util.Arrays;
import java.util.Scanner;

public class 보물 {
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int N = scanner.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        for (int i = 0; i < N; i++) {
            B[i] = scanner.nextInt();
        }

        // A를 오름차순으로 정렬하고, B를 내림차순으로 정렬하여 S를 계산
        Arrays.sort(A);
        Arrays.sort(B);
        reverseArray(B);

        // S 계산
        int S = 0;
        for (int i = 0; i < N; i++) {
            S += A[i] * B[i];
        }

        // 결과 출력
        System.out.println(S);
    }

    // 배열을 역순으로 정렬하는 함수
    private static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
}

