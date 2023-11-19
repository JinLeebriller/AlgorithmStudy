package algorithmStudy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static int n;
    static int answer = -(int)Math.pow(2,31);
    static ArrayList<Integer> nums = new ArrayList<>();
    static ArrayList<Character> ops = new ArrayList<>();

    public static int cal(int a,int b,char op){
        if(op=='+') return a+b;
        else if(op=='-') return a-b;
        else return a*b;
    }

    public static void dfs(int idx,int curSum){
        if(idx==ops.size()){
            answer = Math.max(answer,curSum);
        }
        else{
            dfs(idx+1,cal(curSum,nums.get(idx+1),ops.get(idx)));
            if(idx+2 <=ops.size())
                dfs(idx+2,cal(curSum,cal(nums.get(idx+1),nums.get(idx+2),ops.get(idx+1)),ops.get(idx)));
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = Integer.parseInt(sc.nextLine());
        for(char c : sc.nextLine().toCharArray()){
            if(c>='0' && c<='9') nums.add(Character.getNumericValue(c));
            else ops.add(c);
        }

        dfs(0,nums.get(0));
        System.out.println(Integer.toString(answer)+'\n');

        sc.close();
    }
}