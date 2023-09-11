package com.herlambang.pos.item.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id")
    private UUID id;

    @Column(name = "nama_item")
    private String namaItem;

    @Column(name = "stok")
    private String stok;

    @Column(name = "harga_satuan")
    private Integer hargaSatuan;

    @Column(name = "barang")
    private String barang;

}