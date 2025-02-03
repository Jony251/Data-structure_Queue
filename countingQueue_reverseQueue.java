import unit4.collectionsLib.Queue;

public class countingQueue_reverseQueue {
    public static void main(String[] args) {
        Queue<Character> queue = new Queue<Character>();
        Queue<Character> queue1 = new Queue<Character>();

        queue.insert('a');
        queue.insert('b');
        queue.insert('c');
        queue.insert('d');
        System.out.println(countQueue_deleteEl(queue));

        System.out.println("Empty queue -> "+queue);

        queue1.insert('a');
        queue1.insert('b');
        queue1.insert('c');
        queue1.insert('d');
        System.out.println(countQueue_reversePosition(queue1));
        System.out.println(queue1);
        
        reversQueue(queue1);
        System.out.println(queue1);
    }

    /**
     * Counts number of elements of given queue, but delete it values
     *
     * @param queue of chars
     * @return {@code int} number of elements
     */
    public static int countQueue_deleteEl(Queue<Character> queue){
        if (queue.isEmpty()) return 0;
        queue.remove();
        return 1 + countQueue_deleteEl(queue);
    }

    /**
     * Counts number of elements of given queue and reversing it
     *
     * @param queue of chars
     * @return {@code int} number of elements
     */
    public static int countQueue_reversePosition(Queue<Character> queue){
        if (queue.isEmpty())
            return 0;
        char c = queue.remove();
        int count = 1 + countQueue_reversePosition(queue);
        queue.insert(c);
        return count;
    }

    /**
     * A void function for reversing queue elements
     *
     * @param queue of chars
     */
    public static void reversQueue(Queue<Character> queue){
        if (queue.isEmpty())
            return ;
        char c = queue.remove();
        reversQueue(queue);
        queue.insert(c);
    }
}
