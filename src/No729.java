public class No729 {
    public static void main(String[] args) {
        No729 obj = new No729();
        MyCalendar temp = new MyCalendar();
        System.out.println(temp.book(1, 4));
        System.out.println(temp.book(3, 4));
        System.out.println(temp.book(5, 9));
        MyCalendar.LinkedList head = temp.head;
        while (head != null) {
            System.out.printf("s : %s, e : %s\n", head.start, head.end);
            head = head.next;
        }
    }


    static class MyCalendar {

        LinkedList head;

        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            LinkedList temp = head;
            if (temp == null) {
                temp = new LinkedList(start, end);
                return true;
            }
            while (temp != null) {
                if (start >= temp.start && end <= temp.end) {
                    return false;
                } else if (temp.end < end && temp.start < end) {
                    LinkedList t = new LinkedList(temp.start, temp.end);
                    temp.start = start;
                    temp.end = end;
                    LinkedList s = temp.next;
                    temp.next = t;
                    t.next = s;
                    return true;
                } else {
                    temp = temp.next;
                }
            }
            return true;
        }


        class LinkedList {

            public LinkedList(int start, int end) {
                this.start = start;
                this.end = end;
            }

            int start;
            int end;
            LinkedList next;
        }
    }
}
