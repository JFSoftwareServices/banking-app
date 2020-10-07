create sequence hibernate_sequence start with 1 increment by 1;

    create table account (
       account_id bigint not null,
        account_number varchar(255),
        current_balance decimal(19,2),
        primary key (account_id)
    );

    create table transaction (
       transaction_id bigint not null,
        account_number varchar(255),
        transaction_amount decimal(19,2),
        transaction_date_time timestamp,
        primary key (transaction_id)
    );

    alter table account 
       add constraint UK_66gkcp94endmotfwb8r4ocxm9 unique (account_number);
create sequence hibernate_sequence start with 1 increment by 1

    create table account (
       account_id bigint not null,
        account_number varchar(255),
        current_balance decimal(19,2),
        primary key (account_id)
    )

    create table transaction (
       transaction_id bigint not null,
        account_number varchar(255),
        transaction_amount decimal(19,2),
        transaction_date_time timestamp,
        primary key (transaction_id)
    )

    alter table account 
       add constraint UK_66gkcp94endmotfwb8r4ocxm9 unique (account_number)
create sequence hibernate_sequence start with 1 increment by 1

    create table account (
       account_id bigint not null,
        account_number varchar(7),
        current_balance decimal(19,2),
        primary key (account_id)
    )

    create table transaction (
       transaction_id bigint not null,
        account_number varchar(7),
        transaction_amount decimal(19,2),
        transaction_date_time timestamp,
        primary key (transaction_id)
    )

    alter table account 
       add constraint UK_66gkcp94endmotfwb8r4ocxm9 unique (account_number)
create sequence hibernate_sequence start with 1 increment by 1

    create table account (
       account_id bigint not null,
        account_number varchar(7),
        current_balance decimal(19,2),
        primary key (account_id)
    )

    create table transaction (
       transaction_id bigint not null,
        account_number varchar(7),
        transaction_amount decimal(19,2),
        transaction_date_time timestamp,
        primary key (transaction_id)
    )

    alter table account 
       add constraint UK_66gkcp94endmotfwb8r4ocxm9 unique (account_number)
create sequence hibernate_sequence start with 1 increment by 1

    create table account (
       account_id bigint not null,
        account_number varchar(7),
        current_balance decimal(19,2),
        primary key (account_id)
    )

    create table transaction (
       transaction_id bigint not null,
        account_number varchar(7),
        transaction_amount decimal(19,2),
        transaction_date_time timestamp,
        primary key (transaction_id)
    )

    alter table account 
       add constraint UK_66gkcp94endmotfwb8r4ocxm9 unique (account_number)
create sequence hibernate_sequence start with 1 increment by 1

    create table account (
       account_id bigint not null,
        account_number varchar(7),
        current_balance decimal(19,2) not null,
        primary key (account_id)
    )

    create table transaction (
       transaction_id bigint not null,
        account_number varchar(7),
        transaction_amount decimal(19,2) not null,
        transaction_date_time timestamp,
        primary key (transaction_id)
    )

    alter table account 
       add constraint UK_66gkcp94endmotfwb8r4ocxm9 unique (account_number)
create sequence hibernate_sequence start with 1 increment by 1

    create table account (
       account_id bigint not null,
        account_number varchar(7),
        current_balance decimal(12,2),
        primary key (account_id)
    )

    create table transaction (
       transaction_id bigint not null,
        account_number varchar(7),
        transaction_amount decimal(12,2),
        transaction_date_time timestamp,
        primary key (transaction_id)
    )

    alter table account 
       add constraint UK_66gkcp94endmotfwb8r4ocxm9 unique (account_number)
create sequence hibernate_sequence start with 1 increment by 1

    create table account (
       account_id bigint not null,
        account_number varchar(7),
        current_balance decimal(12,2),
        primary key (account_id)
    )

    create table transaction (
       transaction_id bigint not null,
        account_number varchar(7),
        transaction_amount decimal(12,2),
        transaction_date_time timestamp,
        primary key (transaction_id)
    )

    alter table account 
       add constraint UK_66gkcp94endmotfwb8r4ocxm9 unique (account_number)
create sequence hibernate_sequence start with 1 increment by 1

    create table account (
       account_id bigint not null,
        account_number varchar(7),
        current_balance decimal(12,2),
        primary key (account_id)
    )

    create table transaction (
       transaction_id bigint not null,
        account_number varchar(7),
        transaction_amount decimal(12,2),
        transaction_date_time timestamp,
        primary key (transaction_id)
    )

    alter table account 
       add constraint UK_66gkcp94endmotfwb8r4ocxm9 unique (account_number)
create sequence hibernate_sequence start with 1 increment by 1

    create table account (
       account_id bigint not null,
        account_number varchar(7),
        current_balance decimal(12,2),
        primary key (account_id)
    )

    create table transaction (
       transaction_id bigint not null,
        account_number varchar(7),
        transaction_amount decimal(12,2),
        transaction_date_time timestamp,
        primary key (transaction_id)
    )

    alter table account 
       add constraint UK_66gkcp94endmotfwb8r4ocxm9 unique (account_number)
create sequence hibernate_sequence start with 1 increment by 1

    create table account (
       account_id bigint not null,
        account_number varchar(7),
        current_balance decimal(12,2),
        primary key (account_id)
    )

    create table transaction (
       transaction_id bigint not null,
        account_number varchar(7),
        transaction_amount decimal(12,2),
        transaction_date_time timestamp,
        primary key (transaction_id)
    )

    alter table account 
       add constraint UK_66gkcp94endmotfwb8r4ocxm9 unique (account_number)
create sequence hibernate_sequence start with 1 increment by 1

    create table account (
       account_id bigint not null,
        account_number varchar(7),
        current_balance decimal(12,2),
        primary key (account_id)
    )

    create table transaction (
       transaction_id bigint not null,
        account_number varchar(7),
        transaction_amount decimal(12,2),
        transaction_date_time timestamp,
        primary key (transaction_id)
    )

    alter table account 
       add constraint UK_66gkcp94endmotfwb8r4ocxm9 unique (account_number)
create sequence hibernate_sequence start with 1 increment by 1

    create table account (
       account_id bigint not null,
        account_number varchar(7),
        current_balance decimal(12,2),
        primary key (account_id)
    )

    create table transaction (
       transaction_id bigint not null,
        account_number varchar(7),
        transaction_amount decimal(12,2),
        transaction_date_time timestamp,
        primary key (transaction_id)
    )

    alter table account 
       add constraint UK_66gkcp94endmotfwb8r4ocxm9 unique (account_number)
create sequence hibernate_sequence start with 1 increment by 1

    create table account (
       account_id bigint not null,
        account_number varchar(7) not null,
        current_balance decimal(12,2) not null,
        primary key (account_id)
    )

    create table transaction (
       transaction_id bigint not null,
        account_number varchar(7) not null,
        transaction_amount decimal(12,2) not null,
        transaction_date_time timestamp,
        primary key (transaction_id)
    )

    alter table account 
       add constraint UK_66gkcp94endmotfwb8r4ocxm9 unique (account_number)
create sequence hibernate_sequence start with 1 increment by 1

    create table account (
       account_id bigint not null,
        account_number varchar(7) not null,
        current_balance decimal(12,2) not null,
        primary key (account_id)
    )

    create table transaction (
       transaction_id bigint not null,
        account_number varchar(7) not null,
        transaction_amount decimal(12,2) not null,
        transaction_date_time timestamp,
        primary key (transaction_id)
    )

    alter table account 
       add constraint UK_66gkcp94endmotfwb8r4ocxm9 unique (account_number)
create sequence hibernate_sequence start with 1 increment by 1

    create table account (
       account_id bigint not null,
        account_number varchar(7) not null,
        current_balance decimal(12,2) not null,
        primary key (account_id)
    )

    create table transaction (
       transaction_id bigint not null,
        account_number varchar(7) not null,
        transaction_amount decimal(12,2) not null,
        transaction_date_time timestamp,
        primary key (transaction_id)
    )

    alter table account 
       add constraint UK_66gkcp94endmotfwb8r4ocxm9 unique (account_number)
create sequence hibernate_sequence start with 1 increment by 1

    create table account (
       account_id bigint not null,
        account_number varchar(7) not null,
        current_balance decimal(12,2) not null,
        primary key (account_id)
    )

    create table transaction (
       transaction_id bigint not null,
        account_number varchar(7) not null,
        transaction_amount decimal(12,2) not null,
        transaction_date_time timestamp,
        primary key (transaction_id)
    )

    alter table account 
       add constraint UK_66gkcp94endmotfwb8r4ocxm9 unique (account_number)
create sequence hibernate_sequence start with 1 increment by 1

    create table account (
       account_id bigint not null,
        account_number varchar(7) not null,
        current_balance decimal(12,2) not null,
        primary key (account_id)
    )

    create table transaction (
       transaction_id bigint not null,
        account_number varchar(7) not null,
        transaction_amount decimal(12,2) not null,
        transaction_date_time timestamp,
        primary key (transaction_id)
    )

    alter table account 
       add constraint UK_66gkcp94endmotfwb8r4ocxm9 unique (account_number)
create sequence hibernate_sequence start with 1 increment by 1

    create table account (
       account_id bigint not null,
        account_number varchar(7) not null,
        current_balance decimal(12,2) not null,
        primary key (account_id)
    )

    create table transaction (
       transaction_id bigint not null,
        account_number varchar(7) not null,
        transaction_amount decimal(12,2) not null,
        transaction_date_time timestamp,
        primary key (transaction_id)
    )

    alter table account 
       add constraint UK_66gkcp94endmotfwb8r4ocxm9 unique (account_number)
create sequence hibernate_sequence start with 1 increment by 1

    create table account (
       account_id bigint not null,
        account_number varchar(7) not null,
        current_balance decimal(12,2) not null,
        primary key (account_id)
    )

    create table transaction (
       transaction_id bigint not null,
        account_number varchar(7) not null,
        transaction_amount decimal(12,2) not null,
        transaction_date_time timestamp,
        primary key (transaction_id)
    )

    alter table account 
       add constraint UK_66gkcp94endmotfwb8r4ocxm9 unique (account_number)
create sequence hibernate_sequence start with 1 increment by 1

    create table account (
       account_id bigint not null,
        account_number varchar(7) not null,
        current_balance decimal(12,2) not null,
        primary key (account_id)
    )

    create table transaction (
       transaction_id bigint not null,
        account_number varchar(7) not null,
        transaction_amount decimal(12,2) not null,
        transaction_date_time timestamp,
        primary key (transaction_id)
    )

    alter table account 
       add constraint UK_66gkcp94endmotfwb8r4ocxm9 unique (account_number)
create sequence hibernate_sequence start with 1 increment by 1

    create table account (
       account_id bigint not null,
        account_number varchar(7) not null,
        current_balance decimal(12,2) not null,
        primary key (account_id)
    )

    create table transaction (
       transaction_id bigint not null,
        account_number varchar(7) not null,
        transaction_amount decimal(12,2) not null,
        transaction_date_time timestamp,
        primary key (transaction_id)
    )

    alter table account 
       add constraint UK_66gkcp94endmotfwb8r4ocxm9 unique (account_number)
create sequence hibernate_sequence start with 1 increment by 1

    create table account (
       account_id bigint not null,
        account_number varchar(7) not null,
        current_balance decimal(12,2) not null,
        primary key (account_id)
    )

    create table transaction (
       transaction_id bigint not null,
        account_number varchar(7) not null,
        transaction_amount decimal(12,2) not null,
        transaction_date_time timestamp,
        primary key (transaction_id)
    )

    alter table account 
       add constraint UK_66gkcp94endmotfwb8r4ocxm9 unique (account_number)
create sequence hibernate_sequence start with 1 increment by 1

    create table account (
       account_id bigint not null,
        account_number varchar(7) not null,
        current_balance decimal(12,2) not null,
        primary key (account_id)
    )

    create table transaction (
       transaction_id bigint not null,
        account_number varchar(7) not null,
        transaction_amount decimal(12,2) not null,
        transaction_date_time timestamp,
        primary key (transaction_id)
    )

    alter table account 
       add constraint UK_66gkcp94endmotfwb8r4ocxm9 unique (account_number)
create sequence hibernate_sequence start with 1 increment by 1

    create table account (
       account_id bigint not null,
        account_number varchar(7) not null,
        current_balance decimal(12,2) not null,
        primary key (account_id)
    )

    create table transaction (
       transaction_id bigint not null,
        account_number varchar(7) not null,
        transaction_amount decimal(12,2) not null,
        transaction_date_time timestamp,
        primary key (transaction_id)
    )

    alter table account 
       add constraint UK_66gkcp94endmotfwb8r4ocxm9 unique (account_number)
create sequence hibernate_sequence start with 1 increment by 1

    create table account (
       account_id bigint not null,
        account_number varchar(7) not null,
        current_balance decimal(12,2) not null,
        primary key (account_id)
    )

    create table transaction (
       transaction_id bigint not null,
        account_number varchar(7) not null,
        transaction_amount decimal(12,2) not null,
        transaction_date_time timestamp,
        primary key (transaction_id)
    )

    alter table account 
       add constraint UK_66gkcp94endmotfwb8r4ocxm9 unique (account_number)
create sequence hibernate_sequence start with 1 increment by 1

    create table account (
       account_id bigint not null,
        account_number varchar(7) not null,
        current_balance decimal(12,2) not null,
        primary key (account_id)
    )

    create table transaction (
       transaction_id bigint not null,
        account_number varchar(7) not null,
        transaction_amount decimal(12,2) not null,
        transaction_date_time timestamp,
        primary key (transaction_id)
    )

    alter table account 
       add constraint UK_66gkcp94endmotfwb8r4ocxm9 unique (account_number)
