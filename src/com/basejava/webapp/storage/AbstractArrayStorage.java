package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void updateResume(Integer index, Resume resume) {
        storage[index] = resume;
    }

    public void saveResume(Integer index, Resume resume) {
        if (STORAGE_LIMIT == size) {
            throw new StorageException("ERROR: storage is full", resume.getUuid());
        }
        insertElement(index, resume);
        size++;
    }

    public void deleteResume(Integer index) {
        if (size - 1 - index >= 0) {
            System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
            size--;
        }
    }

    public List<Resume> getAll() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
    }

    public int size() {
        return size;
    }

    public Resume getResume(Integer index) {
        return storage[index];
    }

    @Override
    protected boolean isFound(Integer index) {
        return index >= 0;
    }

    protected abstract void insertElement(int index, Resume resume);
}