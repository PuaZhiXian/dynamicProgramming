import java.util.HashMap;
import java.util.Map;

public class No169 {
    public static void main(String[] args) { 
        No169 o = new No169(); 
    }

    public int majorityElement(int[] nums) {

        Map<Integer,Integer> map= new HashMap<>();

        for (int i :nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        int max =0;
        int a=0;

        for (Map.Entry<Integer,Integer>e:map.entrySet()){
            if (max<e.getValue()){
                max=e.getValue();
                a=e.getKey();

            }
        }
        return a;
    }
} 
