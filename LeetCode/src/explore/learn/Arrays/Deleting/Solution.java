package explore.learn.Arrays.Deleting;

/**
 * LEET CODE
 *  - Explore.Learn.Arrays.Deleting Items Into Array
 * @author 이경민
 *
 */
public class Solution {
	
	/**
	 * Remove Element
	 *  - 문제: Given an array nums and a value val, remove all instances of that value in-place and return the new length.

		Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
		
		The order of elements can be changed. It doesn't matter what you leave beyond the new length.
		
	 * Clarification:
		
		Confused why the returned value is an integer but your answer is an array?
		
		Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller as well.
		
		Internally you can think of this:
		
		// nums is passed in by reference. (i.e., without making a copy)
		int len = removeElement(nums, val);
		
		// any modification to nums in your function would be known by the caller.
		// using the length returned by your function, it prints the first len elements.
		for (int i = 0; i < len; i++) {
		    print(nums[i]);
		}
	 *
	 * Example 1:

		Input: nums = [3,2,2,3], val = 3
		Output: 2, nums = [2,2]
		Explanation: Your function should return length = 2, with the first two elements of nums being 2.
		It doesn't matter what you leave beyond the returned length. For example if you return 2 with nums = [2,2,3,3] or nums = [2,2,0,0], your answer will be accepted.
	 * Example 2:
		
		Input: nums = [0,1,2,2,3,0,4,2], val = 2
		Output: 5, nums = [0,1,4,0,3]
		Explanation: Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4. Note that the order of those five elements can be arbitrary. It doesn't matter what values are set beyond the returned length.
		 
		
	 * Constraints:
		
		0 <= nums.length <= 100
		0 <= nums[i] <= 50
		0 <= val <= 100
	 * 
	 * HINT
	 *  - The problem statement clearly asks us to modify the array in-place and it also says that the element beyond the new length of the array can be anything. Given an element, we need to remove all the occurrences of it from the array. We don't technically need to remove that element per-say, right?
	 *  - We can move all the occurrences of this element to the end of the array. Use two pointers!
	 *  - Yet another direction of thought is to consider the elements to be removed as non-existent. In a single pass, if we keep copying the visible elements in-place, that should also solve this problem for us.
	 */
	public static int removeElement(int[] nums, int val) {
		int index = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        
        return index;
    }
	
	/**
	 * Remove Duplicates from Sorted Array
	 *  - 문제: Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.

		Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
		
	 * Clarification:
		
		Confused why the returned value is an integer but your answer is an array?
		
		Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller as well.
		
		Internally you can think of this:
		
		// nums is passed in by reference. (i.e., without making a copy)
		int len = removeDuplicates(nums);
		
		// any modification to nums in your function would be known by the caller.
		// using the length returned by your function, it prints the first len elements.
		for (int i = 0; i < len; i++) {
		    print(nums[i]);
		}
	 *
	 * Example 1:

		Input: nums = [1,1,2]
		Output: 2, nums = [1,2]
		Explanation: Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the returned length.
	 * Example 2:
		
		Input: nums = [0,0,1,1,1,2,2,3,3,4]
		Output: 5, nums = [0,1,2,3,4]
		Explanation: Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively. It doesn't matter what values are set beyond the returned length.
		 
		
	 * Constraints:
		
		0 <= nums.length <= 3 * 104
		-104 <= nums[i] <= 104
		nums is sorted in ascending order.
	 * 
	 * HINT
	 *  - In this problem, the key point to focus on is the input array being sorted. As far as duplicate elements are concerned, what is their positioning in the array when the given array is sorted? Look at the image above for the answer. If we know the position of one of the elements, do we also know the positioning of all the duplicate elements?
	 *  - We need to modify the array in-place and the size of the final array would potentially be smaller than the size of the input array. So, we ought to use a two-pointer approach here. One, that would keep track of the current element in the original array and another one for just the unique elements.
	 *  - Essentially, once an element is encountered, you simply need to bypass its duplicates and move on to the next unique element.
	 */
	public static int removeDuplicates(int[] nums) {
        int index = 0;
        int curVal = 0;
        
        for(int i=0 ; i<nums.length ; i++) {
        	if(i == 0) {
        		curVal = nums[index++];
        	}
        	
        	if(curVal < nums[i]) {
        		nums[index++] = nums[i];
        		curVal = nums[i];
        	}
        }
        
		return index;
    }

	public static void main(String[] args) {
		// Remove Element
		// int[] nums = {1};
		// int val = 1;
		// removeElement(nums, val);
		
		// Remove Duplicates from Sorted Array
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		int len = removeDuplicates(nums);
		System.out.println(len);
	}

}
