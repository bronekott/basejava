package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {
    private final Map<String, Resume> storage = new HashMap<>();

    @Override
    protected String findSearchKey(String uuid) {
//        String index = -1;
//        for (Map.Entry<Integer, Resume> entry : storage.entrySet()) {
//            if (entry.getValue().equals(uuid)) {
//                index = entry.getKey();
//            }
//        }
        // если uuid и есть ключ, то зачм нам его искать?????????
        return uuid;
    }

    @Override
    protected void updateResume(Object index, Resume resume) {
        storage.replace((String) index, resume);
    }

    @Override
    protected void saveResume(Object index, Resume resume) {
        storage.put((String)index, resume);
    }

    @Override
    protected Resume getResume(Object index) {
        return null;
    }

    @Override
    protected void deleteResume(Object index) {
        storage.remove(index);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return (Resume[]) storage.values().toArray();
    }

    @Override
    public int size() {
        return storage.size();
    }
}
