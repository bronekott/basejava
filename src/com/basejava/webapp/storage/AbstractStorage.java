package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract Object findSearchKey(String uuid);

    protected abstract void updateResume(Object searchKey, Resume resume);

    protected abstract void saveResume(Object searchKey,Resume resume);

    protected abstract Resume getResume(Object searchKey);

    protected abstract void deleteResume(Object searchKey);

    @Override
    public void update(Resume resume) {
        Object searchKey = findSearchKey(resume.getUuid());
        if (searchKey == null) {
            throw new NotExistStorageException(resume.getUuid());
        }
        updateResume(searchKey, resume);
    }

    @Override
    public void save(Resume resume) {
        Object searchKey = findSearchKey(resume.getUuid());
        if (searchKey != null) {
            throw new ExistStorageException(resume.getUuid());
        }
        saveResume(searchKey, resume);
    }

    @Override
    public Resume get(String uuid) {
        Object searchKey = findSearchKey(uuid);
        if (searchKey == null) {
            throw new NotExistStorageException(uuid);
        }
        return getResume(searchKey);
    }

    @Override
    public void delete(String uuid) {
        Object searchKey = findSearchKey(uuid);
        if (searchKey == null) {
            throw new NotExistStorageException(uuid);
        }
        deleteResume(searchKey);
    }

}
