------------------------------------------------------------------------------------
파이썬

def solution(lottos, win_nums):
    # 당첨 번호와 로또 번호에서 일치하는 숫자 개수를 계산하는 함수
    def count_match(lottos, win_nums):
        count = 0
        for num in lottos:
            if num in win_nums:
                count += 1
        return count

    # 최고 순위와 최저 순위 계산
    max_match = count_match(lottos, win_nums)
    
    # 0의 개수를 고려하여 최저 순위 계산
    min_match = count_match(lottos, win_nums)
    min_match += lottos.count(0)

    # 순위 변환
    def convert_rank(match):
        if match == 6:
            return 1
        elif match == 5:
            return 2
        elif match == 4:
            return 3
        elif match == 3:
            return 4
        elif match == 2:
            return 5
        else:
            return 6

    max_rank = convert_rank(max_match)
    min_rank = convert_rank(min_match)

    return [min_rank, max_rank]

------------------------------------------------------------------------------------
자바

class Solution {
    // 당첨 번호와 로또 번호에서 일치하는 숫자 개수를 계산하는 함수
    private int countMatch(int[] lottos, int[] win_nums) {
        int count = 0;
        for (int num : lottos) {
            for (int winNum : win_nums) {
                if (num == winNum) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        // 최고 순위와 최저 순위 계산
        int maxMatch = countMatch(lottos, win_nums);
        int minMatch = countMatch(lottos, win_nums);

        // 0의 개수를 고려하여 최저 순위 계산
        for (int num : lottos) {
            if (num == 0) {
                minMatch++;
            }
        }

        // 순위 변환
        int maxCnt = (maxMatch == 0) ? 6 : 7 - maxMatch;
        int minCnt = (minMatch == 0) ? 6 : 7 - minMatch;

        int[] answer = {minCnt, maxCnt};
        return answer;
    }
}



