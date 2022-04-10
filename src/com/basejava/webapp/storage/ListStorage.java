package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage{
    private final List<Resume> storage = new ArrayList<Resume>();


    @Override
    protected void updateResume(int index, Resume resume) {
        storage.set(index,resume);
    }

    @Override
    protected void saveResume(Resume resume) {
        storage.add(resume);
    }

    @Override
    protected Resume getResume(int index) {
       return storage.get(index);
    }

    @Override
    protected void deleteResume(int index) {
        storage.remove(index);
    }

    @Override
    public void clear() {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return 0;
    }
    @Override
    protected int findIndex(String uuid) {
        for(int i = 0;i<storage.size();i++){
            if(storage.get(i).getUuid().equals(uuid)){
                return i;
            }
        }
        return -1;

    }
}
