import java.util.ArrayList;
public class Cache {
    public static void main(String[] args) {
        int cacheSize = 2;
        String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};
        int i = solution(cacheSize, cities);
        System.out.println(i);
    }
    static int solution(int cacheSize, String[] cities){
        int totalTime = 0;
        ArrayList<String> list = new ArrayList<String>();

        if(cacheSize==0){
            return 5* cities.length;
        }
        if(list.isEmpty()){
            list.add(cities[0].toLowerCase());
            totalTime +=5;
        }
        for(int i=1; i< cities.length; i++){
            if(!list.contains(cities[i].toLowerCase())){
                // cache miss
                if(list.size()==cacheSize){
                    list.remove(0);
                }
                list.add(cities[i].toLowerCase());
                totalTime+=5;
            }else{
                // cache hit
                list.remove(list.indexOf(cities[i].toLowerCase()));
                list.add(cities[i].toLowerCase());
                totalTime++;
            }

        }
        return totalTime;
    }

}
