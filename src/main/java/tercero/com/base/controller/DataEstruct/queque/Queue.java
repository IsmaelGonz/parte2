package tercero.com.base.controller.DataEstruct.queque;

public class Queue<E> {
    private QuequeImplementation<E> queue;

    public Queue(Integer top){
        queue = new QuequeImplementation<>(top);

    }

    public Boolean queue(E data){
        try {
            queue.queue(data);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public E dequeue() {
        try {
            return queue.dequeue();
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean isFullQueue(){
        return queue.isFullQueue();
    }

    public Integer top(){
        return queue.getTop();
    }

    public Integer size(){
        return queue.getLength();
    }
}
