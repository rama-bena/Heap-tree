class MainClass{
    public static void main(String[] args) {
        
        HeapLinkedList heap = new HeapLinkedList();

        for (int i = 0; i < 10; i++) {
            heap.addHeap((int)(Math.random() * 100) + 1);
        }
        heap.tampilkan(heap.root);

        while(!heap.isEmpty()){
            System.out.print(heap.peekHeap() + " ");
            heap.removeHeap();
        }
    }
}