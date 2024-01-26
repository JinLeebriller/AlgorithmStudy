public class Key {
    static public boolean solution(int[][] key, int[][] lock) {
        int keyLength = key.length;
        int lockLength = lock.length;

        int[][] newLock = new int[lock.length+ (key.length*2)-2][lock.length+ (key.length*2)-2];
        // lock 복사(확대)
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock[i].length; j++) {
                newLock[key.length-1+i][key.length-1+j] = lock[i][j];
            }
        }

        boolean answer = false;

        // 옆으로 돌고 하나씩 내려간다
        root : for (int l = 0; l < 4; l++) {
            key = turn(key);
            for (int m = 0; m < newLock.length-key.length+1; m++) { // 아래로 보냄
                for (int k = 0; k < newLock.length-key.length+1; k++) { //옆으로 보냄
                    
                    int[][] newKey = new int[newLock.length][newLock.length];
                    
                    // newKey에 복사
                    for (int i = 0; i < key.length; i++) {
                        for (int j = 0; j < key.length; j++) {
                            newKey[i+m][j+k] = key[i][j];
                        }
                        // 검증
                        if(match(newLock, newKey, keyLength, lockLength)){
                            answer=true;
                            break root;
                        }
                    }
                }
            }
        }
        return answer;
    }

    // 검증하는 함수
    private static boolean match(int[][]newLock, int[][] newKey,int keyLength,int lockLength){
        boolean answer = true;
        for (int i = keyLength-1; i < keyLength-1+ lockLength; i++) {
            for (int j = keyLength-1; j <keyLength-1+ lockLength; j++) {
                if(newLock[i][j]+newKey[i][j]!=1){
                    answer=false;
                    break;
                }
            }
        }
        return answer;
    }

    // 시계방향으로 돌린다
    private static int[][] turn(int[][] key) {
        int[][] newArr = new int[key.length][key[0].length];
        int max = key.length-1;
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[i].length; j++) {
                newArr[j][max-i] = key[i][j];
            }
        }
        return newArr;

    }

    public static void main(String[] args) {
        int[][] key = {{0, 0, 0},
                {1, 0, 0},
                {0, 1, 1}};
        int[][] lock = {{1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}};

        System.out.println(solution(key,lock));
    }
}
