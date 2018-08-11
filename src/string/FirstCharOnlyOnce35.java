package string;

import java.util.HashMap;

public class FirstCharOnlyOnce35 {
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0)
            return -1;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] cs = str.toCharArray();
        for(char c: cs){
            if(map.containsKey(c))
                map.put(c, map.get(c)+1);
            else
                map.put(c, 1);
        }
        for(int i=0; i<cs.length; i++){
            if(map.get(cs[i]) == 1)
                return i;
        }
        return -1;
    }
}
