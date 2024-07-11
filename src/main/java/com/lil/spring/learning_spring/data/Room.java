package com.lil.spring.learning_spring.data;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ROOM")
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROOM_ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ROOM_NUMBER")
    private String roomNumber;

    @Column(name = "BED_INFO")
    private String bedInfo;

}
