package OneWayLists;

public class Element {
    private Element nextElement;
    private int value;

    public Element(int value) {
        this.nextElement = null;
        this.value = value;
    }

    public Element getNextElement() {
        return nextElement;
    }

    public int getValue() {
        return value;
    }

    public void setNextElement(Element nextElement) {
        this.nextElement = nextElement;
    }

    public void setValue(int value) {
        this.value = value;
    }


}
