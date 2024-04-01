package io.kowsu.feat21;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.SequencedCollection;

public class SequenceCollectionTest {
    @Test
    void sequenceTest() {
        SequencedCollection<String> collection
                = new LinkedList<>();
        boolean isAdded = collection.add("RAM");
        System.out.println(isAdded);
    }
}
