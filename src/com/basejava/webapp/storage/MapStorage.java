package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {
    private final Map<String, Resume> storage = new HashMap<>();

    @Override
    protected String findSearchKey(String uuid) {
       return (storage.containsKey(uuid)) ? uuid : null;
    }

    @Override
    protected void updateResume(Object key, Resume resume) {
        //storage.put((String) key, resume);
        storage.replace((String) key, resume);
    }

    @Override
    protected void saveResume(Object key, Resume resume) {
        storage.put((String) key, resume);
    }

    @Override
    protected Resume getResume(Object key) {
        return storage.get((String)key);
    }

    @Override
    protected void deleteResume(Object key) {
        storage.remove(key);
    }

    @Override
    protected boolean isFound(Object searchKey) {
        return searchKey != null;
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return storage.values().toArray(new Resume[storage.size()]);
    }

    @Override
    public int size() {
        return storage.size();
    }
}
