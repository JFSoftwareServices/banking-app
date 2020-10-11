TODO 
    
    - Checkup on transactions and locks and ensure I've done correct implementation
    - Complete this readme with proper instructions
    - Investigate how the database is set up etc, when this project is submitted as assignment
    - Add Swagger anotations
    - Follow Udemy course and add database h2 as per course
    - Follow Udemy course add any other things
     
# banking-app

Run the main application, this generates create.sql. Use create.sql to populate DB, looks something like below

create sequence hibernate_sequence start with 1 increment by 1;

    create table account (
       account_id bigint not null,
        account_number varchar(7) not null,
        current_balance decimal(12,2) not null,
        primary key (account_id)
    );

    create table transaction (
       transaction_id bigint not null,
        account_number varchar(7) not null,
        transaction_amount decimal(12,2) not null,
        transaction_date_time timestamp,
        account_id bigint,
        primary key (transaction_id)
    );

    alter table account 
       add constraint UK_66gkcp94endmotfwb8r4ocxm9 unique (account_number)

    alter table transaction 
       add constraint FK6g20fcr3bhr6bihgy24rq1r1b 
       foreign key (account_id) 
       references account;

DB h2 url http://localhost:8080/h2-console/

All the requests are in postman