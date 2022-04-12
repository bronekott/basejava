package com.basejava.webapp.storage;

import com.basejava.webapp.exception.NotExistStorageException;
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

    public void updateResume(int index, Resume resume) {
        if (index < 0) {
            throw new NotExistStorageException(resume.getUuid());
        }
        storage[index] = resume;
        System.out.println("Resume with uuid: " + resume.getUuid() + " have been updated");

    }

    public void saveResume(int index, Resume resume) {
        if (STORAGE_LIMIT == size) {
            throw new StorageException("ERROR: storage is full", resume.getUuid());
        }
        insertElement(index, resume);
        size++;
    }

    public void deleteResume(int index) {
        if (size - 1 - index >= 0) {
            System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
            size--;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    public Resume getResume(int index) {
        return storage[index];
    }

    protected abstract void insertElement(int index, Resume resume);

}