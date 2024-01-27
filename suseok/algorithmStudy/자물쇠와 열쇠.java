// M인 key와 N인 lock을 2차원 배열로 나타내며
// lock을 key로 칸을 맞춰 푸는 문제
// 0과 1로 표시를 하며 맞을경우 true 아니면 false를 return하게 됨
// 0은 비어있는 홈이고 1은 채워져있는 돌기를 뜻함
// M은 N보다 항상 작다

package suseok;

public class 자물쇠와_열쇠 {
    
    public static boolean solution(int[][] key, int[][] lock) {
    	
        int M = key.length;
        int N = lock.length;
        int field = N + (M - 1) * 2;  // 자물쇠보다 2*(M-1) 크게 설정

        // 4번 회전하면서 확인
        for (int rotate = 0; rotate < 4; rotate++) {
            key = rotate(key);
            for (int i = 0; i < field - M + 1; i++) {
                for (int j = 0; j < field - M + 1; j++) {
                    if (check(i, j, key, lock, field)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static int[][] rotate(int[][] key) {
        int M = key.length;
        int[][] rotateKey = new int[M][M];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                rotateKey[i][j] = key[M - 1 - j][i];
            }
        }

        return rotateKey;
    }

    private static boolean check(int y, int x, int[][] key, int[][] lock, int field) {
        int[][] move = new int[field][field];

        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
            	move[y + i][x + j] += key[i][j];
            }
        }

        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
            	move[i + key.length - 1][j + key.length - 1] += lock[i][j];
                if (move[i + key.length - 1][j + key.length - 1] != 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        boolean result = solution(key, lock);
        System.out.println(result);
    }
}




