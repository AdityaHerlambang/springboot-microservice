CREATE TABLE IF NOT EXISTS item (
    id UUID NOT NULL,
    nama_item varchar(50) NOT NULL,
    unit varchar(10) NOT NULL,
    stok INT NOT NULL,
    harga_satuan INT NOT NULL,
    barang TEXT,
    PRIMARY KEY (id)
);