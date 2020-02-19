package ru.netology.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CashbackHackServiceTest {

    @Test
    void serviceShouldAdvise(){
        // подготовка
        CashbackHackService service = new CashbackHackService();
        int amount = 1900;
        // выполнение целевого действия
        int actual = service.remain(amount);
        int expected = 100;
        // сравнение ожидаемого и фактического
        assertEquals(expected, actual);
    }
    @Test
    void serviceShouldAdvise0Cashback(){
        // подготовка
        CashbackHackService service = new CashbackHackService();
        int amount = 1000;
        // выполнение целевого действия
        int actual = service.remain(amount);
        int expected = 0;
        // сравнение ожидаемого и фактического
        assertEquals(expected, actual);
    }
    @Test
    void serviceShouldAdvise0Pay(){
        // подготовка
        CashbackHackService service = new CashbackHackService();
        int amount = 0;
        // выполнение целевого действия
        int actual = service.remain(amount);
        int expected = 1000;
        // сравнение ожидаемого и фактического
        assertEquals(expected, actual);
    }
}