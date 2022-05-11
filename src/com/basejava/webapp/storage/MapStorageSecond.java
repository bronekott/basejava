package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorageSecond extends AbstractStorage {

    private final Map<String, Resume> storage = new HashMap<>();

    @Override
    protected Object findSearchKey(String fullName) {
        return null;
    }

    @Override
    protected void updateResume(Object searchKey, Resume resume) {

    }

    @Override
    protected void saveResume(Object searchKey, Resume resume) {

    }

    @Override
    protected Resume getResume(Object searchKey) {
        return null;
    }

    @Override
    protected void deleteResume(Object searchKey) {

    }

    @Override
    protected boolean isFound(Object searchKey) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return 0;
    }
}
