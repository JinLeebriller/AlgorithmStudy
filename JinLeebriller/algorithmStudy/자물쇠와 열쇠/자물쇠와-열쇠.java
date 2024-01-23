package algorithmStudy;

public class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        // lock보다 세 배 큰 이차원 배열의 중앙에 lock 삽입
        int[][] scaledLock = new int[lock.length * 3][lock.length * 3];

        for (int i = lock.length, j = 0; i < lock.length * 2; i++, j++) {
            for (int k = lock.length, l = 0; k < lock.length * 2; k++, l++) {
                scaledLock[i][k] = lock[j][l];
            }
        }

        // scaledLock 이차원 배열을 순회하며 key 회전시켜 검증
        int column = 0;
        int row = 0;

        for(int i = 0 ; i < 4 ; i++) {
            key = rotate(key);
            for(int j = column, k = 0 ; k < key.length ; j++, k++) {
                for(int l = row, t = 0 ; t < key.length ; l++, t++) {
                    scaledLock[j][l] += key[k][t];
                }
            }
            if(isOpen(scaledLock, lock.length)) {
                return true;
            } else {
                for(int j = column, k = 0 ; k < key.length ; j++, k++) {
                    for(int l = row, t = 0 ; t < key.length ; l++, t++) {
                        scaledLock[j][l] -= key[k][t];
                    }
                }
            }
            if(i == 3) {
                row++;
                if(row == lock.length * 2) {
                    row = 0;
                    column++;
                    if(column == lock.length * 2) {
                        return false;
                    }
                }
                i = -1;
            }
        }

        return false;
    }

    // key를 회전시키는 메서드
    int[][] rotate(int[][] key) {
        int[][] answer = new int[key.length][key.length];

        for (int i = 0; i < key.length; i++) {
            for (int j = 0, k = key.length - 1; j < key.length; j++, k--) {
                answer[i][j] = key[k][i];
            }
        }

        return answer;
    }

    // key로 lock을 열 수 있는지 확인하는 메서드
    boolean isOpen(int[][] scaledLock, int lockLength) {
        for (int i = lockLength ; i < lockLength * 2 ; i++) {
            for (int j = lockLength ; j < lockLength * 2; j++) {
                if (scaledLock[i][j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }
}