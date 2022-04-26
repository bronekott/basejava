package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {
    private final Map<String, Resume> storage = new HashMap<>();

    @Override
    protected String findSearchKey(String uuid) {
        for (Map.Entry<String, Resume> entry : storage.entrySet()) {
            if (entry.getValue().equals(uuid)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override
    protected void updateResume(Object index, Resume resume) {
        storage.replace((String) index, resume);
    }

    @Override
    protected void saveResume(Object index, Resume resume) {
        storage.put((String) index, resume);
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
