public class BigOLinkedIntList
{
    private ListNode front;

    public BigOLinkedIntList()
    {
        front = null;
    }

    public void add(int value) // Best Case: O(1), Worst Case: O(N)
    {
        if (front == null)
        {
            front = new ListNode(value);
        }
        else
        {
            ListNode current = front;
            while (current.next != null)
            {
                current = current.next;
            }
            current.next = new ListNode(value);
        }
    }

    public void add(int index, int value) // Best Case: O(1), Worst Case: O(N)
    {
        if (index == 0)
        {
            front = new ListNode(value, front);
        }
        else
        {
            ListNode current = goTo(index - 1);
            ListNode newNode = new ListNode(value, current.next);
            current.next = newNode;
        }
    }

    public int get(int index) // Best Case: O(1), Worst Case: O(N)
    {
        ListNode current = goTo(index);
        return current.data;
    }

    public boolean isEmpty() // Best Case: O(1), Worst Case: O(1)
    {
        return front == null;
    }

    public void remove(int index) // Best Case: O(1), Worst Case: O(N)
    {
        if (index == 0) {
            front = front.next;
        }
        else
        {
            ListNode current = goTo(index - 1);
            current.next = current.next.next;
        }
    }

    public int set(int index, int value) // Best Case: O(1), Worst Case: O(N)
    {
        ListNode current = goTo(index);
        current.data = value;
        return value;
    }

    public int size() // Best Case: O(1), Worst Case: O(N)
    {
        int count = 0;
        ListNode current = front;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    private ListNode goTo(int index) // Best Case: O(1), Worst Case: O(N)
    {
        ListNode current = front;
        for (int i = 0; i < index; i++)
        {
            current = current.next;
        }
        return current;
    }
}