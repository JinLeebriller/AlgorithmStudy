/*
5명의 사람들이 가위바위보게임을 진행했을 때 몇 명의 사람이 승리하는 지 판단하는 프로그램을 작성해보자.

입력 형식
다섯 명의 참가자에 대한 정보를 나타내는 공백으로 구분 된 다섯개의 자연수가 A B C D E형식으로 주어진다.

A, B, C, D, E는 5명의 참가자에 대한 선택 결과를 나타낸다.
1인 경우 가위를 선택한 것을 의미한다.
2인 경우 바위를 선택한 것을 의미한다.
3인 경우 보를 선택한 것을 의미한다.

출력 형식
참가자들의 선택 결과대로 가위바위보을 수행하였을 때 승리하는 사람들의 수를 공백없이 한 줄에 출력하시오.

예시 1 )

입력
11331

출력
3

예시 2 )

입력
23223

출력
2

예시 3 )

입력
22222

출력
0 

++

한 명의 최종 승자가 결정될 때까지 계속 진행 되며 패배한 인원은 입력에서 제외된다.
이후 최종 승자가 탄생하면 총 시행 횟수와 최종 승자를 표시하시오.
*/

import java.util.*;

public class Main2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> map = new HashMap<>();
            map.put("A",0);
            map.put("B",0);
            map.put("C",0);
            map.put("D",0);
            map.put("E",0);
        List<String> winners = new ArrayList<>();
        int result = 0;
        int count = 0;
        do {
            System.out.println(map.size()+"개 입력해주세요");
            ++count;
            if(map.containsKey("A")){
                System.out.print("A의 값 : ");
                map.put("A",scanner.nextInt());
            }
            if(map.containsKey("B")){
                System.out.print("B의 값 : ");
                map.put("B",scanner.nextInt());
            }
            if(map.containsKey("C")){
                System.out.print("C의 값 : ");
                map.put("C",scanner.nextInt());
            }
            if(map.containsKey("D")){
                System.out.print("D의 값 : ");
                map.put("D",scanner.nextInt());
            }
            if(map.containsKey("E")){
                System.out.print("E의 값 : ");
                map.put("E",scanner.nextInt());
            }

            winners = game(map);
            map = new HashMap<>();
            for(String s : winners){
                map.put(s,0);
            }
        System.out.println();
        System.out.println("승리자는 : "+winners.toString()+","+winners.size()+"명");
        }while(winners.size()!=1);
        System.out.println("최종 승리자는 "+winners.toString());
        System.out.println("총 시행횟수 : "+count);
    }

    static List<String> game(Map<String,Integer> list){
        System.out.println("Main.game");
        int win = 0;

        if(list.containsValue(1)&&list.containsValue(2)&&list.containsValue(3)){
            win = 0;
        }else if(list.containsValue(1)&&list.containsValue(2)){
            win = 2;
        }else if(list.containsValue(2)&&list.containsValue(3)){
            win = 3;
        }else if(list.containsValue(1)&&list.containsValue(3)){
            win = 1;
        }else {
            win = 0;
        }

        List<String> winners = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : list.entrySet()){
            if(entry.getValue()==win){

                winners.add(entry.getKey());
            }
        }
        return winners;
    }
}
