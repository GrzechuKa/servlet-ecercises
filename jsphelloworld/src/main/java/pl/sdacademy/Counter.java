package pl.sdacademy;

import java.util.concurrent.atomic.AtomicInteger;

public enum  Counter {
    INSTANCE;

    private AtomicInteger counter = new AtomicInteger(0);

    public Integer getCount(){
        return counter.incrementAndGet();
    }


}
