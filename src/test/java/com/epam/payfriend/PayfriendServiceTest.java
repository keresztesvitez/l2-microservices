package com.epam.payfriend;

import com.epam.Application;
import com.epam.Payment;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PayfriendServiceTest {

    public static final String USER_ID = "am9obkBleGFtcGxlLmNvbQ==";
    public static final String TARGET_USER_ID = "amFuZUBleGFtcGxlLmNvbQ==";
    public static final String TARGET_EMAIL = "jane@example.com";
    public static final String TARGET_NAME = "Jane";
    public static final String FROM_EMAIL = "john@example.com";
    public static final String FROM_NAME = "John";

    @Autowired
    private PayfriendService service;

    @Test
    public void testShouldGetuserId() {
        UserIdRequest request = new UserIdRequest();
        request.setEmail(FROM_EMAIL);

        String userId = service.getUserId(request);

        assertThat(userId, notNullValue());
        assertThat(userId, is(USER_ID));
    }

    @Test
    public void testShouldSendPostRequest() {
        PaymentRequest request = getPaymentRequest();
        PaymentResponse paymentResponse = service.pay(request);

        log.info("PaymentResponse: {}",paymentResponse);

        assertThat(paymentResponse, is(notNullValue()));
        assertThat(paymentResponse.getAmount(), is(200D));
        assertThat(paymentResponse.getPayFriend().getEmail(), is(FROM_EMAIL));
        assertThat(paymentResponse.getPayFriend().getName(), is(FROM_NAME));
        assertThat(paymentResponse.getPayFriend().getUserId(), is(USER_ID));
        assertThat(paymentResponse.getTargetFriend().getEmail(), is(TARGET_EMAIL));
        assertThat(paymentResponse.getTargetFriend().getName(), is(TARGET_NAME));
        assertThat(paymentResponse.getTargetFriend().getUserId(), is(TARGET_USER_ID));
    }

    private PaymentRequest getPaymentRequest() {
        PaymentRequest request = new PaymentRequest();

        request.setPayFriend(getPayfriend());
        request.setTargetFriend(getTargetFriend());
        request.setPayment(getPayment());

        return request;
    }

    private PayFriend getPayfriend() {
        PayFriend payFriend = new PayFriend();

        payFriend.setEmail(FROM_EMAIL);
        payFriend.setName(FROM_NAME);
        payFriend.setUserId(USER_ID);

        return payFriend;
    }

    private PayFriend getTargetFriend() {
        PayFriend payFriend = new PayFriend();

        payFriend.setEmail(TARGET_EMAIL);
        payFriend.setName(TARGET_NAME);
        payFriend.setUserId(TARGET_USER_ID);

        return payFriend;
    }

    private Payment getPayment() {
        return new Payment(200D, "USD");
    }
}