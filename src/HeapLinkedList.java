import java.util.LinkedList;
import java.util.Queue;

class HeapLinkedList{
    Node root;
    
    void addHeap(int inputData){
        Node input = new Node(inputData);
        if(root == null) {
            root = input;
            return;
        }

        Node parrentInput = findNextParrentInput();
        if(parrentInput.left == null)
            parrentInput.left = input;
        else   
            parrentInput.right = input;
        input.parrent = parrentInput;

        findCorrectPlaceAfterAdd(input);
    }

    void removeHeap(){
        Node lastNode = findLastNode();
        if(lastNode == root){
            root = null;
            return;
        }
        swap(lastNode, root);
        if(lastNode.parrent.left == lastNode)
            lastNode.parrent.left = null;
        else
            lastNode.parrent.right = null;

        findCorrectPlaceAfterRemove(root);
    }


    int peekHeap() {
        return root.data;
    }

    boolean isEmpty(){
        return root == null;
    }

    void tampilkan(Node now) {
        if(now == null) return;
        System.out.print(now.data + " : ");
        if(now.left != null){
            System.out.print("kiri : " + now.left.data + " ");
        }
        if(now.right != null){
            System.out.print("kanan : " + now.right.data);
        }
        System.out.println();
        tampilkan(now.left);
        tampilkan(now.right);
    }

    // method bantuan
    private Node findNextParrentInput() {
        Node nodeHasNoChild = new Node();
        Queue<Node> myQueue = new LinkedList<>();

        myQueue.add(root);

        while(!myQueue.isEmpty()){
            Node now = myQueue.peek();
            myQueue.remove();
            if(now.left == null && nodeHasNoChild.data == -1){
                nodeHasNoChild = now;
            }
            if(now.left !=null && now.right == null)
                return now;

            if(now.left != null) myQueue.add(now.left);
            if(now.right != null) myQueue.add(now.right);
        }
        return nodeHasNoChild;
    }

    private void findCorrectPlaceAfterAdd(Node input) {
        while(input.parrent.data < input.data){
            swap(input.parrent, input);

            input = input.parrent;
            if(input.parrent == null) return;
        }
    }

    private Node findLastNode() {

        Queue<Node> myQueue = new LinkedList<>();
        myQueue.add(root);
        Node now = new Node();

        while(!myQueue.isEmpty()){
            now = myQueue.peek();
            myQueue.remove();
            if(now.left != null) myQueue.add(now.left);
            if(now.right != null) myQueue.add(now.right);
        }
        return now;
    }

    private void swap(Node a, Node b){
        int tmp = a.data;
        a.data = b.data;
        b.data = tmp;
    }

    private void findCorrectPlaceAfterRemove(Node input) {
        Node maxim = input;
        do{
            input = maxim;
            if(input.left != null)
                if(input.left.data > maxim.data)
                    maxim = input.left;
            if(input.right != null)
                if(input.right.data > maxim.data)
                    maxim = input.right;
            swap(maxim, input);
            
        }while(maxim != input);
    }
}