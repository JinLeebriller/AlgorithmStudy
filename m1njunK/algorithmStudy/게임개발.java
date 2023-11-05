import java.util.Scanner;

public class 게임개발 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// 가로
		int N = sc.nextInt();
		// 세로
		int M = sc.nextInt();
		
		// x좌표
		int A = sc.nextInt();
		// y좌표
		int B = sc.nextInt();
		// 시작방향
		int d = sc.nextInt();
		
		// 가로x세로 길이의 배열
		int map[][] = new int[N][M];
		int visit[][] = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// 시작위치
		visit[A][B] = 1;
		
		// 회전하였을때 탐색할 배열의 인덱스 조절을 위함
		// ex) 시작위치 : map[1][1]; 바라보는 방향 : d == 0; 
		// -> 회전 후 : map[1+A2[d]][1+B2[d]] == map[0][1]
		int A2[] = {-1,0,1,0};
		int B2[] = {0,1,0,-1};
		
		int answer = 1;
		// 회전 카운트
		int cnt = 0;
		// while문 탈출 flag
		boolean flag = true;
		
		while(flag) {
			// 반시계 방향으로 회전
			d -= 1;
			d = (d == -1) ? 3 : d;
			
			// 회전후 탐색할 인덱스 지정
			int NA = A + A2[d];
			int NB = B + B2[d];
			
			// 탐색한 위치가 육지 && 방문하지 않았을경우
			if(map[NA][NB] == 0 && visit[NA][NB] == 0) {
				// 방문 위치 저장
				visit[NA][NB] = 1;
				// 현재 위치 저장
				A = NA;
				B = NB;
				answer++;
				cnt = 0;
			}else {
				cnt++;
				// 회전 횟수가 4가 된 경우
				if(cnt == 4) {
					// 뒤로 이동 시키기 위함
					NA = A-A2[d];
					NB = B-B2[d];
					// 뒤로 이동 가능한 경우
					if(map[NA][NB]==0) {
						A = NA;
						B = NB;
						cnt = 0;
					}else flag = false;
				}
			}
		}
		System.out.println(answer);
	}
}
