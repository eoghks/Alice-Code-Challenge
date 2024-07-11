import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Node> map = makeTree(n, sc);

        for(int i=1; i <= n; i++) {
            play(map.get(i));
        }
        sc.close();
    }
    
    public static class Node{
        public int val;
        public List<Node> nextNode = new ArrayList<Node> ();

        public Node(int val) {
            this.val = val;
        }
    }

    public static Map<Integer, Node> makeTree (int n, Scanner sc) {
        Map<Integer, Node> map = new HashMap<>();
        map.put(1, new Node(1));

        for(int i=1; i< n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            Node uNode = map.get(u);
            Node vNode = map.get(v);

            if(uNode == null) {
                uNode = new Node (u);
                vNode.nextNode.add(uNode);
                map.put(u, uNode);
            } else if(vNode == null) {
                vNode = new Node(v);
                uNode.nextNode.add(vNode);
                map.put(v, vNode);
            } 
        }

        return map;
    }

    public static void play(Node n) {
        if(check(n, 0, 0, 1)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static boolean check(Node n, int first, int second, int depth) {
        if(depth %2 == 1) {
            first += n.val;
        } else {
            second += n.val;
        }

        if(n.nextNode.size() == 0){
            return first>= second;
        }

        boolean result = false;
        for(Node next: n.nextNode) {
            if(check(next, first, second, depth+1)){
                result = true;
                break;
            }
        } 
        return result;
    }
}
