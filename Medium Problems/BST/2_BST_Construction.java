
//The remove function is the most painful that I coded;
//It is rather infefficient and full of redundant code;
//It was a first iteration, which requires me to go back and study deletion and better implementations (recursion)
// On one side happy to be done with this, on the other aware of my limited understandings.
//I hope to continue the study, and not let my limitations bring me down and push me to abandon the study of algos.
//I shall not give up and let the right principle (love for study, and its application) be the water of 
//desert journeys.
// - Martin
import java.util.*;

class Program {
  static class BST {
    public int value;
    public BST left;
    public BST right;
		private BST head;
		 
    public BST(int value) {
			this.value = value;
			
	    }

    public BST insert(int value) {
      // Write your code here.
      // Do not edit the return statement of this method.
			System.out.println(this.value);
			head = this;
			
	while(true){
		//go left of parent if value < than parent
		if(value < head.value){
			//if not null, keep going down the tree 
			if(head.left !=null){
				head= head.left;
				System.out.println(head.value);

			}//null, insert new element here
			else{
				head.left= new BST(value);
						System.out.println(head.value);

				break;}
			} //go right if val >= to parent
		else{
			// keep going down the tree if not null
			if(head.right!=null){
				head= head.right;
				System.out.println(head.value);

			}//right= null, create new element ere 
			else{
				head.right = new BST(value); 
				System.out.println(head.value);

				break;}
		}
	}						
      return this;
    }

    public boolean contains(int value) {
      // Write your code here.
			//root node
			head= this;
			
			while(true){
				//value match
				if(head.value == value){
					return true;
				}//trasverse tree left (granted there elements, if not no match)
				else if(value < head.value){
					if(head.left != null){
						head= head.left;
					}else{return false;}
				}//trasverse tree right (granted there are elements)
				else{
					if(head.right != null){
						
						head= head.right;
					}else{
						return false;
					}
				}
			}
    }

    public BST remove(int value) {
      // Write your code here.
			//Tricky code, because (silly set up by problem)
			head =this;
			
			//Delete root parent
				if(value == this.value){
					//if both children null, do nothing
					if(head.left== null && head.right==null){
						return this;
					}//right child is null
					else if(head.right==null && head.left != null){
						//find max on left side, replace this.value with max, 
						//& delete max previous position (check for children)
						this.value = maxi(head);
						
					} //right is not null, or neiter is null
					else{
						//find min on right side, replace this.value, with min, delete min
						this.value = mini(head);

					}
				}	//Delete another element 
			//Check if element is present
			else{
				
			//check if the value is there in the first place
			if(contains(value)){
				BST	a= this;
				BST	b=this;
				int flag=0;
				int dir=0;
				
				while(true) {
					//go left
					if(value < b.value){
						if(flag==0){
							b=b.left;
						flag=1;
						}else{
                                                    a=b;
							b=b.left;
							
						}
						dir=0;					
				}
					//go right
					else if(value>b.value){
						if(flag==0){
							b=b.right;
						flag=1;
						}else{
                                                    a=b;
							b=b.right;
							
						}
						dir =1;
						
					}
					//hit value
					else{
						//zero children;
						if(b.left== null && b.right==null){
							if(dir==0){
								a.left=null;
							}else{
								a.right= null;
							}
						}
						//1 child
						else if (b.left!=null && b.right==null){
								if(dir==0){
								a.left= b.left;
								}
								else{
									a.right= b.left;
								}
							
						}
						//right child or 2 children
						
						else{
								if(dir==0){
                                                                   
									Integer temporary = 	minimum(b);
                                                                        if(temporary!=null){
                                                                          
                                                                            a.left.value=temporary;
                                                                           
                                                                         
                                                                        }else{
                                                                        a.left=null;}

                                                                        //duplicate
//                                                                        if(a.left.value ==value){
//                                                                            no_break=true;
//                                                                            a=this;b=this;
//                                                                            flag=0;
//                                                                            dir=0;}
									
								}
								else{
                                                                    Integer temporary2 = 	minimum(b);
                                                                        if(temporary2!=null){
                                                                            	a.right.value=temporary2;

                                                                        }else{
                                                                       a.right=null;}
                                                                        
									
								}
							
						}
                                               
                                                break;
                                                
					}
				
				}
				
				
			}
				}		
		
      return this;
    }
		
		// in case of deleting the first element (specied in problem)
		//fin max 
	public Integer maximum (BST temp){
                        int c;
                        BST a= temp;
                        BST b = temp.left;
                        //both chilredn are null
                        if(b.left == null && b.right == null){
                        c= b.value;
                        b=null;
                        return c;
                        } //only left child
                        else if(b.left!=null && b.right==null){
                            c= b.value;
                            a.left = b.left;
                            return c;
                        }//both children, or only right child
                        else{
                            //get to the end
                            while( b.right!=null){
                                a= b;
                                b= b.right;
                        }
                            //in case value to del, has a left child (right child will always be max)
                            if(b.left!=null){
                                c= b.value;
                                a.right = b.left;
                                return c;

                            }else{
                            c= b.value;
                            a.right= null;
                            return c;
                            }
                        }   
	}
		//return min (when deleting a node with 2 childre, this will provide the
		//min value present on the right child; this min will become new parent)
		public Integer minimum (BST temp ){
			int c;
                        BST a= temp;
                        BST b = temp.right;
                        
                        //both chilredn are null
                        if(b.left == null && b.right == null){
                        c= b.value;
                        a.right=null;
                        b=null;
                        return c;
                        } //only left child
                        else if(b.left==null && b.right!=null){
                            c= b.value;
                            a.right = b.right;
                            return c;
                        }//both children, or only right child
                        else{
                            //get to the end
                            while( b.left!=null){
                                a= b;
                                b= b.left ;
                        }
                            //in case value to del, has a left child (right child will always be max)
                            if(b.right!=null){
                                c= b.value;
                                a.left = b.right;
                                return c;

                            }else{
                            c= b.value;
                            a.left= null;
                            return c;
                            }
                        }   
			
		}
			
	public Integer mini (BST b ){
			int c;
                        BST a= b;
                       b= b.right;
                        //both chilredn are null
                        if(b.left == null && b.right == null){
                        c= b.value;
                        a.right=null;

                        b=null;
                        return c;
                        } //only left child
                        else if(b.left==null && b.right!=null){
                            c= b.value;
                            a.right = b.right;
                            return c;
                        }//both children, or only right child
                        else{
                            //get to the end
                            while( b.left!=null){
                                a= b;
                                b= b.left ;
                        }
                            //in case value to del, has a left child (right child will always be max)
                            if(b.right!=null){
                                c= b.value;
                                a.left = b.right;
                                return c;

                            }else{
                            c= b.value;
                            a.left= null;
                            return c;
                            }
                        }   
			
		}			
  
  public Integer maxi (BST temp){
                        int c;
                        BST a= temp;
                        BST b = temp.left;
                        //both chilredn are null
                        if(b.left == null && b.right == null){
                        c= b.value;
                        a.left= null;
                        b=null;
                        return c;
                        } //only left child
                        else if(b.left!=null && b.right==null){
                            c= b.value;
                            a.left = b.left;
                            return c;
                        }//both children, or only right child
                        else{
                            //get to the end
                            while( b.right!=null){
                                a= b;
                                b= b.right;
                        }
                            //in case value to del, has a left child (right child will always be max)
                            if(b.left!=null){
                                c= b.value;
                                a.right = b.left;
                                return c;

                            }else{
                            c= b.value;
                            a.right= null;
                            return c;
                            }
                        }   
	}
  
    

     
     }
   public static void main(String[] args) {
         
        Program tree = new Program();
        BST root = new BST(10);
        System.out.println("Building tree with root value " + root.value);
        
        
        root.insert(5);
        root.insert(15);
        root.insert(2);
        root.insert(5);
        root.insert(13);
        root.insert(22);
        root.insert(12);
        root.insert(14);
        
       
        root.remove(5);

     }
}