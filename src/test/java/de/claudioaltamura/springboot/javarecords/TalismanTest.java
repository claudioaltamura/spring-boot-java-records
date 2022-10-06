package de.claudioaltamura.springboot.javarecords;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TalismanTest {

    @Test
    void testNull() {
        final var talisman = new Talisman(null);
        assertNull(talisman.name());
    }

}