package algorithmStudy;

public class Solution {
    public static void main(String[] args) {
        char[] John = {'9', '8', '4', '5', '1', '9', '8', '4', '6', '1', '4', '4', '8', '7', '5', '4', '1', '6', '8', '9', '5', '7', '2', '1', '6', '5', '4', '2', '1'};
        boolean Paul = false;
        for(char George : John) {
            if(George == '6') Paul = true;
            if(Paul) System.out.print(George);
            if(Paul && George == '7') Paul = false;
        }
    }
}