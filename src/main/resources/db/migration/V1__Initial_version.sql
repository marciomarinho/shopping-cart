drop table if exists product CASCADE;
drop table if exists shopping_cart CASCADE;
drop table if exists shopping_cart_items CASCADE;
drop table if exists shopping_cart_item CASCADE;
drop sequence if exists hibernate_sequence;

create sequence hibernate_sequence start with 1 increment by 1;
create table product (id bigint not null, description varchar(255), price decimal(19,2), primary key (id));
create unique index product_idx_desc on product (description);

create table shopping_cart (id bigint not null, total decimal(19,2), primary key (id));
create table shopping_cart_items (shopping_cart_id bigint not null, items_id bigint not null);
create table shopping_cart_item (id bigint not null, price decimal(19,2), product_id bigint, primary key (id));
alter table shopping_cart_items add constraint UK_ln84ylb54v72dt5hxftrtas48 unique (items_id);
alter table shopping_cart_items add constraint FKi7bhq9pkmv871ctjx1xrm7pm1 foreign key (items_id) references shopping_cart_item;
alter table shopping_cart_items add constraint FKn4ocuqbcv64d0pvyhv863l1y5 foreign key (shopping_cart_id) references shopping_cart;
alter table shopping_cart_item add constraint FKnqunkunvnryn6k78joe6n7yxr foreign key (product_id) references product;