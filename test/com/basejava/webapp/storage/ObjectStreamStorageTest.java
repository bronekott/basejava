package com.basejava.webapp.storage;

import org.junit.Test;

import static org.junit.Assert.*;

public class ObjectStreamStorageTest extends AbstractArrayStorageTest {

    public ObjectStreamStorageTest() {
        super(new ObjectStreamStorage(STORAGE_DIR));
    }

}