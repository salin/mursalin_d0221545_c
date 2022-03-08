import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        boolean result = true;
        if(a==null||b==null||a.equals(" ")||b.equals(" ")){
            throw new IllegalArgumentException();
        }
        if(a.length()!=b.length()){
            return false;
        }else{
            a = a.toLowerCase();
            b = b.toLowerCase();
            
            java.util.Map<Character, Integer> mapA = new java.util.HashMap<>();
            java.util.Map<Character, Integer> mapB = new java.util.HashMap<>();
            
            
            for (int i=0;i<a.length();i++){
                char charA = a.charAt(i);
                char charB = b.charAt(i);
                
                //karakter A
                if(!mapA.containsKey(charA)){
                    mapA.put(charA, 1);
                }else{
                    Integer frekuensi = mapA.get(charA);
                    mapA.put(charA, ++frekuensi);
                }
                
                //karakter B
                if(!mapB.containsKey(charB)){
                    mapB.put(charB, 1);
                }else{
                    Integer frekuensi = mapB.get(charB);
                    mapB.put(charB, ++frekuensi);
                    
                }
            }
            
            //Bandingkan karakter dan frekuensi dan mapA dan mapB
            for(java.util.Map.Entry<Character, Integer>elemenA : mapA.entrySet()){
                char keyA = elemenA.getKey();
                int valueA = elemenA.getValue();
                if(!mapB.containsKey(keyA)){
                    return false;
                }else{
                    int valueB = mapB.get(keyA);
                    if(valueA != valueB){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {