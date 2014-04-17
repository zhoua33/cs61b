/* DList.java */

package list;

/**
 *  A DList is a mutable doubly-linked list ADT.  Its implementation is
 *  circularly-linked and employs a sentinel (dummy) node at the head
 *  of the list.
 *
 *  DO NOT CHANGE ANY METHOD PROTOTYPES IN THIS FILE.
 */

public class DList {

  /**
   *  head references the sentinel node.
   *  size is the number of items in the list.  (The sentinel node does not
   *       store an item.)
   *
   *  DO NOT CHANGE THE FOLLOWING FIELD DECLARATIONS.
   */

  protected DListNode head;
  protected int size;

  /* DList invariants:
   *  1)  head != null.
   *  2)  For any DListNode x in a DList, x.next != null.
   *  3)  For any DListNode x in a DList, x.prev != null.
   *  4)  For any DListNode x in a DList, if x.next == y, then y.prev == x.
   *  5)  For any DListNode x in a DList, if x.prev == y, then y.next == x.
   *  6)  size is the number of DListNodes, NOT COUNTING the sentinel,
   *      that can be accessed from the sentinel (head) by a sequence of
   *      "next" references.
   */

  /**
   *  newNode() calls the DListNode constructor.  Use this class to allocate
   *  new DListNodes rather than calling the DListNode constructor directly.
   *  That way, only this method needs to be overridden if a subclass of DList
   *  wants to use a different kind of node.
   *  @param item the item to store in the node.
   *  @param prev the node previous to this node.
   *  @param next the node following this node.
   */
  protected DListNode newNode(Object item, DListNode prev, DListNode next) {
    return new DListNode(item, prev, next);
  }

  /**
   *  DList() constructor for an empty DList.
   */
  public DList() {
	DListNode sentinel = new DListNode(null,head,head);
	head = sentinel;
	size = 0;
    //  Your solution here.
  }

  /**
   *  isEmpty() returns true if this DList is empty, false otherwise.
   *  @return true if this DList is empty, false otherwise. 
   *  Performance:  runs in O(1) time.
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /** 
   *  length() returns the length of this DList. 
   *  @return the length of this DList.
   *  Performance:  runs in O(1) time.
   */
  public int length() {
    return size;
  }

  /**
   *  insertFront() inserts an item at the front of this DList.
   *  @param item is the item to be inserted.
   *  Performance:  runs in O(1) time.
   */
  public void insertFront(Object item) {
    // Your solution here.
    DListNode sentinel = head;
    if(size == 0){
	DListNode newnode = new DListNode(item,sentinel,sentinel);
        sentinel.next = newnode;
	sentinel.prev = newnode;
    }else{
    DListNode newnode = new DListNode(item,sentinel,sentinel.next);
    sentinel.next.prev = newnode;
    sentinel.next = newnode;
    }
    size ++;
  }

  /**
   *  insertBack() inserts an item at the back of this DList.
   *  @param item is the item to be inserted.
   *  Performance:  runs in O(1) time.
   */
  public void insertBack(Object item) {
    // Your solution here.
    DListNode sentinel = head;
    if(this.size == 0){
	DListNode newnode = new DListNode(item,sentinel,sentinel);
	sentinel.next = newnode;
	sentinel.prev = newnode;
    }else{
    DListNode newnode = new DListNode(item,sentinel.prev,sentinel);
    sentinel.prev.next = newnode;
    sentinel.prev = newnode;
    }
    size ++;
  }

  /**
   *  front() returns the node at the front of this DList.  If the DList is
   *  empty, return null.
   *
   *  Do NOT return the sentinel under any circumstances!
   *
   *  @return the node at the front of this DList.
   *  Performance:  runs in O(1) time.
   */
  public DListNode front() {
    // Your solution here.
    DListNode sentinel = head;
    if(size==0) return null;
    else return sentinel.next;
  }

  /**
   *  back() returns the node at the back of this DList.  If the DList is
   *  empty, return null.
   *
   *  Do NOT return the sentinel under any circumstances!
   *
   *  @return the node at the back of this DList.
   *  Performance:  runs in O(1) time.
   */
  public DListNode back() {
    // Your solution here.
    DListNode sentinel = head;
    if(size == 0) return null;
    else return sentinel.prev;
  }

  /**
   *  next() returns the node following "node" in this DList.  If "node" is
   *  null, or "node" is the last node in this DList, return null.
   *
   *  Do NOT return the sentinel under any circumstances!
   *
   *  @param node the node whose successor is sought.
   *  @return the node following "node".
   *  Performance:  runs in O(1) time.
   */
  public DListNode next(DListNode node) {
    // Your solution here.
    DListNode sentinel = head;
    if(node==null || node.next == sentinel) return null;
    else return node.next;
  }

  /**
   *  prev() returns the node prior to "node" in this DList.  If "node" is
   *  null, or "node" is the first node in this DList, return null.
   *
   *  Do NOT return the sentinel under any circumstances!
   *
   *  @param node the node whose predecessor is sought.
   *  @return the node prior to "node".
   *  Performance:  runs in O(1) time.
   */
  public DListNode prev(DListNode node) {
    // Your solution here.
    DListNode sentinel = head;
    if(node == null || node.prev == sentinel) return null;
    else return node.prev;
  }

  /**
   *  insertAfter() inserts an item in this DList immediately following "node".
   *  If "node" is null, do nothing.
   *  @param item the item to be inserted.
   *  @param node the node to insert the item after.
   *  Performance:  runs in O(1) time.
   */
  public void insertAfter(Object item, DListNode node) {
    // Your solution here.	
    if(node == null) return;
    else{
	DListNode newnode = new DListNode(item,node,node.next);
	node.next.prev = newnode;
	node.next = newnode;
	size ++;
	}
  }

  /**
   *  insertBefore() inserts an item in this DList immediately before "node".
   *  If "node" is null, do nothing.
   *  @param item the item to be inserted.
   *  @param node the node to insert the item before.
   *  Performance:  runs in O(1) time.
   */
  public void insertBefore(Object item, DListNode node) {
    // Your solution here.
    if(node == null) return;
    else{
	DListNode newnode = new DListNode(item,node.prev,node);
	node.prev.next = newnode;
	node.prev = newnode;
	size ++;
	}
  }

  /**
   *  remove() removes "node" from this DList.  If "node" is null, do nothing.
   *  Performance:  runs in O(1) time.
   */
  public void remove(DListNode node) {
    // Your solution here.
    if(node == null) return;
    else{
	node.next.prev = node.prev;
	node.prev.next = node.next;
	size --;
	}
  }

  /**
   *  toString() returns a String representation of this DList.
   *
   *  DO NOT CHANGE THIS METHOD.
   *
   *  @return a String representation of this DList.
   *  Performance:  runs in O(n) time, where n is the length of the list.
   */
  public String toString() {
    if(size == 0) return "Empty List";
    String result = "[  ";
    DListNode current = head.next;
    while (current != head) {
      result = result + current.item + "  ";
      current = current.next;
    }
    return result + "]";
  }


  public static void main(String[] argv){

  DList dlist = new DList();
  Integer i = new Integer(5); 
  Integer j = new Integer(10);
  Integer i1 = new Integer(13);
  Integer j1 = new Integer(20);
  dlist.insertFront(i);
  dlist.insertFront(j);
 

  String s1 = dlist.toString();
  String s2 = dlist.front().toString();
  String s3 = dlist.back().toString();

  dlist.insertBack(j1);
  dlist.insertBack(i1);
  dlist.insertBack(i1);

  DList dlist1 = new DList();

  dlist1.insertBack(i1);
  dlist1.insertFront(i);
  String s4 = dlist.toString();
  String s5 = dlist1.toString();

  DList dlist2 = new DList();
  String s6 = dlist2.toString();
  dlist1.insertBack(j1);
  
  Integer h = new Integer(33);
  DListNode dnode = dlist1.back();
  dlist1.insertAfter(h,dlist1.prev(dnode));

  String s7 = dlist1.toString();

  Integer b = new Integer(44);
  DListNode dnode1 = dlist1.prev(dnode);
  DListNode dnode2 = dlist1.prev(dnode1);
  DListNode dnode3 = dlist1.prev(dnode2);
  dlist1.insertBefore(b,dnode3);

  String s8 = dlist1.toString();

  dlist1.insertBefore(b,dnode2);

 // String s8 = dlist1.toString();
  String s9 = dlist1.toString();

  dlist1.remove(dnode2);

  String s10 = dlist1.toString();

  DListNode dnode4 = dlist1.next(dnode3);
  DListNode dnode5 = dlist1.next(dnode4);

  String s11 = dnode5.toString();

  System.out.println("the dlist now is:"+s1 + " and it should be 10, 5");
  System.out.println("the first item in dlist is:" + s2 + " and it should be 10");
  System.out.println("the last item in dlist is:" + s3 + " and it should be 5");
  System.out.println("the dlist after insertback is:" + s4 + " and it should be 10, 5, 20, 13, 13");
  System.out.println("the dlist1 is:" + s5 + " and it should be 5, 13");
  System.out.println("the dlist2 is:" + s6 + " and it should be an empty list");
  System.out.println("the dlist1 is:" + s7 + " and it should be 5, 13, 33, 20");
  System.out.println("the dlist1 is:" + s8 + " and it should be 44, 5, 13, 33, 20");
  System.out.println("the dlist1 is:" + s9 + " and it should be 44, 5, 44, 13, 33, 20");
  System.out.println("the dlist1 is:" + s10 + " and it should be 44, 5, 44, 33, 20");
  System.out.println("the node5 is:" + s11 + " and it should be 33");
  
 }
}
