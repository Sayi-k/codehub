package com.axon.command;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
public class  RejectOrderCommand {

    @TargetAggregateIdentifier
    private final String orderId;
    private final String reason;
}
