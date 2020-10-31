import java.util.*;
/**
 * Trees without explicit links.
 * Notice that various fields/methods have the protected modifier
 * when normally they would/should be private.
 * The reason is that this supports whitebox testing.
 *
 * @author Stefan Kahrs
 * @version 1
 */
//note the constraint on A is a slight generalisation of A extends Comparable<A>
//and is generally recommended when one wants a comparison operation
//it basically allows that the comparison op is implemented at a supertype
//of A, instead of A itself;
//for the assessment itself it makes no discernable difference
public class LinklessTree<A extends Comparable<? super A>>
{
    //sizes of subtrees at that node index
    protected int[] sizes;
    protected Object[] elems;
    //for annoying technical reason this has to be an array of objects

    /**
     * Constructor for objects of class LinklessTree
     */
    private static final int STARTSIZE=15;
    public LinklessTree()
    {
        assert STARTSIZE>0;
        elems = freshElemArray(STARTSIZE);
        sizes = new int[STARTSIZE];
        sizes[0]=0; 

    }
    //size of whole tree is the size of the subtree rooted at 0
    public int size()
    {
        return getSize(0);
    }

    public A getValue(int index) 
    {
        return (A)elems[index];
    }

    //auxiliary methods to index the arrays out of bounds too
    //they may help to reduce case distinctions
    protected A getKey(int subtree) 
    {
        if (subtree>=elems.length) 
            return null; // out of bounds
        return getValue(subtree);
    }

    protected int getSize(int subtree) 
    {
        if (subtree>=elems.length) 
            return 0; // out of bounds
        return sizes[subtree];
    }

    //encapsulates the cast on the allocation
    protected Object[] freshElemArray(int capacity) 
    {
        return new Object[capacity];
    }

    //remainder needs to be modified
    /**
     * @author Wai Shan (Karen ) Yip
     */

    //find index position of val in tree, if there, or where it goes, if not there
    protected int findIndex(A val) 
    {
        int i=0;
        while(i<elems.length)
        {
            if(elems[i]==null)
            {
                return i;
            }
            if((val.compareTo((A)elems[i])) == 0)
            {
                return i;
            }
            else if((val.compareTo((A)elems[i])) <0)
            {
                i=2*i+1;
            }
            else
            {
                i=2*i+2;
            }

        }
        return i;
    }

    //is value in tree
    public boolean contains(A val) 
    {
        int i=0; 
        boolean contains = false;
        while (i<elems.length)
        {
            if(elems[i] == null)
            {
                return contains;
            }
            if((val).compareTo((A)elems[i])==0)
            {
                contains=true;
            }
            if((val).compareTo((A)elems[i])<0)
            {
                i=2*i+1;  
            }
            else
            {
                i=2*i+2;
            }

        }
        return contains;
    }

    //grow the space in which we can pce the tree, so that at least one insertion will succeed
    protected void grow() 
    {
        Object[] elems2 = freshElemArray(elems.length*2);
        System.arraycopy(elems, 0, elems2, 0, elems.length);
        elems= elems2;
        int[] sizes2 = new int [sizes.length*2];
        System.arraycopy(sizes, 0, sizes2, 0, sizes.length);
        sizes= sizes2;
    }

    //fetch the i-th element, in comparsion order
    public A get(int i)
    {  
        ArrayList<A>elems2 = new ArrayList<>();
        for(int a=0; a<elems.length;)
        {
            if(getValue(a) !=null && !elems2.contains(getValue(a)))
            {
                elems2.add(getValue(a));
            }
            a=2*a+1;
        }
        for(int b=0; b<elems.length;)
        {
            if(getValue(b) !=null && !elems2.contains(getValue(b)))
            {
                elems2.add(getValue(b));   
            }
            b=2*b+2;
            if(i>elems2.size()-1)
            {
                elems2.add(getValue(b));
            }
        }
        Collections.sort(elems2);
        return (A)elems2.get(i); 
    }

    //add x to tree, return true if tree was modified
    //we do not allow multiple copies of the equal objects in tree
    //equality is decided by using compareTo
    public boolean insert(A x)
    { 

        for(int i=0; i<elems.length; i++)
        {
            if(elems[i] == x)
            {
                return false;
            }
        }
        int i= 0;
        while(i<elems.length)
        {

            if(elems[i]==null)
            {
                elems[i]=x;
                int currentRow=1;
                int endRow=0;
                while(i>endRow)
                {
                    endRow= 2*endRow+2;
                    currentRow++;
                }
                int j=0;
                for(int a=0; a<currentRow; a++)
                {
                    sizes[j]++;
                    if(getValue(i).compareTo(getValue(j)) <0)
                    {
                        j=2*j+1;   
                    }
                    else
                    {
                        j=2*j+2;   
                    }
                }
                return true;
            }

            else if((x).compareTo((A)elems[i]) <0)
            {
                i=2*i+1;
            }
            else
            {
                i=2*i+2;
            }
            if(i>=elems.length)
            {
                grow();   
            }
        }
        return false; 
    }

    //remove x from tree, return true if tree was modified
    public boolean delete(A x)
    {
        if(!contains(x))
        {
            return false;    
        }
        return false;
    }

    //not requested, but these might be useful auxiliary ops for delete
    private A deleteLargest(int subtree) 
    { 
        return null; 
    }

    private A deleteSmallest(int subtree) 
    { 
        return null; 
    }
}
