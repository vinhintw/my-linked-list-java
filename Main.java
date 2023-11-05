//import lib
import java.util.ArrayList;
import java.util.List;

//define List Node
class Node<T>{
	T data;
	Node<T> next;

	public Node(T data){
		this.data = data;
		this.next = null;
	}
}

//define linked list
class SingleLinkedList<T>{
	private Node<T> head;
	private Node<T> tail;
	private int size;

	public SingleLinkedList(){
		head = null;
		tail = null;
		size = 0;
	}

	public int size(){
		return this.size;
	}

	public boolean isEmty(){
		return size == 0;
	}
	//"push an item to the front of the list"
	public void pushFront(T value){
		Node<T> newNode = new Node<>(value);
		newNode.next = head;
		head = newNode;
		if(size == 0){
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
	public void pushBack(T value){
		Node<T> newNode = new Node<>(value);
		if(head == null){
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
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
	public List<Integer> search(T value){
		List<Integer> indexes = new ArrayList<>();
		Node<T> current = head;
		for (int i =0; i < size; i++) {
			if (current.data.equals(value)) {
				indexes.add(i);
			}
			current = current.next;
		}
		return indexes;
	}

	//reverse the list
	public void reverse(){
		if (size <= 1) {
			return;
		}
		Node<T> prev = null;
		Node<T> current = head;
		Node<T> next = null;
		while(current != null){
			next = current.next;
			current.next = prev;
			prev =current;
			current = next;
		}
		head = prev;
	}

	//empty the list
	public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    //outputs all value of list
    public void print(){
    	Node<T> current_node = this.head;
        while (current_node != null){
        	System.out.print(current_node.data + " ");
            current_node = current_node.next;
        }
    }

}

//Test class
public class Main{
	public static void main(String[] args) {
		SingleLinkedList<Integer> list = new SingleLinkedList<>();
		list.pushBack(1);
		list.pushBack(2);
		list.pushBack(3);
		list.pushBack(4);

		//list.print(); // 1 2 3 4
		//list.reverse();
		//list.print(); // 4 3 2 1
		list.insert(3, 10);
		//list.print(); // 1 2 3 10 4
		list.erase(4);
		System.out.print(list.search(4)); // []

	}
}