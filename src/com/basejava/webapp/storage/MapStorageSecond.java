package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorageSecond extends AbstractStorage<Resume> {

    private final Map<String, Resume> storage = new HashMap<>();

    @Override
    protected Resume findSearchKey(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected void updateResume(Resume searchKey, Resume resume) {
        storage.replace(resume.getUuid(), resume);
    }

    @Override
    protected void saveResume(Resume searchKey, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getResume(Resume resume) {
        return resume;

    }

    @Override
    protected void deleteResume(Resume resume) {
        storage.remove(resume.getUuid());

    }

    @Override
    protected boolean isFound(Resume resume) {
        return resume != null;
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return storage.values().toArray(new Resume[storage.size()]);
    }

    @Override
    public int size() {
        return storage.size();
    }
}
