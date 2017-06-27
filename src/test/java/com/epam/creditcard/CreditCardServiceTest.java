package com.epam.creditcard;

import com.epam.Application;
import com.epam.Payment;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.ResourceAccessException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.*;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreditCardServiceTest {

    private static final String ADDRESS = "Futo utca";
    private static final String DATE_OF_BIRTH = "1980-10-10";
    private static final String EMAIL_ADDRESS = "john@example.com";
    private static final String DOE = "Doe";
    private static final String JOHN = "John";
    private static final double AMOUNT = 100;
    private static final String CURRENCY = "USD";

    @Autowired
    private CreditCardService service;

    @Test
    public void testShouldSendPostRequest() {
        PaymentRequest request = getPaymentRequest();
        PaymentResponse paymentResponse = service.pay(request);

        assertThat(paymentResponse, is(notNullValue()));
        assertThat(paymentResponse.getAmount(), is(AMOUNT));
        assertThat(paymentResponse.getCustomer().getAddress(), is(ADDRESS));
        assertThat(paymentResponse.getCustomer().getEmailAddress(), is(EMAIL_ADDRESS));
        assertThat(paymentResponse.getCustomer().getFirstName(), is(JOHN));
        assertThat(paymentResponse.getCustomer().getLastName(), is(DOE));
    }

    @Test(expected = ResourceAccessException.class)
    public void testShouldThrowException() {
        PaymentRequest request = getIncorrectPaymentRequest();
        service.pay(request);
    }

    private PaymentRequest getPaymentRequest() {
        PaymentRequest request = new PaymentRequest();

        request.setPayment(getPayment());
        request.setCustomer(getCustomer());
        request.setCreditcard(getCreditCard());

        return request;
    }

    private Creditcard getCreditCard() {

//        5177185558812850, CVC2, 464, 12/21
//        5528968625958376, CVC2, 746, 01/20
//        5280348261018280, CVC2, 407, 12/19
//        5515030999376324, CVC2, 486, 06/22
//        5462033142337709, CVC2, 132, 07/19

        Creditcard card = new Creditcard();
        card.setCreditCardNumber("5177185558812850");
        card.setCvc(464);
        card.setExpirationDate(new ExpirationDate(21, 12));

        return card;
    }

    private Creditcard getInvalidCreditCard() {
        Creditcard card = new Creditcard();
//        card.setCreditCardNumber("5177185558812850");
        card.setCreditCardNumber("1234");
        card.setCvc(464);
        card.setExpirationDate(new ExpirationDate(2021, 12)); //invalid year format

        return card;
    }

    private Customer getCustomer() {
        Customer customer = new Customer();
        customer.setFirstName(JOHN);
        customer.setLastName(DOE);
        customer.setEmailAddress(EMAIL_ADDRESS);
        customer.setAddress(ADDRESS);
        customer.setDateOfBirth(DATE_OF_BIRTH);

        return customer;
    }

    private Payment getPayment() {
        return new Payment(AMOUNT, CURRENCY);
    }

    public PaymentRequest getIncorrectPaymentRequest() {
        PaymentRequest request = new PaymentRequest();

        request.setPayment(getPayment());
        request.setCustomer(getCustomer());
        request.setCreditcard(getInvalidCreditCard());

        return request;
    }
}