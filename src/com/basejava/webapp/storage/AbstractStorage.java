package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    protected abstract Object findSearchKey(String uuid);

    protected abstract void updateResume(Object searchKey, Resume resume);

    protected abstract void saveResume(Object searchKey, Resume resume);

    protected abstract Resume getResume(Object searchKey);

    protected abstract void deleteResume(Object searchKey);

    protected abstract boolean isFound(Object searchKey);

    @Override
    public void update(Resume resume) {
        Object searchKey = findExistedSearchKey(resume.getUuid());
        updateResume(searchKey, resume);
    }

    @Override
    public void save(Resume resume) {
        Object searchKey = findNotExistedSearchKey(resume.getUuid());
        saveResume(searchKey, resume);
    }

    @Override
    public Resume get(String uuid) {
        Object searchKey = findExistedSearchKey(uuid);
        return getResume(searchKey);
    }

    @Override
    public void delete(String uuid) {
        Object searchKey = findExistedSearchKey(uuid);
        deleteResume(searchKey);
    }

    protected Object findExistedSearchKey(String uuid) {
        Object searchKey = findSearchKey(uuid);
        if (!isFound(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    protected Object findNotExistedSearchKey(String uuid) {
        Object searchKey = findSearchKey(uuid);
        if (isFound(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    @Override
    public List<Resume> getAllSorted() {
        // https://www.baeldung.com/java-sorting#sorting-a-list
        List<Resume> list = Arrays.asList(getAll());
        Collections.sort(list);
        return list;
    }

}
