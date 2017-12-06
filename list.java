package final1;

public class list<T> implements listInterface<T>
{
	private Node<T> head;	//pointer to beginning of line
	private Node<T> tail;	//pointer to end of line
        private Node<T> point;	//pointer to specific location
        public int num = 0;

	
        public class Node<T>
        {
        	T data;
        	list<T>.Node<T> next;
        	
        	public Node() {
        		data = null;
        		next = null;
        	}

        	public Node(T newItem, list<T>.Node<T> nextN)
        	{
        		this.data = newItem;
        		this.next = nextN;
        	}
        }
        
        public list()
                {
                    head = null;
                    tail = null;
                    point = null;
                }
        
        public list(T item)
                {
                    head = new Node<T>(item, null);
                    tail = head;
                    point = head;
                    num++;
                }
   
        public void add(T item)
   {
       if (head == null)
       {
           head = new Node<T>(item,null);
            tail = head;
       }
       else
       {
           Node<T> node = new Node<T>(item, null);
           tail.next = node;
           tail = node;
       }
       num++;
   }
   
        public void add(int position, T item)
   {
       if(position > num)
           throw new IndexOutOfBoundsException();
       else
       {
           if (head == null)
           {
               head = new Node<T>(item,null);
               tail = head;
           }
           else
           {
               Node<T> node = new Node<T>(item, null);
               tail.next = node;
               tail = node;
           }
       }   
   }   

        public void remove(int position)
   {
       if(position > num)
           throw new IndexOutOfBoundsException();
       else
       {
           Node<T> Tnode = head;
           int temp = 1;
           while (temp != position)
           {
               if(temp == position-1)
                   Tnode = point;
               point = point.next;
               temp++;
           }
           Tnode.next = point.next;
           point.data = null;
           point.next = null;
           point = head;
           num--;
           
       }   
   }
   

        public void clear()
   {
       while(head.next != null)
       {
           head.data = null;
           head = head.next;
       }
       head = null;
       tail = null;
       point = null;
   }

        public T view(int position)
   {
       T tempd;
       Node<T> Tnode = head;
       int temp = 1;
       while (temp != position)
       {
           point = point.next;
           temp++;
       }
       tempd = point.data;
       point = head;
       return tempd;
   }
   
  
        public boolean contains(T obj)
   {
       for(int i = 1; i <= num; i++)
       {
           if(obj == point.data)
               return true;
       }
       
       return false;
   }
   

        public boolean isEmpty()
   {
            return num <= 0;
   }

   
}
