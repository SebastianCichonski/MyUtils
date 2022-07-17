package OneWayLists;

public class OneWayList {
    private Element head;
    private Element tail;
    private int length = 0;

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
        }
        --length;
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
                while (tmp.getNextElement() != tail){
                    tmp = tmp.getNextElement();
                }
                tail = tmp;
                tmp.setNextElement(null);
            }
            --length;
        }
        return this;
    }

    public void show(){
        if(!isEmpty()){
            System.out.print("Kolejne elementy listy: [ ");
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
