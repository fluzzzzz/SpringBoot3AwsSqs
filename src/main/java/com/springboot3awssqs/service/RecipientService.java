package com.springboot3awssqs.service;

import com.springboot3awssqs.dto.RecipientDto;
import com.springboot3awssqs.entiity.NotificationEntity;
import com.springboot3awssqs.entiity.RecipientEntity;
import com.springboot3awssqs.mapper.RecipientMapper;
import com.springboot3awssqs.repository.NotificationRepository;
import com.springboot3awssqs.repository.RecipientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipientService {

    private final NotificationRepository notificationRepository;
    private final RecipientRepository recipientRepository;
    private final RecipientMapper recipientMapper;

    public Mono<RecipientDto> findRecipientWithNotificationsByUid(String uid) {
        return Mono.zip(recipientRepository.findById(uid),
                        notificationRepository.findAllByRecipientUid(uid).collectList())
                .map(tuples -> {
                    RecipientEntity recipient = tuples.getT1();
                    List<NotificationEntity> notifications = tuples.getT2();
                    recipient.setNotifications(notifications);
                    return recipientMapper.map(recipient);
                });
    }
}
