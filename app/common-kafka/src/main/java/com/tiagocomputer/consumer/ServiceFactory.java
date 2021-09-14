package com.tiagocomputer.consumer;

public interface ServiceFactory<T> {
    ConsumerService<T> create();
}
