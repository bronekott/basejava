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

    public void updateResume(Object index, Resume resume) {
        storage[(int) index] = resume;
    }

    public void saveResume(Object index, Resume resume) {
        if (STORAGE_LIMIT == size) {
            throw new StorageException("ERROR: storage is full", resume.getUuid());
        }
        insertElement((int) index, resume);
        size++;
    }

    public void deleteResume(Object index) {
        int intIndex = (int) index;
        if (size - 1 - intIndex >= 0) {
            System.arraycopy(storage, intIndex + 1, storage, intIndex, size - 1 - intIndex);
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
    protected boolean isFound(Object index) {
        return (int) index >= 0;
    }

    protected abstract void insertElement(int index, Resume resume);
}