class PalindromeNumbers:
       def isPalindrome(self, x: int) -> bool:
        erg = 0 
        sp = x 
        while ( sp > 0):
            mod = sp % 10 
            erg  = erg * 10 + mod 
            sp//=10
        return erg == x 
obj = PalindromeNumbers()
a = obj.isPalindrome(121)
print(a)