package genericStack;

import java.util.ArrayList;
import java.util.List;

// E は Numberクラスまたはそのサブクラスに制限することができる
public class NumberStack<E extends Number> {
    private List<E> taskList;

    public NumberStack() {
        // ダイヤモンドオペレーターを利用して型を簡略化できる
        taskList = new ArrayList<>();
    }

    public boolean push(E task) {
        System.out.println("Add:" + task.intValue());
        return taskList.add(task);
    }

    public E pop() {
        if (taskList.isEmpty()) {
            return null;
        }
        return taskList.remove(taskList.size()-1);
    }

}
