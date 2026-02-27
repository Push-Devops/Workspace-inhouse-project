package com.spapplication.cards.service.impl;

import com.spapplication.cards.dto.CardDto;
import com.spapplication.cards.entity.Card;
import com.spapplication.cards.repository.CardRepository;
import com.spapplication.cards.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Override
    public CardDto createCard(CardDto cardDto) {
        Card card = new Card();
        card.setCustomerId(cardDto.getCustomerId());
        card.setCardNumber(cardDto.getCardNumber());
        card.setCardType(cardDto.getCardType());
        card.setTotalLimit(cardDto.getTotalLimit());
        card.setAmountUsed(cardDto.getAmountUsed());
        card.setAvailableAmount(cardDto.getAvailableAmount());
        card.setCreatedAt(LocalDate.now());
        card.setCreatedBy("SYSTEM");

        Card saved = cardRepository.save(card);
        cardDto.setCardId(saved.getCardId());
        return cardDto;
    }

    @Override
    public List<CardDto> getCardsByCustomerId(Long customerId) {
        return cardRepository.findByCustomerId(customerId)
                .stream()
                .map(card -> {
                    CardDto dto = new CardDto();
                    dto.setCardId(card.getCardId());
                    dto.setCustomerId(card.getCustomerId());
                    dto.setCardNumber(card.getCardNumber());
                    dto.setCardType(card.getCardType());
                    dto.setTotalLimit(card.getTotalLimit());
                    dto.setAmountUsed(card.getAmountUsed());
                    dto.setAvailableAmount(card.getAvailableAmount());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}

