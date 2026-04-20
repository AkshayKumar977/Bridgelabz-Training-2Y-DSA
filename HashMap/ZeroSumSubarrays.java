import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZeroSumSubarrays {
    public List<int[]> findSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        int sum = 0;
        
        List<Integer> initial = new ArrayList<>();
        initial.add(-1);
        map.put(0, initial);
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            
            if (map.containsKey(sum)) {
                List<Integer> list = map.get(sum);
                for (int start : list) {
                    result.add(new int[]{start + 1, i});
                }
            }
            
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
        
        return result;
    }
}
