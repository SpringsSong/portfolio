import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;

public class Broadhead_QueueOperations {

    public static void main(String[] args) {
        // Create two priority queues
        PriorityQueue<String> queue1 = new PriorityQueue<>();
        PriorityQueue<String> queue2 = new PriorityQueue<>();

        // Add elements to the first queue
        String[] names1 = {"George", "Jim", "John", "Blake", "Kevin", "Michael", "Walter", "Angel"};
        for (String name : names1) {
            queue1.offer(name);
        }

        // Add elements to the second queue
        String[] names2 = {"George", "Katie", "Kevin", "Michelle", "Ryan", "Angel"};
        for (String name : names2) {
            queue2.offer(name);
        }

        // Print the original queues
        System.out.println("Queue 1: " + queue1);
        System.out.println("Queue 2: " + queue2);

        // Find and print the union of the two queues
        Set<String> unionSet = new HashSet<>(queue1);
        unionSet.addAll(queue2);
        PriorityQueue<String> unionQueue = new PriorityQueue<>(unionSet);
        System.out.println("Union: " + unionQueue);

        // Find and print the difference of the two queues
        PriorityQueue<String> differenceQueue = new PriorityQueue<>(queue1);
        differenceQueue.removeAll(queue2);
        System.out.println("Difference: " + differenceQueue);

        // Find and print the intersection of the two queues
        PriorityQueue<String> intersectionQueue = new PriorityQueue<>(queue1);
        intersectionQueue.retainAll(queue2);
        System.out.println("Intersection: " + intersectionQueue);
    }
}
