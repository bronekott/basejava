package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (index < 0) {
            System.out.println("ERROR: resume not found");
        } else {
            storage[index] = resume;
            System.out.println("Resume with uuid: " + resume.getUuid() + " have been updated");
        }
    }

    public void save(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (STORAGE_LIMIT == size) {
            System.out.println("ERROR: storage is full");
            return;
        }
        if (index >= 0) {
            System.out.println("ERROR: resume with uuid:" + resume.getUuid() + " already exists");
            return;
        }
        insertElement(index, resume);
        size++;
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            System.out.println("ERROR: Resume with uuid:" + uuid + " does not exists");
        } else {
            if (size - 1 - index >= 0) {
                System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
            }
            System.out.println("Resume with uuid:" + uuid + " have been deleted");
            size--;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            System.out.println("ERROR: Resume with uuid:" + uuid + " does not exists");
            return null;
        }
        return storage[index];
    }

    protected abstract int findIndex(String uuid);

    protected abstract void insertElement(int index, Resume resume);

}
