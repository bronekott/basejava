package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

public class MapStorageSecond extends AbstractStorage{
    @Override
    protected Object findSearchKey(String uuid) {
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
