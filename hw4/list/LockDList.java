
package list;

class LockDList extends DList{

   protected LockDListNode newNode(Object item, DListNode prev, DListNode next) {
    return new LockDListNode(item, prev, next);
  }

  public LockDList(){
    super();
  //  LockDListNode newnode = new LockDListNode(null,head,head);
  //  head = newnode;
  }

  public void lockNode(DListNode node){
    LockDListNode newnode = new LockDListNode(node.item,node.prev,node.next);
    newnode.setLock();
    node.prev.next = newnode;
    newnode.next = node.next;
  }

  public void remove(LockDListNode node){
    if(node.checkLock() == false){
	node.prev.next = node.next;
	node.next.prev = node.prev;
	size --;
    }else{
	return;
    }
  }

 // public void remove(DListNode node){
 //   node.prev.next = node.next;
 //   node.next.prev = node.prev;
 //   size --;
 // }


  public static void main(String[] argv){
	
	LockDList locklist = new LockDList();
	Integer i = new Integer(10);
	Integer j = new Integer(20);
	Integer h = new Integer(30);
	locklist.insertFront(i);
	locklist.insertFront(j);
	
        DListNode n = locklist.front();

	locklist.lockNode(n);
	LockDListNode n2 = (LockDListNode)locklist.front();
//	DListNode nn = locklist.front();
	String s = locklist.toString();
	int num1 = locklist.length();
	locklist.remove(n2);

	String s1 = locklist.toString();
	int num2 = locklist.length();
	
	locklist.insertBack(h);
	DListNode k = locklist.back();
	//locklist.remove(k);

        String s2 = locklist.toString();
	int num3 = locklist.length();

	DListNode item = locklist.back();
	locklist.remove(item);
	String s3 = locklist.toString();
	int num4 = locklist.length();

	System.out.println("the list is:"+ s + " should be 20, 10 and length should be:"+ num1);
	System.out.println("after lock, the list cannot be removed"+ s1 +" should be  20, 10 and length should be:" + num2);
	System.out.println("without lock, the list can be removed" + s2 + " should be 20 and length is:" + num3);
	System.out.println("it should be 20:" + s3 + "the length is:" + locklist.length());

  }
}

