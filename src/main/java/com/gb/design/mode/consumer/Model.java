package com.gb.design.mode.consumer;

public interface Model {
    Runnable newRunnableConsumer();
    Runnable newRunnableProducer();
}
