CREATE TABLE IF NOT EXISTS cards (
    card_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    card_number VARCHAR(50) NOT NULL,
    card_type VARCHAR(100) NOT NULL,
    total_limit DECIMAL(15,2) NOT NULL,
    amount_used DECIMAL(15,2) NOT NULL,
    available_amount DECIMAL(15,2) NOT NULL,
    created_at DATE NOT NULL,
    created_by VARCHAR(20) NOT NULL,
    updated_at DATE DEFAULT NULL,
    updated_by VARCHAR(20) DEFAULT NULL
);

