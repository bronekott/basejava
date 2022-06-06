package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;
import com.basejava.webapp.model.ResumeTestData;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public abstract class AbstractStorageTest {
    public Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    //private static final Resume RESUME_1 = new Resume(UUID_1, "name1");
    //private static final Resume RESUME_2 = new Resume(UUID_2, "name2");
    //private static final Resume RESUME_3 = new Resume(UUID_3, "name3");
    //private static final Resume RESUME_4 = new Resume(UUID_4, "name4");
    private static final Resume RESUME_1 = ResumeTestData.createTestResume(UUID_1, "name1");
    private static final Resume RESUME_2 = ResumeTestData.createTestResume(UUID_2, "name2");
    private static final Resume RESUME_3 = ResumeTestData.createTestResume(UUID_3, "name3");
    private static final Resume RESUME_4 = ResumeTestData.createTestResume(UUID_4, "name4");

    private List<Resume> expectedResumes = new ArrayList<Resume>() {{
        add(RESUME_1);
        add(RESUME_2);
        add(RESUME_3);
    }};

    public AbstractStorageTest(Storage storage) {
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
        Resume r = new Resume(UUID_1, "testName");
        storage.update(r);
        assertSame(r, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.update(new Resume("testName"));
    }

    @Test
    public void save() {
        storage.save(RESUME_4);
        assertEquals(4, storage.size());
        assertEquals(RESUME_4, storage.get(UUID_4));
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
    public void getAllSorted() {
        List<Resume> actualResumes = storage.getAllSorted();
        assertEquals(expectedResumes, actualResumes);
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

