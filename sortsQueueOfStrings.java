import unit4.collectionsLib.Queue;

public class sortsQueueOfStrings {
    public static void main(String[] args) {
        /*
         * * Total time complexity: O(n^2)
         */
        Queue<String> queue = new Queue<>();

        queue.insert("banana");
        queue.insert("apple");
        queue.insert("cherry");
        queue.insert("date");

        System.out.println("Before sorting: ");
        printQueue(queue);
        sortQueue(queue);
        System.out.println("After sorting: ");
        printQueue(queue);
    }

    /**
     * Function that sorts a queue of strings in alphabetical order
     * The given queue is modified in place, and no new queue is created
     * Sorting is performed using a selection-sort-like algorithm
     * Time Complexity sortQueue: O(n^2)
     *
     * @param queue the queue of strings to be sorted
     */
    public static void sortQueue(Queue<String> queue) {

        String min, current;
        if (queue.isEmpty())
            return;

        int size = countQueue(queue);

        for (int i = 0; i < size; i++) {
            min = null;

            for (int j = 0; j < size; j++) {
                current = queue.remove();

                if (min == null || current.compareTo(min) > 0) {
                    if (min != null) {
                        queue.insert(min);
                    }
                    min = current;
                } else {
                    queue.insert(current);
                }
            }

            queue.insert(min);
        }

        for (int i = 0; i < size; i++) {
            queue.insert(queue.remove());
        }
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
            System.out.println(element + " ");
            tempQueue.insert(element);
        }
        while (!tempQueue.isEmpty()) {
            queue.insert(tempQueue.remove());
        }
    }

    /**
     * Function that counting a number of elements in queue of strings
     *Time Complexity countQueue: O(n)
     *
     * @param queue the queue of strings to be count
     * @return {@code int} count of elements
     */
    private static int countQueue (Queue<String> queue) {

        Queue<String> tempQueue = new Queue<>();
        int count=0;
        while (!queue.isEmpty()) {
            tempQueue.insert(queue.remove());
            count++;
        }

        while (!tempQueue.isEmpty()) {
            queue.insert(tempQueue.remove());
        }
        return count;
    }
}
