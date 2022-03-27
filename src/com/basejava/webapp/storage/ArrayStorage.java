package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        //for (int i = 0; i < size; i++) {
        //    storage[i] = null;
        //}
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        if (get(resume.getUuid()) != null) {
            System.out.println("Resume with uuid: " + resume.getUuid() + " have been updated");
            //resume.setUuid("??????");
        } else {
            System.out.println("ERROR: resume not found");
        }
    }

    public void save(Resume resume) {
        if (storage.length == size) {
            System.out.println("ERROR: storage is full");
            return;
        }
        if (get(resume.getUuid()) != null) {
            System.out.println("ERROR: resume with uuid:" + resume.getUuid() + " already exists");
            return;
        }
        storage[size] = resume;
        size++;
    }

    public Resume get(String uuid) {
        int position = findResumePosition(uuid);
        if (position == -1) {
            System.out.println("ERROR: Resume with uuid:" + uuid + " does not exists");
            return null;
        } else {
            return storage[position];
        }
    }

    public void delete(String uuid) {
        int position = findResumePosition(uuid);
        if (position == -1) {
            System.out.println("ERROR: Resume with uuid:" + uuid + " does not exists");
        } else {
            for (int i = position; i < size - 1; i++) {
                storage[i] = storage[i + 1];
            }
            System.out.println("Resume with uuid:" + uuid + " have been deleted");
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {

        //Resume[] resumes = new Resume[size];
        //for (int i = 0; i < size; i++) {
        //    resumes[i] = storage[i];
        //}

        //return resumes;
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    public int findResumePosition(String uuid) {
        int position = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].toString() == uuid) {
                position = i;
            }
        }
        return position;
    }
}
