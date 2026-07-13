class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        s_sorted = "".join(sorted(s))
        t_sorted = "".join(sorted(t))
        
        for i in range(len(s_sorted)):
            if s_sorted[i] != t_sorted[i]:
                return False
                
        return True