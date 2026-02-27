package com.spapplication.cards.controller;

import com.spapplication.cards.dto.CardDto;
import com.spapplication.cards.service.CardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(
        name = "Cards APIs",
        description = "REST APIs for managing customer cards"
)
@RestController
@RequestMapping(path = "/api/cards", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
public class CardController {

    private final CardService cardService;

    @Operation(
            summary = "Create Card",
            description = "Create a new card for a customer"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Card created",
                    content = @Content(schema = @Schema(implementation = CardDto.class))
            )
    })
    @PostMapping
    public ResponseEntity<CardDto> createCard(@Valid @RequestBody CardDto cardDto) {
        CardDto created = cardService.createCard(cardDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Operation(
            summary = "Get Cards by Customer",
            description = "Fetch all cards for a given customer"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Cards fetched",
                    content = @Content(schema = @Schema(implementation = CardDto.class))
            )
    })
    @GetMapping
    public ResponseEntity<List<CardDto>> getCardsByCustomer(
            @RequestParam @NotNull Long customerId) {
        return ResponseEntity.ok(cardService.getCardsByCustomerId(customerId));
    }
}

