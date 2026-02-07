class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int a : nums)
        {
            heap.add(a);

            if(heap.size()>k)
            {
                heap.poll();
            }
        }
        return heap.peek();
    }
}