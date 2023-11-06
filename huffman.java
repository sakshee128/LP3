import java.util.PriorityQueue;

class MinHeapNode {
    char data;
    int freq;
    MinHeapNode left, right;

    MinHeapNode(char data, int freq) {
        left = right = null;
        this.data = data;
        this.freq = freq;
    }
}

class huffman {
    static void printCodes(MinHeapNode root, String str) {
        if (root == null) {
            return;
        }
        if (root.data != '$') {
            System.out.println(root.data + ": " + str);
        }
        printCodes(root.left, str + "0");
        printCodes(root.right, str + "1");
    }

    static class Compare implements java.util.Comparator<MinHeapNode> {
        public int compare(MinHeapNode a, MinHeapNode b) {
            return a.freq - b.freq;
        }
    }

    static void buildHuffmanTree(char data[], int freq[], int size) {
        MinHeapNode left, right, temp;
        PriorityQueue<MinHeapNode> minHeap = new PriorityQueue<>(new Compare());

        for (int i = 0; i < size; i++) {
            minHeap.add(new MinHeapNode(data[i], freq[i]));
        }

        while (minHeap.size() > 1) {
            left = minHeap.poll();
            right = minHeap.poll();
            temp = new MinHeapNode('$', left.freq + right.freq);
            temp.left = left;
            temp.right = right;
            minHeap.add(temp);
        }
        printCodes(minHeap.peek(), "");
    }

    public static void main(String[] args) {
        char data[] = { 'A', 'B', 'C', 'D' };
        int freq[] = { 23, 12, 34, 10 };
        buildHuffmanTree(data, freq, 4);
    }
}