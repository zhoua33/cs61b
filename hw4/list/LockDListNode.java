
package list;

class LockDListNode extends DListNode{
   private boolean lock;

   public LockDListNode(Object i, DListNode p, DListNode n){
	super(i,p,n);
	lock = false;
   }

   public void setLock(){
	this.lock = true;
   }

  public boolean checkLock(){
	return this.lock;
  }
}

   
