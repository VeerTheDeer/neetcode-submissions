class Solution {
    class Node {
        int index;
        Node prev;
        Node next;
        
        public Node(int index) {
            this.index = index;
        }
    }
    
    class CustomDeque {
        Node head;
        Node tail;
        
        public boolean isEmpty() {
            return head == null;
        }
        
        public void addLast(int index) {
            Node newNode = new Node(index);
            if (isEmpty()) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }
        
        public void removeFirst() {
            if (isEmpty()) return;
            
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
        }
        
        public void removeLast() {
            if (isEmpty()) return;
            
            if (head == tail) {
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
        }
        
        public int peekFirst() {
            return head.index;
        }
        
        public int peekLast() {
            return tail.index;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        CustomDeque deque = new CustomDeque();
        
        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }

            deque.addLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        
        return result;
    }
}