package com.playing.rx.learningrxjava.backpressure.need;

import com.playing.rx.learningrxjava.util.SomeTools;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public final class BackPressureNeedExample1 {
    public static void main(final String[] args) {

        Flowable.range(1, 999_999_999)
                .map(MyItem::new)
                .observeOn(Schedulers.io())
                .subscribe(myItem -> {
                    SomeTools.sleep(50);
                    System.out.println("Received MyItem " + myItem.id);
                })
                ;

        SomeTools.sleepSeconds(Integer.MAX_VALUE);

    }

    private static class MyItem {
        private final int id;
        public MyItem(final int id) {
            this.id = id;
            System.out.println("Constructing MYItem: " + id);
        }
    }
}
