package Domæneobjekter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KontoTest {

    Konto konto = new Konto("navn", "kode", 100);

    @Test
    void deposit() {
    assertEquals(200, konto.deposit(100));
    }

    @Test
    void depositNegative() {
        assertEquals(100, konto.deposit(-10));
    }

    @Test
    void withdrawPossible() {
        assertEquals(20, konto.withdraw(80));
    }

    @Test
    void withdrawTooMuch() {
        assertEquals(100, konto.withdraw(180));
    }
    @Test
    void withdrawNegative() {
        assertEquals(100, konto.withdraw(-180));
    }
    @Test
    void withdrawSame() {
        assertEquals(0, konto.withdraw(100));
    }
}