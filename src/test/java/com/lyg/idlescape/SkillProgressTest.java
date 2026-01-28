package com.lyg.idlescape;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SkillProgressTest {

    @ParameterizedTest
    @CsvSource({
            "13034431, 99",
            "13034430, 98",
            "1154, 10",
            "1153, 9",
            "0, 1",
            "-1, 1"
    })
    void skillProgressLevels(int xp, int expectedLevel) {
        var skill = new SkillProgress(xp);
        Assertions.assertEquals(expectedLevel, skill.getSkillLevel());
    }

}