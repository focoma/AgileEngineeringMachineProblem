package com.orangeandbronze;


import org.junit.Test;

import static com.orangeandbronze.Default.*;

/**
 * Created by training on 2/19/16.
 */
public class SectionTest {

    @Test
    public void sectionIdAlphanumeric() {
        new Section(SECTION, SCHEDULE, new Room(ROOM101, 2));
    }

}