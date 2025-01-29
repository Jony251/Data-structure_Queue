import unit4.collectionsLib.Queue;

public class sumAllElOfQueue {
        public static void main(String[] args) {
            Queue<Integer> queue = new Queue<>();
            queue.insert(1);
            queue.insert(2);
            queue.insert(3);
            queue.insert(4);
            queue.insert(5);

            System.out.println("Sum of elements: " + sumQueue(queue));

            System.out.print("Initial queue: ");
            while (!queue.isEmpty()) {
                System.out.print(queue.remove()+" ");
            }
        }

    /**
     * The function summers all elements in queue of integers
     * Time Complexity sumQueue: O(n)+O(n)=O(n)
     *
     * @param queue queue of integers
     * @return {@code int} sum of elements from queue
     */
    public static int sumQueue(Queue<Integer> queue) {

        Queue<Integer> tempQueue = new Queue<>();
        int sum = 0, value;

        while (!queue.isEmpty()) {
            value = queue.remove();
            sum += value;
            tempQueue.insert(value);
        }

        while (!tempQueue.isEmpty()) {
            queue.insert(tempQueue.remove());
        }

        return sum;
    }
}
