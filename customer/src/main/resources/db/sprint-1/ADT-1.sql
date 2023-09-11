CREATE TABLE IF NOT EXISTS customer (
    id UUID PRIMARY KEY,
    nama VARCHAR(255),
    contact VARCHAR(255),
    email VARCHAR(255),
    alamat TEXT,
    diskon BIGINT,
    tipe_diskon VARCHAR(255),
    ktp TEXT,
    PRIMARY KEY (id)
);
