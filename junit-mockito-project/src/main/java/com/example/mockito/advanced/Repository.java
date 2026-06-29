package com.example.mockito.advanced;

public interface Repository<T> {
    T getData();
    void save(T data);
    T findById(Long id);
    void delete(Long id);
}
