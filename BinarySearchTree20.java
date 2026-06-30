public class BinarySearchTree20 {
    Node20 root;

    public BinarySearchTree20() {   // FIX 1: samakan persis dengan nama class
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void add(int value) {
        Node20 baru = new Node20(null, value, null);

        if (isEmpty()) {
            root = baru;
        } else {
            Node20 current = root;
            Node20 parent;
            while (true) {
                parent = current;
                if (value < current.value) {
                    current = current.left;
                    if (current == null) {
                        parent.left = baru;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = baru;
                        return;
                    }
                }
            }
        }
    }

    // mencari apakah suatu nilai ada di dalam tree
    public boolean find(int value) {
        Node20 current = root;
        while (current != null) {
            if (value == current.value) {
                return true;
            } else if (value < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    // menampilkan tree dengan traversal preorder (root, left, right)
    public void traversePreOrder(Node20 node) {
        if (node != null) {
            System.out.print(node.value + " ");
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    // menampilkan tree dengan traversal inorder (left, root, right)
    public void traverseInOrder(Node20 node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(node.value + " ");
            traverseInOrder(node.right);
        }
    }

    // menampilkan tree dengan traversal postorder (left, right, root)
    public void traversePostOrder(Node20 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(node.value + " ");
        }
    }

    public Node20 getSuccessor(Node20 del) {
        Node20 successorParent = del;
        Node20 successor = del;
        Node20 current = del.right;

        while (current != null) {
            successorParent = successor;
            successor = current;   // FIX 2: harusnya "current", bukan "parent"
            current = current.left;
        }

        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }

        return successor;
    }

    // menghapus node dengan nilai tertentu dari tree
    public void delete(int value) {
        if (isEmpty()) {   // FIX 3: tambahkan kurung, karena ini method bukan variabel
            System.out.println("Tree masih kosong, tidak ada yang bisa dihapus!");
            return;
        }

        Node20 parent = root;
        Node20 current = root;
        boolean isLeftChild = false;

        // mencari posisi node yang akan dihapus
        while (current.value != value) {
            parent = current;
            if (value < current.value) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }

            if (current == null) {
                System.out.println("Node dengan nilai " + value + " tidak ditemukan.");
                return;
            }
        }

        // kasus 1: node yang dihapus tidak memiliki anak (leaf)
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (current.right == null) { // kasus 2: hanya memiliki 1 anak (kiri)
            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) { // kasus 2: hanya memiliki 1 anak (kanan)
            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else {
            // kasus 3: memiliki 2 anak, gunakan inorder successor
            Node20 successor = getSuccessor(current);

            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }

            successor.left = current.left;
        }
    }

    // menghitung jumlah seluruh node yang ada di dalam tree
    public int countNode(Node20 node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNode(node.left) + countNode(node.right);
    }
}