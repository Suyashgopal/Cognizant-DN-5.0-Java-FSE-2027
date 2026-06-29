package com.example.mockito.advanced;

public class Service {
    private Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public Object fetchData() {
        return repository.getData();
    }

    public void store(Object data) {
        repository.save(data);
    }

    public Object getById(Long id) {
        return repository.findById(id);
    }
}
