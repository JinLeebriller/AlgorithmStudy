package algorithm;

import java.util.LinkedList;
import java.util.Scanner;

public class 회전하는큐 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for(int i=1; i<=n; i++) {
			queue.add(i);
		}
		int cnt = sc.nextInt();
		int answer = 0;
		for(int i=0; i<cnt; i++) {
			int x = sc.nextInt();
			boolean direction = queue.size() % 2 == 0 ? ((queue.size() / 2)-1 >= queue.indexOf(x)) : ((queue.size() / 2) >= queue.indexOf(x));
			if(direction) {
				for(int j=0; j<queue.size(); j++) {
					int tmp = queue.pollFirst();
					if(tmp == x) break;
					queue.offerLast(tmp);					
					answer++;
				}
			}else {
				for(int j=0; j<queue.size(); j++) {
					int tmp = queue.pollLast();
					queue.offerFirst(tmp);
					answer++;
					if(queue.peek() == x) {queue.poll(); break;}
				}
			}
		}
		System.out.println(answer);
	}
}