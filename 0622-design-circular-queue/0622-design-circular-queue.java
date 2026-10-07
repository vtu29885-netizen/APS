class MyCircularQueue {
    private final int[] queue;
    private final int capacity;
    private int headIndex;
    private int count;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.queue = new int[k];
        this.headIndex = 0;
        this.count = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        int tailIndex = (headIndex + count) % capacity;
        queue[tailIndex] = value;
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        headIndex = (headIndex + 1) % capacity;
        count--;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[headIndex];
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int tailIndex = (headIndex + count - 1) % capacity;
        return queue[tailIndex];
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == capacity;
    }
}