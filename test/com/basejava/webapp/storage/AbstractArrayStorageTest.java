package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private Storage storage;

    private static final String UUID_4 = "uuid4";

    private static final Resume RESUME_1 = new Resume(UUID_1);
    private static final Resume RESUME_2 = new Resume(UUID_2);
    private static final Resume RESUME_3 = new Resume(UUID_3);
    private static final Resume RESUME_4 = new Resume(UUID_4);

    private Resume[] expectedResumes = new Resume[]{RESUME_1, RESUME_2, RESUME_3};

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void update() {
        Resume r = new Resume(UUID_1);
        storage.update(r);
        assertSame(r, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.update(new Resume());
    }

    @Test
    public void save() {
        storage.save(RESUME_4);
        assertEquals(4, storage.size());
        assertEquals(RESUME_4, storage.get(UUID_4));
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() throws Exception {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            fail("Overflow happened too soon - test failed.");
        }
        storage.save(new Resume());
    }

    @Test(expected = ExistStorageException.class)
    public void saveExistStorageException() throws Exception {
        storage.save(RESUME_2);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_1);
        assertEquals(2, storage.size());
        storage.get(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExistStorageException() throws Exception {
        storage.delete("test");
    }

    @Test
    public void getAll() {
        Resume[] resumesArray = storage.getAll();
        assertArrayEquals(expectedResumes, resumesArray);
    }

    @Test
    public void size() {
        assertEquals(3, storage.size());
    }

    @Test
    public void get() {
        Resume r = storage.get(UUID_1);
        assertEquals(RESUME_1, r);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("test");
    }
}