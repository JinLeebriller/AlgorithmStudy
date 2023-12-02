https://devlog-wjdrbs96.tistory.com/245

https://st-lab.tistory.com/216

처음에 접근을 배열을 쓰면 될거 같아서 
배열로 써서 새 배열로 만드는 식으로 해봤는데 안되길래 검색을 해봤더니 이해가 안가는거에요 그래서
회전하는 큐(quque) 이해를 위한 ArrayDeque 찾아봤어요 근데 무슨소린지 모르겠어요
일단 출력문대로 되긴 되는데 이거 어디서 나온 문제인가요 왜캐 어려움;;

잠시 커밋을 위한 글을 씁니다

package suseok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 회전하는_큐 {

	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static int count = 0;
	static LinkedList<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int[] temp = new int[M];
		for(int i = 0 ; i < M ; i++)
			temp[i] = Integer.parseInt(st.nextToken());

		for(int i = 1 ; i <= N ; i++)
			q.add(i);

		for(int i = 0 ; i < M ; i++) {

			if(check(temp[i])) {
				while(temp[i]!=q.get(0)) {
				q.addLast(q.pollFirst());
				count++;
				}
			}else {
				while(temp[i]!=q.get(0)) {
				q.addFirst(q.pollLast());
				count++;
				}
			}

			q.poll();
		}

		System.out.println(count);

		}

	public static boolean check(int a) {

		for(int i = 0 ; i <= q.size()/2 ; i++) {
			if(a == q.get(i))
				return true;
		}

		return false;
	}

}
