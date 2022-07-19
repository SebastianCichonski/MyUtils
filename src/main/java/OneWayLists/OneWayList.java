package OneWayLists;

import org.jetbrains.annotations.NotNull;

public class OneWayList {
    private Element head;
    private Element tail;
    private int length = 0;

    //TODO - sortowanie, wyszukiwanie, usuwanie konkretu, do tablcy, fuzja, substract,

    public int getLength() {
        return length;
    }
    public boolean isEmpty(){
        return (head == null);
    }
    public OneWayList addLast(int value){
        Element element = new Element(value);
        if(isEmpty()){
            head = element;
        }
        else {
            tail.setNextElement(element);
        }
        tail = element;
        ++length;
        return this;
    }
    public OneWayList addFirst(int value){
        Element element = new Element(value);
        if(isEmpty()){
            head = element;
            tail = element;
        }
        else {
            element.setNextElement(head);
            head = element;
        }
        ++length;
        return this;
    }
    public OneWayList delFirst(){
        if(!isEmpty()){
            Element tmp = head;
            head = head.getNextElement();
            tmp.setNextElement(null);
            --length;
        }
        return this;
    }
    public OneWayList delLast(){
        if(!isEmpty()){
            if(head == tail){
                head = null;
                tail = null;
            }
            else{
                Element tmp = head;
                while (tmp.getNextElement() != tail) {
                    tmp = tmp.getNextElement();
                }
                tail = tmp;
                tmp.setNextElement(null);
            }
            --length;
        }
        return this;
    }
    public int[] toArray(){
        int[] tab = new int[this.getLength()];
        int i = 0;
        for(Element element = head; element != null; element = element.getNextElement()){
            tab[i++] = element.getValue();
        }
        return tab;
    }
    public OneWayList clone(){
        OneWayList clone = new OneWayList();
        clone.reset();
        for(Element element = head; element != null; element = element.getNextElement()){
            clone.addLast(element.getValue());
        }
        return clone;
    }
    public OneWayList merge(@NotNull OneWayList list){
        OneWayList result = new OneWayList();
        this.tail.setNextElement(list.head);
        this.length += list.length;
        return this;
    }
    private void reset() {
        head = tail = null;
        length = 0;
    }
    public boolean find(int value) {
        if (!isEmpty()) {
            Element tmp = head;
            for(;tmp.getValue() != value;tmp = tmp.getNextElement()){
                if (tmp == tail)  return false;
            }
        }
        else{
            return false;
        }
        return true;
    }
//    public boolean findSort(int value) {
//        if (!isEmpty()) {
//            Element tmp = head;
//            for(;tmp.getValue() != value;tmp = tmp.getNextElement()){
//                if (tmp == tail)  return false;
//            }
//        }
//        else{
//            return false;
//        }
//        return true;
//    }





    public void show(){
        if(!isEmpty()){
            System.out.print("Subsequent list item: [ ");
            Element tmp = head;
            while (tmp != null){
                System.out.printf("%d ", tmp.getValue());
                tmp = tmp.getNextElement();
            }
            System.out.print("]");
            System.out.printf(" :: < %d >\n", this.getLength());
        }
        else {
            System.out.println("__List is empty!__");
        }

    }
}
