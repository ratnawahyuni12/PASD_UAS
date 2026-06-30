public class BinarySearchTreeMain20 {
    public static void main(String[] args) {
        BinarySearchTree20 tree = new BinarySearchTree20();

        // membangun tree awal sesuai soal uas
        tree.add(63);
        tree.add(15);
        tree.add(98);
        tree.add(13);
        tree.add(20);
        tree.add(89);
        tree.add(112);
        tree.add(11);
        tree.add(14);
        tree.add(16);
        tree.add(25);
        tree.add(72);
        tree.add(95);

        System.out.println("===- Tree Awal -===");
        System.out.print("PreOrder  : ");
        tree.traversePreOrder(tree.root);
        System.out.println();
        System.out.print("InOrder  : ");
        tree.traverseInOrder(tree.root);
        System.out.println();
        System.out.print("PostOrder  : ");
        tree.traversePostOrder(tree.root);
        System.out.println();

        // 1. sisipkan satu node baru dengan nilai dari dua digit terakhir nim (82)
        int nodeBaru = 82;
        tree.add(nodeBaru);
        System.out.println("\n===- Setelah Insert Node " + nodeBaru + " -===");
        System.out.print("InOrder   : ");
        tree.traverseInOrder(tree.root);
        System.out.println();

        // 2. Hapus node dengan nilai 98 (memiliki dua anak, gunakan inorder successor)
        tree.delete(98);
        System.out.println("\n===- Setelah Delete Node 98 -===");
        System.out.print("PreOrder  : ");
        tree.traversePreOrder(tree.root);
        System.out.println();
        System.out.print("InOrder   : ");
        tree.traverseInOrder(tree.root);
        System.out.println();
        System.out.print("PostOrder : ");
        tree.traversePostOrder(tree.root);
        System.out.println();

        // 3. Hitung dan tampilkan jumlah total node dalam tree akhir
        int jumlahNode = tree.countNode(tree.root);
        System.out.println("\nJumlah total node dalam tree akhir: " + jumlahNode);
    }
}