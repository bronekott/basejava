package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (index == -1) {
            System.out.println("ERROR: resume not found");
        } else {
            storage[index] = resume;
            System.out.println("Resume with uuid: " + resume.getUuid() + " have been updated");
        }
    }

    public void save(Resume resume) {
        if (storage.length == size) {
            System.out.println("ERROR: storage is full");
            return;
        }
        if (findIndex(resume.getUuid()) != -1) {
            System.out.println("ERROR: resume with uuid:" + resume.getUuid() + " already exists");
            return;
        }
        storage[size] = resume;
        size++;
    }

    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index == -1) {
            System.out.println("ERROR: Resume with uuid:" + uuid + " does not exists");
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index == -1) {
            System.out.println("ERROR: Resume with uuid:" + uuid + " does not exists");
        } else {
            if (size - 1 - index >= 0)
                System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
            System.out.println("Resume with uuid:" + uuid + " have been deleted");
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString() == uuid) {
                return i;
            }
        }
        return -1;
    }
}
