package com.orangeandbronze;


import org.junit.Test;

import static com.orangeandbronze.Default.*;

/**
 * Created by training on 2/19/16.
 */
public class SectionTest {

    @Test
    public void sectionIdAlphanumeric() {
        new Section(SECTION1_NAME, SCHEDULE_H0830 , new Room(ROOM101, 2));
    }

}