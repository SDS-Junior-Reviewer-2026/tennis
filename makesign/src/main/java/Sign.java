import java.util.ArrayList;
import java.util.Comparator;

class Node {
    public int dateCode;
    public String name;

    public Node(int dateCode, String name) {
        this.dateCode = dateCode;
        this.name = name;
    }
}

public class Sign {
    void makeSign(ArrayList<Node> signList) throws Exception {
        //2. valid 검사
        if (doesInvalidPageExist(signList)) {
            throw new Exception();
        }
        //1. 서명 정렬하기
        orderSignList(signList);
        doSign(signList);
    }

    boolean doesInvalidPageExist(ArrayList<Node> signList) {
        for (Node target : signList) {
            if (target.dateCode <= 0 || target.dateCode >= 10) { return true; }
        }
        return false;
    }

    void orderSignList(ArrayList<Node> signList) {
        signList.sort(Comparator.comparingInt(node -> node.dateCode));
    }

    void doSign(ArrayList<Node>signList) {
        for (Node target : signList) {
            System.out.println(target.dateCode + " : " + target.name);
        }
    }

    public static void main(String[] args) {
        Sign sign = new Sign();
        ArrayList<Node> arr = new ArrayList<>();
        arr.add(new Node(5, "KFC"));
        arr.add(new Node(1, "JASON"));
        arr.add(new Node(2, "LUCKY"));

        try {
            sign.makeSign(arr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}