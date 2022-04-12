package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {
    private final Map<Integer, Resume> storage = new HashMap<Integer, Resume>();

    @Override
    protected int findIndex(String uuid) {
        int index = -1;
        for (Map.Entry<Integer, Resume> entry : storage.entrySet()) {
            if (entry.getValue().equals(uuid)) {
                index = entry.getKey();
            }
        }
        return index;
    }

    @Override
    protected void updateResume(int index, Resume resume) {
        storage.replace(index, resume);
    }

    @Override
    protected void saveResume(int index, Resume resume) {
        storage.put(index, resume);
    }

    @Override
    protected Resume getResume(int index) {
        return null;
    }

    @Override
    protected void deleteResume(int index) {
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
