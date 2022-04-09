package com.basejava.webapp.storage;

import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract int findIndex(String uuid);
    protected abstract void updateAction(int index, Resume resume);
    protected abstract void saveAction(Resume resume);

    @Override
    public void clear() {
    }

    @Override
    public void update(Resume resume) {
        int index = findIndex(resume.getUuid());
        updateAction(index, resume);
    }

    @Override
    public void save(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (index >= 0) {
            throw new NotExistStorageException(resume.getUuid());
        }
        saveAction(resume);
    }

    @Override
    public Resume get(String uuid) {
        return null;
    }

    @Override
    public void delete(String uuid) {

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
