package practice;

// Given two strings s and t, determine if they are isomorphic.
// Two strings s and t are isomorphic if the characters in s can be replaced to get t.
// All occurrences of a character must be replaced with another character while preserving the order of characters.
// No two characters may map to the same character, but a character may map to itself.

// Example 1:
// Input: s = "egg", t = "add"
// Output: true
// Example 2:
// Input: s = "foo", t = "bar"
// Output: false
// Example 3:
// Input: s = "paper", t = "title"
// Output: true

// Constraints:
// 1 <= s.length <= 5 * 104
// t.length == s.length
// s and t consist of any valid ascii character.

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        // String s = "paper", t = "title";
        String s = "paper", t = "titlt";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character sChar = s.charAt(i);
            Character tChar = t.charAt(i);
            if (!map.containsKey(sChar) && !map.containsValue(tChar)) map.put(sChar, tChar);
            else {
                if (map.get(sChar) != tChar) return false;
                for (Map.Entry<Character, Character> entry : map.entrySet()) {
                    if (Objects.equals(tChar, entry.getValue()) && entry.getKey() != sChar) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
