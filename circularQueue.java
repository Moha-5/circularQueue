class circularQueue{
    private int[] queue;
    private int front;
    private int rear;
    private int size;

    // the constuctor and isEmpty() the same
    public circularQueue(int capacity){
        queue = new int[capacity];
        front = -1;
        rear = -1;
        size = capacity;
    }

    public boolean isEmpty(){
        return front == -1;
    }

    //the is the new isFull()
    /*
      here is a new concept we need to understand
      the {(rear + 1 ) % size} this means
      lets say size = 5 and queue is has 1 element
      then when we insert 5 times this what will happened? 
      1: rear = (0 + 1) % 5 = 1.
      2: rear = (1 + 1) % 5 = 2.
      3: rear = (2 + 1) % 5 = 3.
      4: rear = (3 + 1) % 5 = 4.
      5: rear = (4 + 1) % 5 = 0 (wrap-around).
    */
    public boolean isFull(){
        return (rear + 1 ) % size == front;
    }

    public void enqueue(int x){
        if (isFull()) {
            System.out.println("Queue is full \nfile is terminated");
            System.exit(1);
        }

        // first insertion
        if (front == -1){
            front = 0;
        }
        rear = (rear + 1) % size;
        queue[rear] = x;
        System.out.println("inserted " + x);
    }

    public int dequeue(){
        if (isEmpty()){
            System.out.println("queue is empty!");
            return -1;
        }
        int y = queue[front];
        if (front == rear){
            front = -1;
            rear = -1;
        } else {
            // here we use the same concept with front instead of rear in (rear + 1) % size
            front = (front + 1) % size;
        }
        System.out.println("dequeued " + y);
        return y;
    }
    public void display(){
        if (isEmpty()){
            System.out.println("queue is empty");
            return; // so the function stop
        }
        System.out.println("Queue: ");
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear){ 
                break; }
            i = (i + 1) % size;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        circularQueue queue = new circularQueue(5); // Capacity of 5

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.display();

        queue.dequeue();
        queue.display();

        queue.enqueue(50);
        queue.enqueue(60); // Wrap-around here
        queue.display();
    }

}