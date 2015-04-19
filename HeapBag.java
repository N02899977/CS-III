// Heidi Fritz

/**
 * class HeapBag: a HEAP tree with ARRAY IMPLEMENTATION
 * each array element contains pointer to a BinaryTreeNode
 */
public class HeapBag
{
    private BinaryTreeNode[] h; // array of nodes
    private int next; // pointer or cursor of the HEAP
    
    /**
     * Constructor for class HeapBag: create an array of 100 nodes, set next=0
     * @param  NONE
     * @return   NONE 
     */
    public HeapBag()
    {
    	h = new BinaryTreeNode[100];
    	next = 0;
    }
    
    /**
     * Method to get/read the pointer to a node(in the array element) in this Heap
     * @param  "i" is the index of the element
     * @return   element[i] of the array which contains the pointer to a node 
     */    
    public BinaryTreeNode getNode(int i)
    {
    	return h[i];
    }
    
    /**
     * Method to set/write the pointer to a node(in the array element) in this Heap
     * @param  two: "z" is the node pointer and "i" is the index of the element
     * @return NONE 
     */    
    public void setNode(BinaryTreeNode z,int i)
    {
    	h[i] = z;
    }

    /**
     * Method to get the index of the last element of the HEAP array
     * @param  NONE
     * @return  an integer which is the index of the last element of the HEAP array
     */        
    public int getLast()
    {
    	for(int i =0; i < h.length; i++)
    	{
    		if(h[i] != null)
    		{
    			continue;
    		}
    		else
    		{
    			return i - 1;
    		}
    	}
    	return 0;
    }
         
    /**
     * method "count" - counts how many times a given "key" appears in this HEAP
     * @param: "key"  an integer to compare with node data 
     * @return: the number of times "key" appears in this HEAP 
     */
    public int count(int key)
    {
    	int count = 0;
    	for(int i = 0; i < h.length; i++)
    	{
    		if(h[i] == null)
    			break;
    		else if(key == h[i].getData())
    		{
    			count++;
    		}
    	}
    	return count;
    }

    /**
     * method "search" - check if a given "key" is in this HEAP, stop when it is found
     * @param: "key" in integer to compare with node data 
     * @return: the pointer to the node which contains this "key" in its data 
     */
    public BinaryTreeNode search(int key)
    {   
    	for(int i = 0; i < h.length; i++)
    	{
    		if(key == h[i].getData())
    		{
    			return h[i];
    		}
    	}
    	return null;
    }
     
    /**
     * method "add" - add node "z" to this HEAP
     * @param: "z"   a node to be added
     * @return: NONE 
     */
    public void add(BinaryTreeNode z)
    {
    	h[next] = z;
    	next++;
    	if(next > 1)
    	{
    		int nexti = next - 1;
			while(z.getData() > h[(nexti-1)/2].getData())
			{
				h[nexti] = h[(nexti-1)/2];
				h[(nexti-1)/2] = z;
				nexti = (nexti-1)/2;
			}
    	}
    }
     
    /**
     * method "remove" - remove the root of this HEAP
     * @param:  NONE
     * @return: the old removed root 
     */ 
      
    public BinaryTreeNode remove()
    {
    	BinaryTreeNode oldRoot = h[0];
    	BinaryTreeNode outOfPlace = h[getLast()];
    	h[0] = outOfPlace;
    	int i = 0;
    	setNode(null, getLast());
    	
    	while((h[2*i + 1] != null) && (outOfPlace.getData() < h[2*i + 1].getData()))
    	{
    		// If left child has higher priority than right child, then go left.
    		// Otherwise, go right.
    		if(h[2*i + 2] == null)
    		{
    			h[i] = h[2*i + 1];
    			h[2*i + 1] = outOfPlace;
    			break;
    		}
    		else if(h[2*i + 1].getData() >  h[2*i + 2].getData())
    		{
    			h[i] = h[2*i + 1];
    			h[2*i + 1] = outOfPlace;
    			i = 2*i + 1;
    		}
    		else
    		{
    			h[i] = h[2*i + 2];
    			h[2*i + 2] = outOfPlace;
    			i = 2*i + 2;
    		}
    	}
    	return oldRoot;
    }  
    
    /**
     * method "connectNodes": set all left and right links (parent to children)of all nodes in this HEAP
     *                   using rules: Left child of node (i) is at (2*i+1) and Right child is at (2*i+2)
     *                   [0, 1, 2, 3, 4, 5, 6]
     *                   2*0 + 1 = 1 (left of node 0)
     *                   2*0 + 2 = 2 (right of node 0)
     *                   
     *                   2*1 + 1 = 3 (left of node 1)
     *                   2*1 + 2 = 4 (right of node 1)
     *                   
     *                   2*2 + 1 = 5 (left of node 2)
     *                   2*2 + 2 = 6 (right of node 2)
     *                   
     *                    0
     *                  1   2
     *                 3 4 5 6
     *                   
     * @param: none 
     * @return: none
     */
	public void connectNodes()
    {   
		BinaryTreeNode btn = null;
		for(int i = 0; i < h.length; i++)
		{
			btn = h[i];
			if(h[i] == null)
			{
				break;
			}
			else if(i == 0)
			{
				btn.setLeft(h[2*i + 1]);
				btn.setRight(h[2*i + 2]);
			}
			else
			{
				if(h[2*i + 1] != null)
				{
				   btn.setLeft(h[2*i + 1]);
				}
				if(h[2*i + 2] != null)
			    {
				   btn.setRight(h[2*i + 2]);
			    }
			}
		}
	} 
}
    
