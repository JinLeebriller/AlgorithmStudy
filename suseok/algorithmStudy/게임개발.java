미완성..

package suseok;

import java.util.Scanner;

public class CreateGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("맵의 세로 크기");
        int N = sc.nextInt();

        System.out.println("맵의 가로 크기");
        int M = sc.nextInt();

        System.out.println("캐릭터의 초기 A좌표");
        int A = sc.nextInt();

        System.out.println("캐릭터의 초기 B좌표");
        int B = sc.nextInt();

        System.out.println("캐릭터의 초기 방향");
        int D = sc.nextInt(); // 캐릭터의 초기 방향

        int[][] map = new int[N][M]; // 맵 정보

        int[][] visit = new int[N][M]; // 방문한 칸을 표시하는 배열

        int[] dx = { -1, 0, 1, 0 }; // 북, 동, 남, 서 방향을 나타내는 배열
        int[] dy = { 0, 1, 0, -1 };
