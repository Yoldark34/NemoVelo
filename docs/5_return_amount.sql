create table return_amount (
	id bigint not null ,
	id_subscription bigint not null ,
	amount decimal(6,2) ,
	return_date datetime not null ,
	constraint pk_return_amount primary key (id)
);

alter table return_amount add constraint fk_return_amount_subscription
foreign key (id_subscription) references subscription (id);