package Sorting.ElementarySorts;

import Fundamentals.BagsQueuesStacks.LinkList.Queue;
import Fundamentals.DataAbstraction.Transaction;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by apple on 16/2/26.
 */
public class SortTransactions {
    public static Transaction[] readTransactions() {
        Queue<Transaction> queue = new Queue<Transaction>();
        while (StdIn.hasNextLine()) {
            String line = StdIn.readLine();
            Transaction transaction = new Transaction(line);
            queue.enqueue(transaction);
        }

        int N = queue.size();
        Transaction[] transactions = new Transaction[N];
        for (int i = 0; i < N; i++)
            transactions[i] = queue.dequeue();

        return transactions;
    }
    public static void main(String[] args) {
        Transaction[] transactions = readTransactions();
        Arrays.sort(transactions);
        for (int i = 0; i < transactions.length; i++)
            StdOut.println(transactions[i]);
    }


}
