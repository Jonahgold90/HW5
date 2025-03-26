/******************************************************************
 *
 *   Jonah Goldberg / Section 002
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {

        // ADD YOU CODE HERE -- DON'T FORGET TO ADD YOR NAME AT TOP OF FILE
        //Init integer hashtable
        HashSet<Integer> set = new HashSet<>();

        //Add all the numbers in arr a to the hashset
        for(int i = 0; i < list1.length; i++) {
            set.add(list1[i]);
        }

        //Iterate through list 2
        for(int i = 0; i < list2.length; i++) {
            //Check if the hashtable contains each number in list 2
            if(set.contains(list2[i])) {
                continue;
            } else {
                //If the list1 hashtable doesn't contain an element from list 2 then list 2 is not a subset so return false.
                return false;
            }
        }

        //list 2 is a subset of list 1 so return true
        return true;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        // ADD YOUR CODE HERE
        
        //Initialize max heap priority queue
        PriorityQueue<Integer> prioQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        //Add all the numbers from the array into the prio queue
        for(int num : array) {
            prioQueue.add(num);
        }

        //Iterate from 0 to k - 1
        for(int i = 0; i < k - 1; i++) {
            prioQueue.poll();
        }

        //The kth largest element in the array
        return prioQueue.peek();
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {
        
        // ADD YOU CODE HERE

        //Initialize a new integer array of size arr1 size + arr2 size
        int[] res = new int[array1.length + array2.length];
        

        //initialize min heap priority queue
        PriorityQueue<Integer> prioQueue = new PriorityQueue<>();

        //Add all the elements from array 1 into priority queue
        for(int num : array1) {
            prioQueue.add(num);
        }

        //Add all the elements from array 2 into priority queue
        for(int num : array2) {
            prioQueue.add(num);
        }

        //Numbers in prio queue are not descending to ascending as needed
        //Loop through prio queue and add each element to the res array
        for(int i = 0; i < res.length; i++) {
            res[i] = prioQueue.poll();
        }

        //Return the res array
        return res;
    }

}