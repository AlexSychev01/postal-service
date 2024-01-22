package com.example.postal.postalservice.DTO;

import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageDTO {
     int id;
     String idNumber;
     String recipientName;
     int index;
     String address;
     String status;
     String type;


}
