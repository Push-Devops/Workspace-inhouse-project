package com.spapplication.cards.service;

import com.spapplication.cards.dto.CardDto;

import java.util.List;

public interface CardService {

    CardDto createCard(CardDto cardDto);

    List<CardDto> getCardsByCustomerId(Long customerId);
}

