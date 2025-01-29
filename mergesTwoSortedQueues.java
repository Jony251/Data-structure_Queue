import unit4.collectionsLib.Queue;

public class mergesTwoSortedQueues {
    public static void main(String[] args) {
        //Total time complexity: O(n + m)

        Queue<String> queue1 = new Queue<>();
        Queue<String> queue2 = new Queue<>();

        queue1.insert("Alice");
        queue1.insert("Charlie");
        queue1.insert("Eve");

        queue2.insert("Bob");
        queue2.insert("David");
        queue2.insert("Frank");

        System.out.println("Queue 1: ");
        printQueue(queue1);
        System.out.println("Queue 2: ");
        printQueue(queue2);

        Queue<String> mergedQueue = mergeSortedQueues(queue1, queue2);

        System.out.println("Merged Queue: ");
        printQueue(mergedQueue);
    }

    /**
     * The function merges two sorted queues into one
     * Time Complexity mergeSortedQueues: O(n + m)
     *
     * @param queue1 queue of strings sorted in ascending order
     * @param queue2 queue of strings sorted in ascending order
     * @return {@code Queue<String>} new queue containing elements from both queues, sorted in ascending order
     */
    public static Queue<String> mergeSortedQueues(Queue<String> queue1, Queue<String> queue2) {

        Queue<String> mergedQueue = new Queue<>();

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            String first = queue1.head();
            String second = queue2.head();

            if (first.compareTo(second) < 0) {
                mergedQueue.insert(queue1.remove());
            } else {
                mergedQueue.insert(queue2.remove());
            }
        }

        while (!queue1.isEmpty()) {
            mergedQueue.insert(queue1.remove());
        }

        while (!queue2.isEmpty()) {
            mergedQueue.insert(queue2.remove());
        }

        return mergedQueue;
    }

    /**
     * Function that printing a queue of strings
     * Time Complexity printQueue: O(n)
     *
     * @param queue the queue of strings to be printed
     */
    private static void printQueue(Queue<String> queue) {

        Queue<String> tempQueue = new Queue<>();
        while (!queue.isEmpty()) {
            String element = queue.remove();
            System.out.print(element + " ");
            tempQueue.insert(element);
        }
        System.out.println();
        while (!tempQueue.isEmpty()) {
            queue.insert(tempQueue.remove());
        }
    }
}
