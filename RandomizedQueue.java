import java.util.*;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;


public class RandomizedQueue<Item> implements Iterable<Item> 
{
     private Item[] q; // elements of the queue
	 private int siz;  //size of the queue
	 private int last;  //last eleemnt position in the queue
       

    // construct an empty randomized queue
    public RandomizedQueue()
	{
		q=(Item[]) new Object[5]; //Queue elements are objects
		siz=0;
		last=0;
	}
	
    // is the randomized queue empty?
    public boolean isEmpty()
	{
		return siz==0;
	}

    // return the number of items on the randomized queue
    public int size()
	{
		return siz;
	}

    // add the item
    public void enqueue(Item item)
   {
	   if(item==null)
	   { 
         throw new IllegalArgumentException();
	   }
	   q[siz++]=item;  //Add element in the queue
	   last=siz;   //last element index becomes the size after adding
   }
	   
		   
    // remove and return a random item
    public Item dequeue()
	{
		 if(size()==0)
		 {
			 throw new NoSuchElementException();
		 }
		 int r = StdRandom.uniform(siz);//Standard Lib used, random number generated out  of siz.
         Item rem=q[r]; // randomized queue selected to be removed
		 if(r!=siz-1) //if r is not equal to index of last element
		 {
			 q[r]=q[siz-1];
		 }
		 q[siz-1]=null; //make the ranomized queue item as last and then remove it and decrease size
         siz--;
	    return rem;
	}
	
    // return a random item (but do not remove it)
    public Item sample()
	{
		if(size()==0)
		 {
			 throw new NoSuchElementException();
		 }
		 int r;
		 r=StdRandom.uniform(siz);//Standard Lib used, random number generated out  of siz.
         Item sam=q[r];
		 return sam;
	}

    // return an independent iterator over items in random order
    public Iterator<Item> iterator()
	{
		return new RandomIterator();
	}
	
	private class RandomIterator implements Iterator<Item>
	{
        private int random=0;
        private int copySize=siz;
        private Item[] copy =(Item[]) new Object[copySize];
        //Copy of array of objs for queue elements is made
        //To add and remove while iterating randomly
       
        private RandomIterator()
		{
   			for(int i=0;i<copySize;i++)
			{
				copy[i]=q[i];
			}
		}
		
		public boolean hasNext()
		{
			return copySize!=0;
		}
		
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
		
		public Item next()
		{
			if(copySize == 0)
            {
                throw new NoSuchElementException();
            }
			random=StdRandom.uniform(copySize);
			Item current=copy[random];
			if(random!=copySize-1)
			{
				copy[random]=copy[copySize-1];
			}
			copy[copySize-1]=null;
			copySize--;
			return current;
		}
	}
	

    // unit testing (required)
    public static void main(String[] args)
    {
		RandomizedQueue<Integer> rq=new RandomizedQueue<Integer>();
		rq.enqueue(7);
		rq.enqueue(8);
		rq.enqueue(5);
		rq.enqueue(1);
		rq.enqueue(3);
		System.out.println(rq.sample()); //print a random queue element
		rq.dequeue();
		rq.dequeue();
		rq.dequeue();
		rq.enqueue(6);
		System.out.println(rq.sample());
	}
		
}
