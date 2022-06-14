package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {
    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    protected abstract SK findSearchKey(String uuid);

    protected abstract void updateResume(SK searchKey, Resume resume);

    protected abstract void saveResume(SK searchKey, Resume resume);

    protected abstract Resume getResume(SK searchKey);

    protected abstract void deleteResume(SK searchKey);

    protected abstract boolean isFound(SK searchKey);

    @Override
    public void update(Resume resume) {
        LOG.info("Update " + resume);
        SK searchKey = findExistedSearchKey(resume.getUuid());
        updateResume(searchKey, resume);
    }

    @Override
    public void save(Resume resume) {
        LOG.info("Save " + resume);
        SK searchKey = findNotExistedSearchKey(resume.getUuid());
        saveResume(searchKey, resume);
    }

    @Override
    public Resume get(String uuid) {
        LOG.info("Get " + uuid);
        SK searchKey = findExistedSearchKey(uuid);
        return getResume(searchKey);
    }

    @Override
    public void delete(String uuid) {
        LOG.info("Delete " + uuid);
        SK searchKey = findExistedSearchKey(uuid);
        deleteResume(searchKey);
    }


    @Override
    public List<Resume> getAllSorted() {
        LOG.info("getAllSorted");
        // https://www.baeldung.com/java-sorting#sorting-a-list
        List<Resume> list = Arrays.asList(getAll());
        //Collections.sort(list);
        list.sort(RESUME_COMPARATOR);
        return list;
    }

    private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);

    private SK findExistedSearchKey(String uuid) {
        LOG.info("Delete " + uuid);
        SK searchKey = findSearchKey(uuid);
        if (!isFound(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private SK findNotExistedSearchKey(String uuid) {
        SK searchKey = findSearchKey(uuid);
        if (isFound(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }
}