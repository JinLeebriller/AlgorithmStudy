import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {

        HashMap<String,Integer> counter = new HashMap<>();
        for(String name:friends){
            counter.put(name,0);
        }
        
        HashMap<String,Integer> index = new HashMap<>();
        for(String name:friends){
            index.put(name,0);
        }
        
        HashMap<String,Integer> gift = new HashMap<>();
        for(String giftLog : gifts){
            if(gift.get(giftLog)==null){
                gift.put(giftLog,1);
            }else{
                gift.put(giftLog, gift.get(giftLog)+1);
            }
        }
        
        int len = friends.length;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                String fr1 = friends[i];
                String fr2 = friends[j];
                int fr1Cnt = 0;
                if(gift.get(fr1+" "+fr2) != null){
                    fr1Cnt = gift.get(fr1+" "+fr2);
                }
                int fr2Cnt = 0;
                if(gift.get(fr2+" "+fr1)!=null){
                    fr2Cnt = gift.get(fr2+" "+fr1);
                }
                
                int indexCnt = fr1Cnt-fr2Cnt;
                
                index.put(fr1, index.get(fr1)+indexCnt);
                index.put(fr2, index.get(fr2)-indexCnt);
            }
        }
           
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                String fr1 = friends[i];
                String fr2 = friends[j];
                int fr1Cnt = 0;
                if(gift.get(fr1+" "+fr2)!=null){
                    fr1Cnt = gift.get(fr1+" "+fr2);
                }
                int fr2Cnt = 0;
                if(gift.get(fr2+" "+fr1)!=null){
                    fr2Cnt = gift.get(fr2+" "+fr1);
                }
                
                if(fr1Cnt>fr2Cnt){
                    counter.put(fr1, counter.get(fr1)+1);
                }else if(fr1Cnt<fr2Cnt){
                    counter.put(fr2, counter.get(fr2)+1);
                }else{
                    if(index.get(fr1)>index.get(fr2)){
                        counter.put(fr1,counter.get(fr1)+1);
                    }else if(index.get(fr1)<index.get(fr2)){
                        counter.put(fr2, counter.get(fr2)+1);
                    }
                }
            }
        }
        int answer = 0;
        Set<String> keys = counter.keySet();
        Iterator<String> iter = keys.iterator();
        while(iter.hasNext()){
            String key = iter.next();
            if(counter.get(key)>answer) answer = counter.get(key);
        }
        
        
        return answer;
    }
}
