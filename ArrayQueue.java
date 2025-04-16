public class ArrayQueue {
    public static void main(String[] args) {
        if (args.length >= 1) {
            try {
                int[] queue = init(Integer.parseInt(args[0]));

                for (int i = 1; i < args.length; i++) {
                    int value = Integer.parseInt(args[i]);
                    System.out.println(String.format("Contains: %d %b", value, contains(queue, value)));
                    System.out.println(String.format("Added: %d %b", value, push(queue, value)));
                    System.out.println(String.format("Contains: %d %b", value, contains(queue, value)));
                }
                printQueue(queue);

            } catch (NumberFormatException e) {
                System.out.println(String.format("Error Parsing %s", args[0]));
            }
            return;
        }

        int[] queue = init(5);
        printQueue(queue);
        System.out.println(String.format("Element %d ist vorhanden? %b", 10, contains(queue, 10)));
        push(queue, 10);
        System.out.println(String.format("Element %d ist vorhanden? %b", 10, contains(queue, 10)));
        push(queue, 20);
        push(queue, 30);
        printQueue(queue);
    }

    public static void printQueue(int[] queue) {
        System.out.print("[");
        for (int i = 0; i < queue.length; i++) {
            System.out.print(queue[i]);
            if (i != queue.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static int[] init(int length) {
        int[] queue = new int[length];
        for (int i = 0; i < queue.length; i++) {
            queue[i] = -1;
        }
        return queue;
    }

    public static boolean contains(int[] queue, int value) {
        boolean wert = false;
        for (int i = 0; i < queue.length; i++) {
            if (queue[i] == value) {
                wert = true;
                break;
            }
        }
        return wert;
    }
    
    public static boolean push(int[] queue, int value) {
        if (contains(queue, value) == true) {
            return false;
        }
        
        for (int i = 0; i < queue.length; i++) {
            if (queue[i] == -1) {
                queue[i] = value;
                return true;
            }
        }
        return false;
    }

}