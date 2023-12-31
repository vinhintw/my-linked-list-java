//import lib
import java.util.ArrayList;
import java.util.List;


//define List Node
class Node<T>{
	T data;
	Node<T> next;
	Node<T> prev;

	public Node(T data){
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

//define linked list
class DoubleLinkedList<T>{
	private Node<T> head;
	private Node<T> tail;
	private int size;

	public DoubleLinkedList(){
		head = null;
		tail = null;
		size = 0;
	}

	public int size(){
		return this.size;
	}

	public boolean isEmpty(){
		return size == 0;
	}
	//"push an item to the front of the list"
	public void pushFront(T value){
		Node<T> newNode = new Node<>(value);
		newNode.next = head;
		newNode.prev = null;
		if (head != null) {
            head.prev = newNode;
        }
		head = newNode;
		if(isEmpty()){
			tail = head;
		}
		size++;
	}
	//"remove front item and return its value"
	public T popFront(){
		if(head == null){
			throw new IllegalStateException("List is empty");
		}
		T value = head.data;
		head = head.next;
		if(size == 1){
			tail = null;
		}
		size--;
		return value;
	}
	//"add item to end of list"
	public void pushBack(T value) {
	    Node<T> newNode = new Node<>(value);
	    newNode.next = null;
	    newNode.prev = tail;

	    if (tail != null) {
	        tail.next = newNode;
	    }

	    tail = newNode;

	    if (isEmpty()) {
	        head = newNode;
	    }

	    size++;
	}
	//"remove end item and return its value"
	public T popBack(){
		if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        if(size == 1){
        	T value = head.data;
        	head = null;
        	tail = null;
        	size--;
        	return value;
        }
        Node<T> current = head;
        while(current.next != tail){
        	current = current.next;
        }
        T value = tail.data;
        current.next = null;
        tail = current;
        size--;
        return value;
	}
	//return the value of the nth element, index start at 0
	public T valueAt(int index){
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		Node<T> current = head;
		for(int i = 0; i < index; i++){
			current = current.next;
		}
		return current.data;
	}

	//get value of front item
	public T front(){
		if(head == null){
			throw new IllegalStateException("List is empty");
		}
		return head.data;
	}

	//get value of end item
	public T back(){
		if(tail == null){
			throw new IllegalStateException("List is empty");
		}
		return tail.data;
	}

	//insert value at index, put value at position index so current item at that index is pointed to the new item at index, index starts at 0
	public void insert(int index, T value){
		if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
        	pushFront(value);
        	return;
        }
        if (index == size) {
        	pushBack(value);
        	return;
        }
        Node<T> newNode = new Node<>(value);
        Node<T> current = head;
        for (int i = 0; i < index -1; i++ ) {
        	current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
	}

	//remove a node from the list by its position, change the referece of the node that point to them to the reference of next node from the deleted node
	public void erase(int index){
		if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (head == null) {
        	return;
        }
        if (index == 0) {
        	popFront();
        	return;
        }
        if (index == size -1) {
        	popBack();
        	return;
        }
        Node<T> current = head;
        for (int i = 0;i < index -1; i++) {
        	current = current.next;
        }
        current.next = current.next.next;
        size--;
	}

	//search list and return the array that containt the position of the value that matched, index start at 0
	public String search(T value){
		String indexes = "";
		Node<T> current = head;
		for (int i =0; i < size; i++) {
			if (current.data.equals(value)) {
				indexes = indexes +" "+ i;
			}
			current = current.next;
		}
		return indexes;
	}

	//empty the list
	public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    //outputs all value of list
    public String toString() {
        String result = "Double Linked List: [";
        Node<T> current = head;

        while (current != null) {
            result += current.data;
            if (current.next != null) {
                result += " <-> ";
            }
            current = current.next;
        }

        result += "]";
        return result;
    }
}

//Test class
public class Main {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

		list.clear();

		list.insert(0,1);

		list.insert(1,2);

		list.insert(0,2);

		list.insert(0,3);

		list.insert(2,4);

		printListInfor(list);
	    System.out.println(list.search(3));
	    System.out.println(list.search(2));
	    System.out.println(list.search(1));
	    System.out.println(list.search(0));

    }

    //method for testing
    //print head,tail and the actual list
    public static void printListInfor(DoubleLinkedList list){
	    if (!list.isEmpty()) {
	        System.out.println("Front: " + list.front() + " Back: " + list.back());
	    } else {
	        System.out.println("The list is empty.");
	    }
	    System.out.println("Actual list: " + list.toString());
	    System.out.println();
    }
}
