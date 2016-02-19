package com.orangeandbronze;


import org.junit.Test;

import static com.orangeandbronze.Default.*;
import static com.orangeandbronze.SemesterEnum.S_FIRST_SEM;

/**
 * Created by training on 2/19/16.
 */
public class SectionTest {

    @Test
    public void sectionIdAlphanumeric() {
        new Section(SECTION1_NAME, SCHEDULE_H0830 , new Room(ROOM101, 2), SUBJECT_MATH_02, S_FIRST_SEM);
    }
    
    // Test Scenarios
    // Should not add the same section with the same subject.
    
    // Section Name, Schedule, Room

}