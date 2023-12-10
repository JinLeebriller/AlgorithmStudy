package algorithmStudy;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<Integer> deque = new LinkedList<>();

        int count = 0;

        int N = sc.nextInt();
        int M = sc.nextInt();

        for(int i = 1 ; i <= N ; i++) deque.offer(i);

        int[] pos = new int[M];

        for(int i = 0 ; i < M ; i++) pos[i] = sc.nextInt();

        for(int i = 0 ; i < M ; i++) {
            int targetIndex = deque.indexOf(pos[i]);
            int halfIndex;

            if(deque.size() % 2 == 0) halfIndex = deque.size() / 2 - 1;
            else halfIndex = deque.size() / 2;

            if(targetIndex <= halfIndex) {
                for(int j = 0 ; j < targetIndex ; j++) {
                    int temp = deque.pollFirst();
                    deque.offerLast(temp);
                    count++;
                }
            } else {
                for(int j = 0 ; j < deque.size() - targetIndex ; j++) {
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                    count++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(count);
    }
}
