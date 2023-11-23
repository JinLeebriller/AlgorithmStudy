import java.util.ArrayList;
import java.util.List;

public class SixToSeven {
    // 함수안쓰고 푸는 버전
    public static void main(String[] args){
        String answer = "";
        String s = "98451984614487541689572165421";
        String temp = "";
        char[] arr = s.toCharArray();
        boolean b = false;
        for(int i = 0; i< arr.length; i++){
            if(arr[i]=='6'){
                b = true;
            }
            if(b){
                temp += arr[i];
            }
            if(arr[i]=='7'||i==arr.length-1){
                if(answer.equals("")){
                    answer += temp;
                }else{
                    answer += "    " + temp;
                }
                temp = "";
                b = false;
            }
        }
        System.out.println(answer);
    }
    
    /* 함수 쓰고 푼 버
    public static void main(String[] args){
        List<String> answerList = new ArrayList<>();
        String s = "98451984614487541689572165421";
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        boolean b = false;
        for(int i = 0; i< arr.length; i++){
            if(arr[i]=='6'){
                b = true;
            }
            if(b){
                sb.append(arr[i]);
            }
            if(arr[i]=='7'||i==arr.length-1){
                answerList.add(sb.toString());
                sb = new StringBuilder();
                b = false;
            }
        }
        for(String str : answerList){
            System.out.print(str+"  ");
        }
    }
    */
}
