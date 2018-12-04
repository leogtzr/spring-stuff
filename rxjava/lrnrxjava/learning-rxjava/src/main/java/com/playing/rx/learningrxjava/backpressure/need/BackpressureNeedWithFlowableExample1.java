package com.playing.rx.learningrxjava.backpressure.need;

public final class BackpressureNeedWithFlowableExample1 {
    public static void main(final String[] args) {

    }

    private static class MyItem {
        private final int id;
        public MyItem(final int id) {
            this.id = id;
            System.out.println("Constructing MYItem: " + id);
        }
    }

}
