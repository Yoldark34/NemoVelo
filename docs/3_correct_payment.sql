ALTER TABLE `payment`
ADD COLUMN `id_nemo_user` bigint;

ALTER TABLE `payment`
add CONSTRAINT `fk_payment_nemo_user` foreign key (`id_nemo_user`) references `nemo_user` (`id`);

ALTER TABLE `payment` CHANGE `id_subscription` `id_subscription` BIGINT( 20 ) NULL ;
