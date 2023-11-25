package suseok;

public class 부분출력 {
	
    public static void main(String[] args) {
    	
        String number = "98451984614487541689572165421";

        boolean checkNumber = false;
        StringBuilder result = new StringBuilder();

        for (char compare : number.toCharArray()) {
            if (compare == '6') {
                if (checkNumber) {
                    System.out.print(result.toString());
                    result.setLength(0);
                }
                checkNumber = true;
            }

            if (checkNumber) {
                result.append(compare);
            }

            if (checkNumber && compare == '7') {
                System.out.print(result.toString());
                result.setLength(0);
                checkNumber = false;
            }
        }

        if (checkNumber) {
            System.out.print(result.toString());
        }
    }
}
