package algorithmStudy;

// Q2. 선형 검색의 스캐닝 과정을 다음과 같이 자세히 출력하는 프로그램을 작성하세요.
/*
	   | 0 1 2 3 4 5 6
	---+----------------
	   | *
	  0| 6 4 3 2 1 9 8
	   |
	   |   *
	  1| 6 4 3 2 1 9 8
	   |
	   |     *
	  2| 6 4 3 2 1 9 8
	   |
	   |       *
	  3| 6 4 3 2 1 9 8
	그 값은 x[3]에 있습니다.
*/
public class Solution {
	
	static void seqSearch(int[] a, int num, int key) {
		int i = 0;
		
		System.out.print("   |");
		for(int y = 0 ; y < num ; y++) {
			System.out.printf("%2d", y);
		}
		System.out.println();
		System.out.println("---+----------------");
		
		while(true) {
			System.out.print("   |"); 
			for(int j = 0 ; j <= i ; j++) {
				if(j==0) System.out.print(" ");
				else System.out.print("  ");
			}
			System.out.println("*"); 
			System.out.printf("%3d|",i);
			
			for(int z = 0; z < num ; z++) {
				System.out.printf("%2d", a[z]);
			}
			System.out.println();
			
			if (a[i] == key) {
				System.out.println("그 값은 x[" + i +"]에 있습니다.");
				break;
			} else if (i == num) {
				System.out.println("그 값의 요소가 없습니다.");
				break;
			}
			i++;
			System.out.println("   |");
		}
	}
	
	public static void main(String[] args) {
		int[] a = {6, 4, 3, 2, 1, 9, 8};
		seqSearch(a, 7, 2);
	}
	
}
