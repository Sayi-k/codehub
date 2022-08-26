package com.axon.query;

import com.core.model.PaymentDetails;
import com.core.model.User;
import com.core.query.FetchUserPaymentDetailsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class UserQueryHandler {

    @QueryHandler
    public User handle(FetchUserPaymentDetailsQuery query){
        PaymentDetails paymentDetails = PaymentDetails.builder()
                .cardNumber("123Card")
                .cvv("123")
                .name("ABC XYZ")
                .validUntilMonth(12)
                .validUntilYear(2030)
                .build();

        return User.builder()
                .firstName("ABC")
                .lastName("XYZ")
                .userId(query.getUserId())
                .paymentDetails(paymentDetails)
                .build();
    }

}
