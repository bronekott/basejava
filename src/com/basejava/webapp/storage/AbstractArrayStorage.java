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
        storage[(Integer)searchKey] = resume;
    }

    public void saveResume(Object searchKey, Resume resume) {
        if (STORAGE_LIMIT == size) {
            throw new StorageException("ERROR: storage is full", resume.getUuid());
        }
        insertElement((Integer)searchKey, resume);
        size++;
    }

    public void deleteResume(Object searchKey) {
        if (size - 1 - (Integer) searchKey >= 0) {
            System.arraycopy(storage, (Integer)searchKey + 1, storage, (Integer)searchKey, size - 1 - (Integer)searchKey);
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
        return storage[(Integer) index];
    }

    protected abstract void insertElement(int index, Resume resume);

}