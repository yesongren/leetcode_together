package didi.math;

class Solution {

    private StringBuffer result = new StringBuffer();
    private LinkedHashMap<Integer,String> pair = pairs();

    public String intToRoman(int num) {
        if (num < 1 && num > 3999) return "";
        int key = 0;

        while(num > 0) {
            for (Integer i : pair.keySet()){
                if (num >= i){
                    num -= i;
                    result.append(pair.get(i));
                    break;
                }
            }
        }

        return result.toString();
    }

    private LinkedHashMap<Integer,String> pairs() {
        LinkedHashMap<Integer,String> pair = new LinkedHashMap<>();
        pair.put(1000,"M");
        pair.put(900,"CM");
        pair.put(500,"D");
        pair.put(400,"CD");
        pair.put(100,"C");
        pair.put(90,"XC");
        pair.put(50,"L");
        pair.put(40,"XL");
        pair.put(10,"X");
        pair.put(9,"IX");
        pair.put(5,"V");
        pair.put(4,"IV");
        pair.put(1,"I");
        return pair;
    }
}