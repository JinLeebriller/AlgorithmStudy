import java.util.Arrays;
import java.util.Scanner;

public class Algorithm_10_5_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        String[][] map = new String[Integer.parseInt(input[0])][Integer.parseInt(input[1])];

        String[] startXYD = scan.nextLine().split(" ");
        int x = Integer.parseInt(startXYD[0]);
        int y = Integer.parseInt(startXYD[1]);
        int d = Integer.parseInt(startXYD[2]);

        for(int i=0; i<map.length; i++){
            map[i] = scan.nextLine().split(" ");
        }

        System.out.println("방문한 칸 수 : " + sol(x,y,d,map));
    }

    public static int sol(int x, int y, int d, String[][] map){
        int result = 1;
        int[] dx={0,1,0,-1};
        int[] dy={-1,0,1,0};

        int[] backX = {1,0,-1,0};
        int[] backY = {0,-1,0,1};

        int count = 0;

        while(true){
            int destX = x + dx[d%4];
            int destY = y + dy[d%4];
            count++;
            if(map[destX][destY].equals("0")){
                map[x][y] = "1";
                d = (d%4);
                x = destX;
                y = destY;
                result++;
                count = 0;
            }else{
                if(count < 4){
                    d = (d%4);
                }else{
                    if(map[x+backX[d]][y+backY[d]].equals("0")){
                        x = x+backX[d];
                        y = y+backY[d];
                    }else{
                        break;
                    }
                }
            }
            d++;
        }

        return result;
    }
}
