package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage<SK> implements Storage {

    protected abstract SK findSearchKey(String uuid);

    protected abstract void updateResume(SK searchKey, Resume resume);

    protected abstract void saveResume(SK searchKey, Resume resume);

    protected abstract Resume getResume(SK searchKey);

    protected abstract void deleteResume(SK searchKey);

    protected abstract boolean isFound(SK searchKey);

    @Override
    public void update(Resume resume) {
        SK searchKey = findExistedSearchKey(resume.getUuid());
        updateResume(searchKey, resume);
    }

    @Override
    public void save(Resume resume) {
        SK searchKey = findNotExistedSearchKey(resume.getUuid());
        saveResume(searchKey, resume);
    }

    @Override
    public Resume get(String uuid) {
        SK searchKey = findExistedSearchKey(uuid);
        return getResume(searchKey);
    }

    @Override
    public void delete(String uuid) {
        SK searchKey = findExistedSearchKey(uuid);
        deleteResume(searchKey);
    }

    protected SK findExistedSearchKey(String uuid) {
        SK searchKey = findSearchKey(uuid);
        if (!isFound(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    protected SK findNotExistedSearchKey(String uuid) {
        SK searchKey = findSearchKey(uuid);
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
