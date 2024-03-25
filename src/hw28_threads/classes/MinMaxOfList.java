package hw28_threads.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;

public class MinMaxOfList implements Callable<Integer[]> {
    private final List<Integer> processedList;

    public MinMaxOfList(List<Integer> listToProcess){
        processedList = new ArrayList<>(listToProcess);
    }
    @Override
    public Integer[] call() throws Exception {
        if (processedList.isEmpty()){
            throw new Exception("Коллекция пуста!");
        }
        Integer[] res = new Integer[2];
        Optional<Integer> minResult = processedList.stream().min(Integer::compareTo);
        Optional<Integer> maxResult = processedList.stream().max(Integer::compareTo);
        res[0] = minResult.get();
        res[1] = maxResult.get();

        return res;
    }
}
