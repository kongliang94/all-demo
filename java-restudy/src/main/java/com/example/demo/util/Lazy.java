package com.example.demo.util;

import java.util.function.Supplier;

public class Lazy implements Supplier {

    final private Supplier supplier;
    private boolean supplied = false;
    private Object value;
    private Lazy(Supplier supplier) {
        this.supplier = supplier;
    }
    public static  Lazy let(Supplier supplier) {
        return new Lazy(supplier);
    }


    @Override
    public Object get() {
        if (supplied) {
            return value;
        }
        supplied = true;
        return value = supplier.get();
    }
}
