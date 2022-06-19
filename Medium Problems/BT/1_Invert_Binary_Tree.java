Time: O(n) 
Space: O(d) , depth of tree 
public static void invertBinary(BST tree){
              
          //both null, end of tree
          if(tree.left == null && tree.right== null){
          return;
          }
          
          //two children, swap;
          if(tree.left!=null && tree.right!=null){
         //Swap 
         BST temp = tree.left;
         tree.left= tree.right;
         tree.right= temp;
          }

          int flag=0;

          // only one child
          if(tree.left!=null && tree.right==null)
	{
          tree.right=tree.left;
          tree.left=null;
          flag=1;
	}
                    // only one child
          if(tree.left==null && tree.right!=null && flag==0)	
	{
          tree.left=tree.right;
          tree.right=null;
          
         }
          
          if(tree.left!=null )
	{
          invertBinary(tree.left);
          
        }
       
	   if(tree.right!=null)
	{
          invertBinary(tree.right);
        }

          }
//Test
public static void main(String[] args) {

            Program tree = new Program();
            BST root = new BST(20);
                   
            root.insert(10);
            root.insert(30);
            root.insert(7);
            root.insert(15);
            root.insert(25);
            root.insert(35);
            root.insert(6);
            root.insert(9);
            root.invertBinary(root);
         
        }

//The above code is too cluttered, it can be simplified to 
public static void invertBinary(BST tree){
              
          //both null, end of tree
          if(tree.left == null && tree.right== null){
          return;
          }
          
           
         //Swap 
         BST temp = tree.left;
         tree.left= tree.right;
         tree.right= temp;
                  
          if(tree.left!=null ){
          invertBinary(tree.left);
         }
       
	   if(tree.right!=null){
          invertBinary(tree.right);
        }

          }