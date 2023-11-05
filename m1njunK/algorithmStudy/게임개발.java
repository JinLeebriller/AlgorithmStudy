import java.util.Scanner;

public class 게임개발 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int d = sc.nextInt();
		
		int map[][] = new int[N][M];
		int visit[][] = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		visit[A][B] = 1;
		
		int A2[] = {-1,0,1,0};
		int B2[] = {0,1,0,-1};
		
		int answer = 1;
		int cnt = 0;
		boolean flag = true;
		while(flag) {
			d -= 1;
			d = (d == -1) ? 3 : d;
			
			int NA = A + A2[d];
			int NB = B + B2[d];
			
			if(map[NA][NB] == 0 && visit[NA][NB] == 0) {
				visit[NA][NB] = 1;
				A = NA;
				B = NB;
				answer++;
				cnt = 0;
			}else {
				cnt++;
				if(cnt == 4) {
					NA = A-A2[d];
					NB = B-B2[B];
					if(map[NA][NB]==0) {
						A = NA;
						B = NB;
					}else flag = false;
				}
			}
		}
		System.out.println(answer);
	}
}
