package com.bugjc.ea.qrcode;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author aoki
 * @date ${date}
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(QrCodeServerApplication.class)
public class Tester {
}
