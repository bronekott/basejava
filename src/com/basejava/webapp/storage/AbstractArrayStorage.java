package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void updateResume(Object searchKey, Resume resume) {
        storage[(int) searchKey] = resume;
    }

    public void saveResume(Object searchKey, Resume resume) {
        if (STORAGE_LIMIT == size) {
            throw new StorageException("ERROR: storage is full", resume.getUuid());
        }
        insertElement((int) searchKey, resume);
        size++;
    }

    public void deleteResume(Object searchKey) {
        if (size - 1 - (int) searchKey >= 0) {
            System.arraycopy(storage, (int) searchKey + 1, storage, (int) searchKey, size - 1 - (int) searchKey);
            size--;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    public Resume getResume(Object index) {
        return storage[(int) index];
    }

    @Override
    protected boolean isFound(Object searchKey) {
        return (Integer) searchKey >= 0;
    }

    protected abstract void insertElement(int index, Resume resume);

}