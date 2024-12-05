/* 
1. Two Sum

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 
approach way: there are 2 ways to solve this problem
              1- use 2 loops, the first loop, from the 1st loop we take a digit 
                 and from the 2nd loop we take each i+1 digit, if the sum of digit ith pos and jth position = target then we have our solution else we should take another number.  
              2- we can also reach the solution with one loop O(n)
*/

import java.util.*;

class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i <= nums.length; ++i) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    // Optimierte Loesung 2: das eingegebene Array muss dafür sortiert sein.
    public int[] twoSumSorted(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[] { left, right };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum a = new TwoSumS();
        int[] erg = a.twoSum(new int[] { 2, 7, 11, 15 }, 9);
        System.out.println(Arrays.toString(erg));
    }
}