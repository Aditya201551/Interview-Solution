/*
 Ques:
Input a string which contains substrings of repeated characters

aabbccddeeaa
print the most frequently occurring substring
aa
aabbaaaccbbaabb
bb

abcd
any character above(a or b or c or d)

aabcd
any character above(aa or b or c or d)
aa -1
b -1 
c-1
d-1
 */

/*
 * TEST CASES
 * [IN] aabbaaaccbbaabb
 * [OUT] bb
 * 
 * [IN] abcd
 * [OUT] a
 * 
 * [IN] aditya
 * [OUT] a
 * 
 * [IN] aabbccdd
 * [OUT] aa
 * 
 * [IN] aabbaaannneeennneeeneee
 * [OUT] eee
 * 
 * [IN] s
 * [OUT] s
 * 
 * [IN] ss
 * [OUT] ss
 */
import java.util.*;

public class Substr {
    String findRepeatingCharacter(String str) {
        if (str.length() == 0 || str.length() == 1)
            return str;
        str += '_';
        HashMap<String, Integer> map = new HashMap<>();
        char ch;
        String substr = "";
        for (int i = 0; i < str.length() - 1; i++) {
            ch = str.charAt(i);
            if (ch == str.charAt(i + 1))
                substr += ch;
            else {
                substr += ch;
                if (map.containsKey(substr))
                    map.put(substr, map.get(substr) + 1);
                else
                    map.put(substr, 1);

                substr = "";
            }
        }

        // map.forEach((key, value) -> System.out.println(key + " " + value));

        String maxKey = "";
        int maxFrequency = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        return maxKey;

    }

    public static void main(String[] args) {
        Substr ob = new Substr();
        System.out.println(ob.findRepeatingCharacter("ss"));
    }
}