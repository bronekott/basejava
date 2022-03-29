package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int findIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);// returns an index of searched element, or "an index for insertion-1" in sorted array
    }

    @Override
    protected void insertElement(int index, Resume resume) {
        int insertIndex = -index - 1;
        //тут получается массив 1,2,null,3 и вместо null вставляем наше резюме на след. строке
        System.arraycopy(storage, insertIndex, storage, insertIndex + 1, size - insertIndex);
        // почему если эту строку закомментировать, то будет NULLPointException? Как я понял - из-за того что null невозможно compareTo с добавляемым элементом
        storage[insertIndex] = resume;

        // почему вот этот код тоже падает с NULLPointException?
        //for(Resume r:storage) {
        //    System.out.println(r.getUuid());
        //}
    }

}
