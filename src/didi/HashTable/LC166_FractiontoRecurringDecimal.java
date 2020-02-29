package didi.HashTable;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder sb = new StringBuilder();

        if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) {
            sb.append("-");
        }

        long dividend = Math.abs((long) numerator);
        long divisor = Math.abs((long) denominator);

        long quotient = dividend / divisor;
        long remainder = dividend % divisor;
        sb.append(quotient);

        if (remainder == 0) return sb.toString();

        sb.append(".");
        HashMap<Long, Integer> map = new HashMap<>();

        while (remainder != 0) {
            if (map.containsKey(remainder)){
                sb.insert(map.get(remainder),"(");
                sb.append(")");
                break;
            }
            map.put(remainder, sb.length());
            remainder *= 10;
            quotient = remainder / divisor;
            sb.append(quotient);
            remainder = remainder % divisor;
        }

        return sb.toString();
    }
}