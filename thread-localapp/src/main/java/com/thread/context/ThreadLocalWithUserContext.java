package com.thread.context;

import com.thread.domain.Context;

public class ThreadLocalWithUserContext implements Runnable {

    private static ThreadLocal<Context> userContext = new ThreadLocal<>();
    private Integer userId;

    public ThreadLocalWithUserContext(final Integer userId) {
        this.userId = userId;
    }

    @Override
    public void run() {
        final String userName = String.format("User-%d", userId);
        userContext.set(new Context(userName));
        System.out.println("thread context for given userId: " + userId + " is " + userContext.get());
    }
}
