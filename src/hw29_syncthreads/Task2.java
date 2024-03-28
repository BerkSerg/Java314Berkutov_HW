package hw29_syncthreads;

import hw29_syncthreads.classes.SyncSortLinkedList;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 2.	Параллельная сортировка списка:
 * o	Создайте класс, который содержит синхронизированный список (например, LinkedList).
 * o	Создайте несколько потоков, каждый из которых будет сортировать свою часть списка.
 * o	Используйте блокирующую синхронизацию (synchronized) при доступе к списку.
 */
public class Task2 {
    public static final int NUM_OF_THREAD = 5;

    public static void main(String[] args) {
        SyncSortLinkedList syncArrayList = new SyncSortLinkedList();
        syncArrayList.fillList();

        int partSize = syncArrayList.getSize() / NUM_OF_THREAD;
        int remaining = syncArrayList.getSize() % NUM_OF_THREAD;

        final AtomicInteger start = new AtomicInteger(0);
        final AtomicInteger end = new AtomicInteger(0);

        for (int i = 0; i < NUM_OF_THREAD; i++) {
            int[] wrapperI = {i};
            new Thread(() -> {
                start.set(end.get());
                end.set(start.get() + partSize + (wrapperI[0] < remaining ? 1 : 0));
                syncArrayList.sortPart(start.get(), end.get());
            }).start();
        }
    }
}
