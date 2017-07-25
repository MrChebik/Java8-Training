package ru.mrchebik.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrchebik on 7/25/17.
 */
public class ArrayList2<T> extends ArrayList<T> implements Collection2<T> {
    public ArrayList2(List<T> strings) {
        super(strings);
    }
}
