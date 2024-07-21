package com.amsidh.mvc.client.model;

import java.time.LocalDate;

public record Event(String name, String description, LocalDate date) {
}
