package com.basejava.webapp.storage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapStorageTest extends AbstractStorageTest{
    public MapStorageTest()  {
        super(new ListStorage());
    }
}