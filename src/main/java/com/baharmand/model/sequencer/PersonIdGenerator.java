package com.baharmand.model.sequencer;

public class PersonIdGenerator {
    private static Integer personId = 1000;

    public static Integer generateNextPersonId() {
        return ++personId;
    }
}
