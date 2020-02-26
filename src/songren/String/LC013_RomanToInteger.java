package songren.String;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yesongren on 2020/2/27
 * 13. Roman to Integer
 */
public class LC013_RomanToInteger {
    public Map<Character,Integer> map = new HashMap<Character,Integer>(){
        {
        put('M',1000);
        put('D',500);
        put('C',100);
        put('L',50);
        put('X',10);
        put('V',5);
        put('I',1);
        }
    };

    public int romanToInt(String s) {
        int sum = 0;
        for(int i = 0;i < s.length();i++){
            if(i+1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                sum += map.get(s.charAt(i+1))-map.get(s.charAt(i));
                i++;
            }else{
                sum += map.get(s.charAt(i));
            }
        }
        return sum;
    }
}
