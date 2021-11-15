package WhosNext;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WhosNext {
    public static void main(String[] args) throws IOException {
        // Setup and getting all the customer data into the queue
        LinkedListQueue q = new LinkedListQueue();
        Scanner fileReader = new Scanner(new File("C:\\temp_Jim\\Customers.dat"));
        while (fileReader.hasNextLine()) {
            q.enqueue(fileReader.nextLine());
        }

        // the start of the processing stage of the customers.
        int totalWaitTime = 0;


        // initialize the avaliable times of the agent to the arrival time of the first customer (just an arbitrary value)
        Scanner initializer = new Scanner((String) q.peekFront());
        int firstCustArrivalTime = initializer.nextInt();
        int nextAvailTimeA = firstCustArrivalTime;
        int nextAvailTimeB = firstCustArrivalTime;

        // main loop
        while (!q.isEmpty()) {
            // start the dequeue process of the customers
            String nextCustomer = (String) q.dequeue();
            Scanner intReader = new Scanner(nextCustomer);
            int custArrivalTime = intReader.nextInt();
            int custHelpTime = intReader.nextInt();
            int dequeueTime = 0;
            // calculate dequeTime (aka when customer is ready to be helped) through seeing which one is sooner,
            // either through the agent's next available time or the customers arrival time depending on which one is greater.
            // then it will set the next available time of the agents accounting for the customers help time.
            if (nextAvailTimeA <= nextAvailTimeB) {
                dequeueTime = Math.max(nextAvailTimeA, custArrivalTime);
                nextAvailTimeA = dequeueTime + custHelpTime;
            } else {
                dequeueTime = Math.max(nextAvailTimeB, custArrivalTime);
                nextAvailTimeB = dequeueTime + custHelpTime;
            }
            // calculates how long the customer has waited by figuring out the difference between the customers's
            // arrival time and the dequeue time of the customer
            // if its negative that means the customer arrived after the agent was available, thus not needing to wait.
            // so then the value becomes 0
            int thisWaitTime = dequeueTime - custArrivalTime;
            totalWaitTime += thisWaitTime;
        }
        System.out.println(totalWaitTime);
    }
}
