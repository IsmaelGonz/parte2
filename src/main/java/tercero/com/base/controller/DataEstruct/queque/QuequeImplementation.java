package tercero.com.base.controller.DataEstruct.queque;

import tercero.com.base.controller.DataEstruct.List.Linkendlist;

public class QuequeImplementation<E> extends Linkendlist<E>{
    private Integer top;

    public Integer getTop() {
        return top;
    }
    
    public QuequeImplementation(Integer top) {
       
        this.top = top;
    }

    protected boolean isFullQueue() {
        return this.top >= getLength();
    }

    protected void queue(E info) throws Exception {
        if (!isFullQueue()) {
            add( info, 0);
        } else {
            throw new ArrayIndexOutOfBoundsException("Queque is full");
        }
    }

    protected E dequeue()throws Exception {
        return deleteFirst(); 
    }

    
}
