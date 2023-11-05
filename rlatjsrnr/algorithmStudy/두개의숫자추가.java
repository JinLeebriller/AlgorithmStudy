import java.util.ArrayList;

public class Algorithm_10_5_1 {
    public static void main(String[] args) {
        int[] l1 = {2,4,3};
        int[] l2 = {5,6,4};

        int[] l3 = {0};
        int[] l4 = {0};

        int[] l5 = {9,9,9,9,9,9,9};
        int[] l6 = {9,9,9,9};

        ArrayList<Integer> result1 = sol(l1, l2);
        System.out.println(result1);
        ArrayList<Integer> result2 = sol(l3, l4);
        System.out.println(result2);
        ArrayList<Integer> result3 = sol(l5, l6);
        System.out.println(result3);
    }

    public static ArrayList<Integer> sol(int[] a, int[] b){
        ArrayList<Integer> result = new ArrayList<>();
        int[] max;
        int[] min;

        if(a.length>=b.length){
            max = a;
            min = b;
        }else{
            max = b;
            min = a;
        }

        int carry = 0;
        for(int i = 0; i < min.length; i++){
            int sum = min[i] + max[i] + carry;
            carry = sum > 9 ? 1 : 0;
            if(sum>9) sum -= 10;
            result.add(sum);
        }

        for(int i=min.length; i<max.length; i++){
            int sum = max[i] + carry;
            carry = sum > 9 ? 1 : 0;
            if(sum>9) sum -= 10;
            result.add(sum);
        }

        if(carry == 1) result.add(1);
        return result;
    }
}
