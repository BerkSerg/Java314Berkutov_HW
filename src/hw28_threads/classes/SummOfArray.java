package hw28_threads.classes;

public class SummOfArray extends Thread{
    private int[] array;
    private int begin;
    private int end;
    private int summ;

    public SummOfArray(int[] array, int begin, int end) {
        this.array = array;
        this.begin = begin;
        this.end = end;
    }

    public int getSumm() {
        return summ;
    }

    @Override
    public void run() {
        for (int i = begin; i <= end; i++) {
            summ += array[i];
        }
    }
}
