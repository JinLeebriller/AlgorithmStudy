import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test11052 {
    public static void main(String[] args) {
        int count = 1;
        // 서, 남, 동, 북
        // 3   2   1  0
        List<Integer> direction = new ArrayList<>();
        for(int i = 3; i>=0;i--)
            direction.add(i);
        int[] dx = {0,1,0,-1};
        int[] dy = {-1,0,1,0};

        Scanner scanner = new Scanner(System.in);
        int maxX = scanner.nextInt();
        int maxY = scanner.nextInt();
        //캐릭터 위치
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        //캐릭터 방향
        int dir = scanner.nextInt();

        // 북인경우 index = 3 -> index0부터 시작하게함
        // 3 - 3 = 0
        // 1 - 3 = 2
        int startIndex = (direction.indexOf(dir)+1)%4; // 왼쪽방향

        // 지도 입력 받기
        int map[][] = new int[maxX][maxY];
        for(int i=0; i<maxX; i++){
            for(int j=0; j<maxY; j++){
                map[i][j]=scanner.nextInt();
            }
        }
        
        // 시작점 표시
        map[x][y]=1;
        boolean flag = true;
        while(flag){
            //왼쪽방향돌리기
            for(int i = startIndex; i<startIndex+4;i++){
                int nextX = x+dx[i%4];
                int nextY = y+dy[i%4];
                //전진한다
                if(map[nextX][nextY]==0){
                    x = nextX;
                    y = nextY;
                    dir = i%4;
                    startIndex = (i+1)%4;
                    map[x][y]=1;
                    count++;
                }
            }
            // 네방향 모두 1일때 바라보는 방향을 유지한채로 한칸 뒤로 간다
            int back = (direction.indexOf(dir)+2)%4;
            int backX = x+dx[back%4];
            int backY = y+dy[back%4];

            if(map[backX][backY]==0){
                x = backX;
                y = backY;
                map[x][y]=1;
                count++;

            }else{
                flag=false;
            }
        }
        System.out.println(count);
    }
}
