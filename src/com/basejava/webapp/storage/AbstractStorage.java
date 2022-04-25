package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract int findSearchKey(String uuid);

    protected abstract void updateResume(int searchKey, Resume resume);

    protected abstract void saveResume(int searchKey, Resume resume);

    protected abstract Resume getResume(int searchKey);

    protected abstract void deleteResume(int searchKey);

    @Override
    public void update(Resume resume) {
        int searchKey = findSearchKey(resume.getUuid());
        if (searchKey < 0) {
            throw new NotExistStorageException(resume.getUuid());
        }
        updateResume(searchKey, resume);
    }

    @Override
    public void save(Resume resume) {
        int searchKey = findSearchKey(resume.getUuid());
        if (searchKey >= 0) {
            throw new ExistStorageException(resume.getUuid());
        }
        saveResume(searchKey, resume);
    }

    @Override
    public Resume get(String uuid) {
        int searchKey = findSearchKey(uuid);
        if (searchKey < 0) {
            throw new NotExistStorageException(uuid);
        }
        return getResume(searchKey);
    }

    @Override
    public void delete(String uuid) {
        int searchKey = findSearchKey(uuid);
        if (searchKey < 0) {
            throw new NotExistStorageException(uuid);
        }
        deleteResume(searchKey);
    }

}
