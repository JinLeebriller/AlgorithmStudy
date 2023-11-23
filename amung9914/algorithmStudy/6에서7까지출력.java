import java.util.ArrayList;
import java.util.List;

public class SixToSeven {
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
}
