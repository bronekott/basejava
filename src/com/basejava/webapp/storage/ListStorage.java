package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage{
    private final List<Resume> storage = new ArrayList<Resume>();


    @Override
    protected int findIndex(String uuid) {
        for(int i = 0;i<storage.size();i++){
            if(storage.get(i).getUuid().equals(uuid)){
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void updateAction(int index, Resume resume) {
        storage.set(index,resume);
    }

    @Override
    protected void saveAction(Resume resume) {
        storage.add(resume);
    }
}
