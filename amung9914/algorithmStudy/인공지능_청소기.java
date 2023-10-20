import java.util.Arrays;
import java.util.Scanner;

public class Cleaner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        scanner.nextLine();
        String[] answer = new String[len];
        for(int i = 0; i<answer.length; i++){
            answer[i] = scanner.nextLine();
            answer[i] = solution(answer[i]);
        }
        // 출력하기
        for(String result : answer){
            System.out.println(result);
        }
    }
    // 입력문자 : X Y N (x좌표,y좌표,이동거리)
    public static String solution(String num){
        String[] strings = num.split(" ");
        int x = Integer.parseInt(strings[0]);
        if(x<0)
            x*=-1;
        int y = Integer.parseInt(strings[1]);
        if(y<0)
            y*=-1;
        int n = Integer.parseInt(strings[2]);
        // 최단거리 이상 && 짝수인지 홀수인지 판별
        if(((x+y)<=n)&&(x+y)%2==n%2){
            return "YES";
        }
        return "NO";
    }
}
/*
문제 1. 인공지능 청소기

준우는 이번에 홈쇼핑에서 홍보했던 로봇 청소기를 구매했다. 준우는 새로 산 로봇 청소기의 예약 청소 기능을 테스트해보려고 한다. 예약 청소 기능은 로봇 청소기가 자유롭게 주변을 청소하다가 사용자가 설정한 시간과 장소에 정확히 도착하는 기능이다. 원하는 시간과 장소의 좌표를 입력하면 다른 장소들을 임의로 청소하다가 정확히 도착 예정 시간에 해당 위치에 도착한다. 이 과정에서 동일한 위치를 두 번 이상 지나쳐서 청소할 수 도 있다.

준우는 다음과 같은 규칙 하에서 예약 청소 기능이 정확히 동작할 수 있는지 궁금해졌다.

· 준우의 집은 2차원 정수 좌표계로 표현할 수 있고 초기 로봇 청소기의 위치는 (0,0)이다.
· 로봇 청소기는 1초에 한 번 움직여야만 하며, 이 때 상하좌우 중 하나의 방향으로 1의 거리를 움직인다.
· 이미 청소하고 지나갔던 칸을 다시 방문해도 괜찮다.
· 준우가 정한 N초의 시간이 정확히 흐른 시점에 로봇 청소기는 (X,Y)에 위치해 있어야 한다.

준우가 예약한 시간과 위치의 좌표가 입력으로 주어질 때, 로봇 청소기가 정확한 시간에 도착할 수 있는지 여부를 판단하는 프로그램을 작성하시오.

<예제 설명>

그림 1. (0,0)에서 출발하여  (1,2)지점에 정확히 7초만에 도착하는 경로들의 예시.

예를 들어서 준우가 (1,2)의 위치에 정확히 7초 후에 도착하기를 예약했다고 가정해보자. 이 경우 로봇 청소기는 위의 예시와 같은 경로로 이동하여 7초 후에 목적지에 도착 할 수 있다. 하지만 해당 위치에 정확히 1,2초 후에는 도착할 수 있는 방법이 없다. 물론 정확히 8초 후에 도착하는 방법도 존재하지 않는다.

<입력>

첫째 줄에 테스트케이스의 수를 나타내는 T가 주어진다.
다음 T개의 줄에는 X, Y, N이 공백을 두고 주어진다.

· 1 <= N <= 10
· -10^9 <= X, Y <= 10^9
· 1 <= N <= 2 * 10^9
· 주어지는 모든 수는 정수이다.

<출력>

각 테스트케이스에 대한 정답을 차례로 한 줄씩 출력한다.

· 정확히 N초 후에 로봇 청소기가 (X, Y)좌표에 도착할 수 있다면 YES를 출력한다.
· 그렇지 않다면 NO를 출력한다.

<입/출력 예시>
입력
4
-5 -2 7
5 -5 2
0 5 6
1 2 7

출력
YES
NO
NO
YES
*/
