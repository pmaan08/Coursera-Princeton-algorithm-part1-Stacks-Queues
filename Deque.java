import java.util.*;
import java.util.Iterator;
import java.util.ListIterator;

public class Deque<Item> implements Iterable<Item> 
{
 private Node first;
 private Node last;
   private int size1;
  
  public Deque()
{
first=null;
last=null;
size1=0;
}
private class Node
{

 private Item item;
 private Node next;  
 Node()
 {
	 item=null;
	 next=null;
 }
 Node(Item x)
 {
  item=x;
   next=null;
}
}

// is the deque empty?
 public boolean isEmpty()
{
  return size1==0;
}
// return the number of items on the deque
public int size()
{
 return size1;
}



// add the item to the front
public void addFirst(Item item)
{
if(item==null)
{
throw new java.lang.NullPointerException();
}
Node ptr=first;
ptr=first.next;
first=new Node();
first.item=item;
first.next=ptr;
if(size1==0)
{
	last=first;
}
size1++;
}
	 



// add the item to the back
public void addLast(Item item)
{
if(item==null)
{
throw new java.lang.NullPointerException();
}
Node ptr=last;
last =new Node(item);
ptr.next=last;
size1++;
 }



// remove and return the item from the front
 public Item removeFirst()
 {
if (isEmpty()) 
{throw new java.util.NoSuchElementException();
}
Item item=first.item;
Node ptr=first;
first=first.next;
ptr.next=null;
size1--;
return item;
}


// remove and return the item from the back
public Item removeLast()
{ 
if (isEmpty()) 
{ throw new java.util.NoSuchElementException();
}
Item item=last.item;
Node ptr=first;
while(ptr.next.next!=null)
{ptr=ptr.next;
}
ptr.next=null;
size1--;
return item;
}

// return an iterator over items in order from front to back
public Iterator<Item> iterator()
{
return new ListIterator();
}


private class ListIterator implements Iterator<Item>
 {
private Node current=first;

public boolean hasNext()
{ return current!=null;
}
public void remove()
{
	throw new java.lang.UnsupportedOperationException();
}
public Item next()
{
Item item =current.item;
 current=current.next;
return item;
}
 } 

//unit testing (required)
 public static void main(String[] args) {
        Deque<Integer> deque = new Deque<Integer>();
        deque.addFirst(1);
        for (Integer i : deque)
            System.out.println(i);
        System.out.println("-----");
        deque.removeLast();
       deque.addFirst(3);
        deque.addFirst(2);
        deque.addLast(9);
        deque.addLast(10);
        for (Integer i : deque)
            System.out.println(i);
        System.out.println("-----");

        for (Integer i : deque)
            for (Integer j : deque)
                System.out.println(i + " " + j);
        System.out.println("-----");
        deque.removeFirst();
        for (Integer i : deque)
            System.out.println(i);
        System.out.println("-----");
        deque.removeLast();
        for (Integer i : deque)
                System.out.println(i);
        System.out.println("-----");
        System.out.println(deque.size1);
        deque.removeFirst();
        deque.removeLast();
        System.out.println(deque.size1);
    }
}



