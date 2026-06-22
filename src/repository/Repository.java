package repository;

import java.util.ArrayList;
import java.util.List;

public class Repository<T> {

    private List<T> data = new ArrayList<>();

    public void add(T obj) {
        data.add(obj);
    }

    public void remove(T obj) {
        data.remove(obj);
    }

    public List<T> findAll() {
        return data;
    }
}