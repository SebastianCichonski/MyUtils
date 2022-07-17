import OneWayLists.OneWayList;

public class TestList {
    public static void main(String[] args) {
        OneWayList list = new OneWayList();
        list.addLast(3).addLast(12).addLast(7).show();
        list.addLast(6).addLast(0).addLast(4).addLast(2).show();
        list.addLast(7).addLast(11).addLast(5).show();
        list.delLast().delLast().show();
        list.addFirst(13).addFirst(14).addFirst(23).addFirst(56).addFirst(7).show();
        list.delFirst().delFirst().delFirst().show();

    }
}
