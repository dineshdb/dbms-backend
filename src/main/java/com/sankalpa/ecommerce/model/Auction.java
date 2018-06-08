package com.sankalpa.ecommerce.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Auction implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
}