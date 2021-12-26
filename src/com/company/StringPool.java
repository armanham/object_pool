package com.company;

import java.util.UUID;

public class StringPool extends AbstractObjectPool<String> {

    public StringPool() {
        super();
    }

    public StringPool(final int minSize, final int maxSize) {
        super(minSize, maxSize);
    }

    @Override
    protected String createObject() {
        return UUID.randomUUID().toString();
    }
}

