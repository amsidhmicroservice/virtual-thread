package com.amsidh.mvc.client.model;

import java.util.List;

public record Transportation(List<CarRental> carRentals, List<PublicTransportation> publicTransportations) {
}
