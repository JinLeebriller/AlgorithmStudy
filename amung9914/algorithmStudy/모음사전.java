import java.util.*;
class Solution {
    
    static List<String> list = new ArrayList<>();
    static String[] arr = {"A","E","I","O","U"};
    
    public int solution(String word) {
        dfs("",0);
        return list.indexOf(word);
    }

    static void dfs(String str,int length){
        if(length>5)
            return;
        list.add(str);
        for (int i = 0; i < 5; i++) {
             dfs(str+arr[i], length+1);

        }

    }
}
