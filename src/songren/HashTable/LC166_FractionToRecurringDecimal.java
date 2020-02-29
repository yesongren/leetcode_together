package songren.HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yesongren on 2020/3/1
 * 166. Fraction to Recurring Decimal
 */
public class LC166_FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0)
            return 0+"";
        StringBuilder sb = new StringBuilder();
        if((numerator > 0) != (denominator > 0))
            sb.append("-");
        long num1 = numerator;
        long num2 = denominator;
        num1 = Math.abs(num1);
        num2 = Math.abs(num2);
        long result = num1/num2;
        long remain = num1%num2;
        sb.append(result);
        if(remain == 0)
            return sb.toString();
        sb.append(".");
        Map<Long,Integer> map = new HashMap<>();
        while(remain != 0){
            num1 = remain*10;
            result = num1/num2;
            if(!map.isEmpty() && map.containsKey(remain)){
                sb.insert(map.get(remain),"(");
                sb.append(")");
                break;
            }
            map.put(remain,sb.length());
            remain = num1%num2;
            sb.append(result);
        }
        return sb.toString();
    }
}
