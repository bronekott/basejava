package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {
    private final Map<String, Resume> storage = new HashMap<String, Resume>();

    @Override
    protected int findIndex(String uuid) {
        int index = -1;
//        for (Map.Entry<String, Resume> entry : storage.entrySet()) {
//            if(entry.getKey().equals(uuid)){
//                index = entry.getValue();
//            }
//        }
        return index;
    }

    @Override
    protected void updateResume(int index, Resume resume) {

    }

    @Override
    protected void saveResume(int index, Resume resume) {

    }

    @Override
    protected Resume getResume(int index) {
        return null;
    }

    @Override
    protected void deleteResume(int index) {

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
        public int size () {
            return storage.size();
        }
    }
