package ru.passworkDemo.tests;

import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;

public abstract class BaseTest {

    @BeforeAll
    public static void setup() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
    }
}
