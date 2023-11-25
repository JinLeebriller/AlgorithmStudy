
// 부분출력 왜이렇게 어렵나요
package suseok;

public class 부분출력 {
	
    public static void main(String[] args) {
    	
        String number = "98451984614487541689572165421";

        boolean checkNumber = false;

        for (char compare : number.toCharArray()) {
        	
        	// 처음 조건 6
            if (compare == '6') {
            	checkNumber = true;
            }
            
            if (checkNumber) {
                System.out.print(compare);
            }

            // 마지막 조건 7
            if (checkNumber && compare == '7') {
            	checkNumber = false;
            }
        }
    }
}
