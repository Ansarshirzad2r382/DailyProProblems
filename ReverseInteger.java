public class ReverseInteger {

/*
Reverse Integer

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.


Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21

 */


    public int reverse(int x) {
        int erg = 0;

        // Negative bereich uberprufen, da wir sonst im variable "erg" auf falsche Ergebnisse kommen. 
        if (x < 0) {
            x = Math.abs(x); 

            while (x > 0) {
                int mod = x % 10; 
                erg = erg * 10 + mod; 
                x /= 10; 
            }
            return (-erg >= Integer.MIN_VALUE) ? -erg : 0;
        }

        while (x > 0) {
            int mod = x % 10; 
            erg = erg * 10 + mod; 
            x /= 10; 
        }
    
        return (erg <= Integer.MAX_VALUE) ? erg : 0;
    }
    public static void main(String[] args){
        ReverseInteger a = new ReverseInteger();
        int erg = a.reverse(123);
        System.out.println(erg); // 321
    }
}
