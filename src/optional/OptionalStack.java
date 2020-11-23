package optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalStack<E> {

    private List<E> stackList;

    public OptionalStack() {
        this.stackList = new ArrayList<>();
    }

    public boolean push(E task) {
        return this.stackList.add(task);
    }

    public Optional<E> pop() {
        if (this.stackList.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(this.stackList.remove(this.stackList.size()-1));
    }

}
