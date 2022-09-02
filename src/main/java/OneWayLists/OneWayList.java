package OneWayLists;

import org.jetbrains.annotations.NotNull;

public class OneWayList<E> {
    private Element<E> head;
    private Element<E> tail;
    private int length = 0;

    public int getLength() {
        return length;
    }
    public boolean isEmpty(){
        return (head == null);
    }
    public OneWayList<E> addLast(E value){
        Element<E> element = new Element<>(value);
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
    public OneWayList<E> addFirst(E value){
        Element<E> element = new Element<>(value);
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
    public OneWayList<E> delFirst(){
        if(!isEmpty()){
            Element<E> tmp = head;
            head = head.getNextElement();
            tmp.setNextElement(null);
            --length;
        }
        return this;
    }
    public OneWayList<E> delLast(){
        if(!isEmpty()){
            if(head == tail){
                head = null;
                tail = null;
            }
            else{
                Element<E> tmp = head;
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
    public Object[] toArray(){
        Object[] tab = new Object[this.length];
        int i = 0;
        for(Element<E> element = head; element != null; element = element.getNextElement()){
            tab[i++] = element.value;
        }
        return tab;
    }
    public OneWayList<E> clone(){
        OneWayList<E> clone = new OneWayList<>();
        clone.reset();
        for(Element<E> element = head; element != null; element = element.getNextElement()){
            clone.addLast(element.value);
        }
        return clone;
    }
//    public OneWayList<E> merge(@NotNull OneWayList<E> list){
//        OneWayList<E> result = new OneWayList<>();
//        result.tail.setNextElement(list.head);
//        result.length += list.length;
//        return result;
//    }
    private void reset() {
        head = tail = null;
        length = 0;
    }
    public boolean find(E value) {
        if (!isEmpty()) {
            Element<E> tmp = head;
            for(; tmp.value != value; tmp = tmp.getNextElement()){
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
            Element<E> tmp = head;
            while (tmp != null){
                System.out.print(tmp.value.toString() + ", ");
                tmp = tmp.getNextElement();
            }
            System.out.print("]");
            System.out.printf(" :: < %d >\n", this.length);
        }
        else {
            System.out.println("__List is empty!__");
        }

    }

    private static class Element<E> {
        private Element<E> nextElement;
        private final E value;

        public Element(E value) {
            this.nextElement = null;
            this.value = value;
        }

        public Element<E> getNextElement() {
            return nextElement;
        }

        public void setNextElement(Element<E> nextElement) {
            this.nextElement = nextElement;
        }
    }
}
