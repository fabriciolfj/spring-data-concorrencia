package com.github.fabriciolfj.inventaryserviceimperativo.domain;

import com.github.fabriciolfj.inventaryserviceimperativo.exceptions.TypeOperationNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum TypeOperation {

    EXIT("exit"),
    ENTRANCE("entrance");

    private final String description;

    public static TypeOperation toEnum(final String description) {
        return Stream.of(TypeOperation.values())
                .filter(c -> c.getDescription().equals(description))
                .findAny()
                .orElseThrow(TypeOperationNotFoundException::new);
    }
}
