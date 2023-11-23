public class SixToSeven {
    public static void main(String[] args) {

        String str = "98451984614487541689572165421";

        boolean flag = false;

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '6') flag = true;
            if(flag) System.out.print(str.charAt(i));
            if(str.charAt(i) == '7') flag = false;

        }
    }
}
