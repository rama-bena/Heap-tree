

public class Node{

    int data;
    Node parrent;
    Node left;
    Node right;

    Node (){
        data = -1;
        parrent = left = right = null;
    }

    Node(int data) {
        this.data = data;
    }
}