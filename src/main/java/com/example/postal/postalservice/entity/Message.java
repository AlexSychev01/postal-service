package com.example.postal.postalservice.entity;


import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@Entity
@Builder
@Table(name = "messages")

public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String idNumber;
    private String recipientName;
    private int index;
    private String address;
    private String status;
    private String type;


    public Message(int id, String idNumber, String recipientName, int index, String address, String status, String type) {
        this.id = id;
        this.idNumber = idNumber;
        this.recipientName = recipientName;
        this.index = index;
        this.address = address;
        this.status = status;
        this.type = type;
    }

    public Message() {
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", idNumber='" + idNumber + '\'' +
                ", recipientName='" + recipientName + '\'' +
                ", index=" + index +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", type=" + type +
                '}';
    }
}
