package com.axon.command;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
public class ApproveOrderCommand {

    @TargetAggregateIdentifier
    private final String orderId;
}
