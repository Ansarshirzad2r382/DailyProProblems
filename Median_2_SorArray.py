'''
Median of 2 Arrays:

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

'''
from typing import List

class Median_2_SorArray:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        return self.Median(nums1, nums2)

    def Median(self, nums1, nums2):
        i = 0
        j = 0
        count = 0
        m1 = m2 = 0
        size = len(nums1) + len(nums2)
        while count < size // 2 + 1:
            m2 = m1
            if i < len(nums1) and j < len(nums2):
                if nums1[i] <= nums2[j]:
                    m1 = nums1[i]
                    i += 1
                else:
                    m1 = nums2[j]
                    j += 1
            elif i < len(nums1):
                m1 = nums1[i]
                i += 1
            elif j < len(nums2):
                m1 = nums2[j]
                j += 1
            count += 1

        if size % 2 == 0:
            return (m1 + m2) / 2
        else:
            return m1

    
nums1 = [1, 3]
nums2 = [2]

   
findMedian = Median_2_SorArray()

   
result = findMedian.findMedianSortedArrays(nums1, nums2)
print(f"Median von den 2 Arrays ist: {result}")
