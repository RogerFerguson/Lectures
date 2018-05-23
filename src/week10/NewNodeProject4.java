package week10;

public class NewNodeProject4 {
    private int cn;
    private Nodea<String> next;

    public NewNodeProject4(int cn, Nodea<String> next) {
        this.cn = cn;
        this.next = next;
    }

    public NewNodeProject4(Nodea<String> next) {
        this.next = next;
    }

    public int getCn() {
        return cn;
    }

    public void setCn(int cn) {
        this.cn = cn;
    }

    public Nodea<String> getNext() {
        return next;
    }

    public void setNext(Nodea<String> next) {
        this.next = next;
    }
}
