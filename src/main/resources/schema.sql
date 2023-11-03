drop table if exists technical_details;
drop table if exists products;


CREATE TABLE products
(product_id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY ,
 product_name varchar(30) NOT NULL ,
 product_price numeric(10, 4) not null );

CREATE TABLE technical_details (
                                                 technical_details_id bigint PRIMARY KEY ,
                                                 technical_details_title varchar(250) NOT NULL,
                                                 technical_details_description varchar(250) NOT NULL,
                                                 product_id bigint NOT NULL, foreign key (product_id) references
                               products(product_id)
);






