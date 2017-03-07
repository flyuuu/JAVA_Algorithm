
public class BTree{

    class Node{
        int data;
        Node lchild;
        Node rchild;

        public Node(int data){
            this.data = data;
            this.lchild = null;
            this.rchild = null;
        }
    }

    private Node root = null;

    public void insertNode(Node node, int data){
        if(root == null){
            root = new Node(data);
        }else{
            if(data<node.data){
                if(node.lchild==null){
                    node.lchild = new Node(data);
                }else{
                    insertNode(node.lchild,data);
                }
            } else {
                if(node.rchild == null){
                    node.rchild = new Node(data);
                }else{
                    insertNode(node.rchild,data);
                }

            }
        }
    }

    public void creataTree(int[] arr){
        for (int i=0; i<arr.length; i++) {
            insertNode(root,arr[i]);
        }
    }

    public static void preOderSort(Node node){
        if(node!=null){
            System.out.println(node.data);
            preOderSort(node.lchild);
            preOderSort(node.rchild);
        }
    }
    public static void inOderSort(Node node){
        if(node!=null){
            inOderSort(node.lchild);
            System.out.println(node.data);
            inOderSort(node.rchild);
        }
    }
    public static void postOderSort(Node node){
        if(node!=null){
            postOderSort(node.lchild);
            postOderSort(node.rchild);
            System.out.println(node.data);
        }
    }

}
