package ru.netology.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class CashbackHackServiceTest {

    @Test
    void serviceShould100Advise1900(){
        // given
        CashbackHackService service = new CashbackHackService();
        int amount = 1900;
        // when
        int actual = service.remain(amount);
        int expected = 100;
        // then
        assertEquals(expected, actual);
    }

    @Test
    void serviceShould0Advise1000(){
        // given
        CashbackHackService service = new CashbackHackService();
        int amount = 1000;
        // when
        int actual = service.remain(amount);
        int expected = 0;
        // then
        assertEquals(expected, actual);
    }

    @Test
    void serviceShould0Advise0(){
        // given
        CashbackHackService service = new CashbackHackService();
        int amount = 0;
        // when
        assertThrows(IllegalArgumentException.class, () ->service.remain(amount) );
    }

    @Test
    void serviceShould0AdviseMinus(){
        // given
        CashbackHackService service = new CashbackHackService();
        int amount = -1;
        // when
        assertThrows(IllegalArgumentException.class, () ->service.remain(amount) );
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/service.csv", numLinesToSkip = 1)
    void serviceShouldAdvise(int amount, int expected, String message) {
        // given
        CashbackHackService service = new CashbackHackService();
        // when
        int actual = service.remain(amount);
        // then
        assertEquals(expected, actual, message);
    }
}