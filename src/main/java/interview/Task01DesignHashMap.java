package interview;

public class Task01DesignHashMap {

    /*
1/) Design a hashmap for me
- get(int key)
- put(int key, int value)
- delete(int key)

put(k1, v1)
put(k1, v2)
get(k1) -> v2

2.) Design a concurrent hashmap
*/
//  Posible solution
//    public class HashMap1 {
//
//
//        private static final double LOAD_FACTOR = 0.75;
//        private Node[] nodes;
//        private int size;
//
//        public class HashMap() {
//            nodes = new Node[8];
//            size = 0;
//        }
//
//
//        public void put(int key, int value) {
//            int idx = hash(key);
//            Node curr = nodes[idx];
//            while (curr != null) {
//                if (curr.key == key) {
//                    curr.value = value;
//                    return;
//                }
//                curr = curr.next;
//            }
//
//            Node newNode = new Node(key, value);
//            newNode.next = nodes[idx];
//            nodes[idx] = newNode; //newNode is now the head for that linked list
//
//            size++;
//
//            double loadFactor (double) size / nodes.length;
//            if (loadFactor > LOAD_FACTOR) {
//                rehash();
//            }
//        }
//
//        private int hash(int key) {
//            return key % nodes.length;
//        }
//
//
//        class Node {
//            int key;
//            int value;
//            Node next;
//
//            public Node(int key, int value) {
//                this.key = key;
//                this.value = value;
//            }
//        }
//
//    }

    public static class HashMap {

        static class Node {
            int key;
            int value;

            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        // 0.7
        private static final double LOAD_FACTOR = 0.7;
        private static final int GROW_FACTOR = 2;

        private static final int DEFAULT_SIZE = 8;
        private IntLinkedList[] buckets;
        private int size = 0;

        public HashMap() {
            this.buckets = new IntLinkedList[8];
        }

        private void initBuckets() {
            for (int i = 0; i < buckets.length; i++) {
                this.buckets[i] = new IntLinkedList();
            }
        }

        public int get(int key) {
            IntLinkedList bucket = buckets[key % buckets.length];
            Node node = bucket.get(key);
            return node != null ? node.value : -1;
        }

        public void put(int key, int value) {
            if (size >= buckets.length * LOAD_FACTOR) {
                growHashMap();
            }
            IntLinkedList bucket = buckets[key % buckets.length];


            int index = bucket.indexOf(key);
            if (index != -1) {
                bucket.set(key, value);
            } else {
                bucket.addLast(key, value);
                size++;
            }
        }

        public boolean delete(int key) {
            IntLinkedList bucket = buckets[key % buckets.length];
            boolean isDeleted = bucket.delete(key);
            if (isDeleted) {
                size--;
            }
            return isDeleted;
        }

        //linkedlist hashmap will be unbalanced if you don't resize
        private void growHashMap() {
            IntLinkedList[] oldBuckets = this.buckets;
            this.buckets = new IntLinkedList[oldBuckets.length * 2];
            initBuckets();
            for (IntLinkedList bucket : oldBuckets) {
                Node root = bucket.root;
                while (root != null) {
                    put(root.key, root.value);
                    root = root.next;
                }
            }
        }

    }

    static class IntLinkedList {

        HashMap.Node root;

        HashMap.Node get(int key) {
            HashMap.Node root = this.root;
            while (root != null) {
                if (root.key == key) {
                    return root;
                }
                root = root.next;
            }
            return null;
        }

        boolean delete(int key) {
            HashMap.Node dummy = new HashMap.Node(-1, -1);
            HashMap.Node prev = dummy;
            prev.next = root;
            // dummy -> root -> next -> next.next
            //Node prev = new Node(-1, -1)
            //prev.next = root;
            while (prev.next != null) {
                if (prev.next.key == key) {
                    prev.next = prev.next.next;
                    if (prev == dummy) {
                        root = prev.next;
                    }
                    return true;
                }
                prev = prev.next;
            }
            return false;
        }

        boolean set(int key, int value) {
            HashMap.Node root = this.root;
            while (root != null) {
                if (root.key == key) {
                    root.value = value;
                    return true;
                }
                root = root.next;
            }
            return false;
        }

        void addLast(int key, int value) {
            HashMap.Node currentRoot = root;
            if (currentRoot != null) {
                while (currentRoot.next != null) {
                    currentRoot = currentRoot.next;
                }
                currentRoot.next = new HashMap.Node(key, value);
            } else {
                this.root = new HashMap.Node(key, value);
            }
        }

        int indexOf(int key) {
            HashMap.Node currentRoot = root;
            if (currentRoot != null) {
                if (currentRoot.key == key) {
                    return 0;
                }

                int index = 1;
                while (currentRoot.next != null) {
                    if (currentRoot.next.key == key) {
                        return index;
                    }
                    currentRoot = currentRoot.next;
                    index++;
                }
            }

            return -1;
        }

    }
}
