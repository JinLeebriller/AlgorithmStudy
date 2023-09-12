public static String solution(int n){

        String answer = "";
        StringBuilder sb = new StringBuilder();

        while(n > 0){

            int mod = n % 3;
            n /= 3;

            if(mod == 0){
                sb.append("4");
                n -= 1;
            }else{
                sb.append(mod);
            }
        }
        answer = sb.reverse().toString();
        return answer;
}