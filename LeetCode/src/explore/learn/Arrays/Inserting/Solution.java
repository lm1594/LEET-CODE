package explore.learn.Arrays.Inserting;

import java.util.Arrays;

/**
 * LEET CODE
 *  - Explore.Learn.Arrays.Inserting Items Into Array
 * @author 이경민
 *
 */
public class Solution {
	
	/**
	 * Duplicate Zeros
	 *  - 문제: Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

		Note that elements beyond the length of the original array are not written.
		
		Do the above modifications to the input array in place, do not return anything from your function.
	 *
	 * Example 1:

		Input: [1,0,2,3,0,4,5,0]
		Output: null
		Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
	 * Example 2:
		
		Input: [1,2,3]
		Output: null
		Explanation: After calling your function, the input array is modified to: [1,2,3]
	 *
	 * Note:
		
		1 <= arr.length <= 10000
		0 <= arr[i] <= 9
	 *
	 * HINT
	 *  - This is a great introductory problem for understanding and working with the concept of in-place operations. The problem statement clearly states that we are to modify the array in-place. That does not mean we cannot use another array. We just don't have to return anything.
	 *  - A better way to solve this would be without using additional space. The only reason the problem statement allows you to make modifications in place is that it hints at avoiding any additional memory.
	 *  - The main problem with not using additional memory is that we might override elements due to the zero duplication requirement of the problem statement. How do we get around that?
	 *  - If we had enough space available, we would be able to accommodate all the elements properly. The new length would be the original length of the array plus the number of zeros. Can we use this information somehow to solve the problem?
	 */
	public static void duplicateZeros(int[] arr) {
        for(int i=0 ; i<arr.length ; i++) {
        	if (arr[i] == 0) {
        		for(int j=arr.length-1 ; j > i ; j--) {
        			arr[j] = arr[j-1];
        		}
        		i++;
        	}
        }
        
        for (int num : arr)
        	System.out.print(num + " ");
    }
	
	/**
	 * Merge Sorted Array
	 *  - 문제: Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

		The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.
	 *
	 * Example 1:

		Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
		Output: [1,2,2,3,5,6]
		
	 * Example 2:
		
		Input: nums1 = [1], m = 1, nums2 = [], n = 0
		Output: [1]
		 
		
	 * Constraints:
		
		nums1.length == m + n
		nums2.length == n
		0 <= m, n <= 200
		1 <= m + n <= 200
		-109 <= nums1[i], nums2[i] <= 109
	 * 
	 * HINT
	 *  - You can easily solve this problem if you simply think about two elements at a time rather than two arrays. We know that each of the individual arrays is sorted. What we don't know is how they will intertwine. Can we take a local decision and arrive at an optimal solution?
	 *  - If you simply consider one element each at a time from the two arrays and make a decision and proceed accordingly, you will arrive at the optimal solution.
	 */
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int j=0;
		for(int i=m ; i<m+n ; i++) {
        	nums1[i] = nums2[j++];
        }
        
		Arrays.sort(nums1);
    }
	
	
	public static void main(String[] args) {
		// Duplicate Zeros
		// int[] inputArr = {1,2,3};
		// duplicateZeros(inputArr);
		
		// Merge Sorted Array
		int[] nums1 = {1,2,3,0,0,0};
		int m = 3;
		int[] nums2 = {2,5,6};
		int n = 3;
		merge(nums1, m, nums2, n);
	}

}
