package com.spapplication.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(
        name = "Card",
        description = "Schema to hold Card information"
)
public class CardDto {

    @Schema(description = "Card identifier", example = "1")
    private Long cardId;

    @Schema(description = "Customer identifier", example = "1001")
    private Long customerId;

    @Schema(description = "Card number", example = "4111111111111111")
    private String cardNumber;

    @Schema(description = "Type of card", example = "CREDIT")
    private String cardType;

    @Schema(description = "Total limit on card", example = "100000.00")
    private BigDecimal totalLimit;

    @Schema(description = "Amount used so far", example = "25000.00")
    private BigDecimal amountUsed;

    @Schema(description = "Available amount", example = "75000.00")
    private BigDecimal availableAmount;
}

