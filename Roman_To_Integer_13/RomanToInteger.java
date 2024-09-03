package Roman_To_Integer_13;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));      // Output: 3
        System.out.println(romanToInt("LVIII"));    // Output: 58
        System.out.println(romanToInt("MCMXCIV"));  // Output: 1994
    }
    public static int romanToInt(String s) {
        Map<Character,Integer> romanToInt= new HashMap<>();
        romanToInt.put('I',1);
        romanToInt.put('V',5);
        romanToInt.put('X',10);
        romanToInt.put('L',50);
        romanToInt.put('C',100);
        romanToInt.put('D',500);
        romanToInt.put('M',1000);

        int total = 0;

        for (int i = 0; i < s.length(); i++){
            int currentValue = romanToInt.get(s.charAt(i));

            if (i+1 < s.length() && romanToInt.get(s.charAt(i+1)) > currentValue){
                total -= currentValue;
            } else {
                total += currentValue;
            }
        }
        return total;
    }
}