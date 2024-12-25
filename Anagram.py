class Anagram:
    '''
    Valid Anagram

    Given two strings s and t, return true if t is an 
    anagram
    of s, and false otherwise.

 

    Example 1:

    Input: s = "anagram", t = "nagaram"

    Output: true

    Example 2:

    Input: s = "rat", t = "car"

    Output: false
    
    Approach:
    Sort the Characters:
        The idea is to sort the characters in both strings, and then compare the sorted versions. If two words are anagrams, their sorted versions will be identical, because they contain the same characters in the same frequency.
    Comparison:
        Once the strings are sorted, simply compare them. If they are equal, the words are anagrams; otherwise, they are not.
    '''
    def isAnagram(self, s: str, t: str) -> bool:
        a = sorted(s)
        b = sorted(t)

        return a == b 
a = Anagram()
valid = a.isAnagram("bank", "kanb")

print(valid)