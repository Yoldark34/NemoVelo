package model.database;

/**
 *
 * @author Valentin SEITZ
 */
public class DataBaseElements {

	public static final String ALIAS_BIKE = "b";
	public static final String ALIAS_BIKEUSAGE = "bu";
	public static final String ALIAS_BIKEUSAGETYPE = "but";
	public static final String ALIAS_CONTACT = "c";
	public static final String ALIAS_NEMOUSER = "nu";
	public static final String ALIAS_NEMOUSERTYPE = "nut";
	public static final String ALIAS_PAYMENT = "p";
	public static final String ALIAS_PRICE = "pr";
	public static final String ALIAS_STOCK = "s";
	public static final String ALIAS_STORAGE = "st";
	public static final String ALIAS_STORAGETYPE = "stt";
	public static final String ALIAS_SUBSCRIPTION = "su";
	public static final String ALIAS_TERMINAL = "t";
	public static final String ALIAS_USAGEPOSSIBILITY = "up";
	public static final String ALIAS_USERTYPE = "ut";
	public static final String BIKE = "bike";
	public static final String BIKE_ID = "id";
	public static final String BIKEUSAGE = "bike_usage";
	public static final String BIKEUSAGE_ID = "id";
	public static final String BIKEUSAGE_IDNEMOUSER = "id_nemo_user";
	public static final String BIKEUSAGE_IDBIKEUSAGETYPE = "id_bike_usage_type";
	public static final String BIKEUSAGE_IDBIKE = "id_bike";
	public static final String BIKEUSAGE_IDENDSTORAGE = "id_end_storage";
	public static final String BIKEUSAGE_STARTDATE = "start_date";
	public static final String BIKEUSAGE_ENDDATE = "end_date";
	public static final String BIKEUSAGE_COMMENTS = "comments";
	public static final String BIKEUSAGETYPE = "bike_usage_type";
	public static final String BIKEUSAGETYPE_ID = "id";
	public static final String BIKEUSAGETYPE_IDPARENT = "id_parent_bike_usage_type";
	public static final String BIKEUSAGETYPE_NAME = "name";
	public static final String BIKEUSAGETYPE_DESCRIPTION = "description";
	public static final String CONTACT = "contact";
	public static final String CONTACT_ID = "id";
	public static final String CONTACT_STREETNUMBER = "street_number";
	public static final String CONTACT_STREETNAME = "street_name";
	public static final String CONTACT_ZIPCODE = "zip_code";
	public static final String CONTACT_CITY = "city";
	public static final String CONTACT_COUNTRY = "country";
	public static final String CONTACT_PHONENUMBER = "phone_number";
	public static final String NEMOUSER = "nemo_user";
	public static final String NEMOUSER_ID = "id";
	public static final String NEMOUSER_LASTNAME = "last_name";
	public static final String NEMOUSER_FIRSTNAME = "first_name";
	public static final String NEMOUSER_EMAIL = "email";
	public static final String NEMOUSER_CRYPTEDPASSWORD = "crypted_password";
	public static final String NEMOUSER_BIRTHDATE = "birth_date";
	public static final String NEMOUSER_CREATEDATE = "create_date";
	public static final String NEMOUSERTYPE = "nemo_user_type";
	public static final String NEMOUSERTYPE_IDUSER = "id_user";
	public static final String NEMOUSERTYPE_IDUSERTYPE = "id_user_type";
	public static final String PAYMENT = "payment";
	public static final String PAYMENT_ID = "id";
	public static final String PAYMENT_IDSUBSCRIPTION = "id_subscription";
	public static final String PAYMENT_IDNEMOUSER = "id_nemo_user";
	public static final String PAYMENT_AMOUNT = "amount";
	public static final String PAYMENT_PAYMENTDATE = "payment_date";
	public static final String PAYMENT_VALIDATED = "validated";
	public static final String PRICE = "price";
	public static final String PRICE_ID = "id";
	public static final String PRICE_AMOUNT = "amount";
	public static final String PRICE_TYPECODE = "type_code";
	public static final String PRICE_NAME = "name";
	public static final String PRICE_DESCRIPTION = "description";
	public static final String PRICE_DURATION = "price_duration";
	public static final String PRICE_DURATIONUNIT = "price_duration_unit";
	public static final String STOCK = "stock";
	public static final String STOCK_ID = "id";
	public static final String STOCK_CODE = "code";
	public static final String STOCK_NAME = "name";
	public static final String STOCK_DESCRIPTION = "description";
	public static final String STOCK_LATITUDE = "latitude";
	public static final String STOCK_LONGITUDE = "longitude";
	public static final String STORAGE = "storage";
	public static final String STORAGE_ID = "id";
	public static final String STORAGE_IDSTOCK = "id_stock";
	public static final String STORAGE_IDSTORAGETYPE = "id_storage_type";
	public static final String STORAGETYPE = "storage_type";
	public static final String STORAGETYPE_ID = "id";
	public static final String STORAGETYPE_CODE = "code";
	public static final String STORAGETYPE_NAME = "name";
	public static final String STORAGETYPE_DESCRIPTION = "description";
	public static final String SUBSCRIPTION = "subscription";
	public static final String SUBSCRIPTION_ID = "id";
	public static final String SUBSCRIPTION_IDPRICE = "id_price";
	public static final String SUBSCRIPTION_IDNEMOUSER = "id_nemo_user";
	public static final String SUBSCRIPTION_AMOUNT = "amount";
	public static final String SUBSCRIPTION_STARTDATE = "start_date";
	public static final String SUBSCRIPTION_ENDDATE = "end_date";
	public static final String TERMINAL = "terminal";
	public static final String TERMINAL_ID = "id";
	public static final String TERMINAL_IDSTOCK = "id_stock";
	public static final String TERMINAL_IP = "ip";
	public static final String USAGEPOSSIBILITY = "usage_possibility";
	public static final String USAGEPOSSIBILITY_IDBIKEUSAGETYPE = "id_bike_usage_type";
	public static final String USAGEPOSSIBILITY_IDUSERTYPE = "id_user_type";
	public static final String USAGEPOSSIBILITY_IDSTORAGETYPE = "id_storage_type";
	public static final String USAGEPOSSIBILITY_IDRENT = "id_rent";
	public static final String USAGEPOSSIBILITY_IDGUARANTEE = "id_guarantee";
	public static final String USERTYPE = "user_type";
	public static final String USERTYPE_ID = "id";
	public static final String USERTYPE_IDPARENTUSERTYPE = "id_parent_user_type";
	public static final String USERTYPE_CODE = "code";
	public static final String USERTYPE_NAME = "name";
	public static final String USERTYPE_DESCRIPTION = "description";
	public static final int SIZEOF_BIKEUSAGE_COMMENTS = 512;
	public static final int SIZEOF_BIKEUSAGETYPE_NAME = 20;
	public static final int SIZEOF_BIKEUSAGETYPE_DESCRIPTION = 20;
	public static final int SIZEOF_CONTACT_STREETNAME = 128;
	public static final int SIZEOF_CONTACT_ZIPCODE = 5;
	public static final int SIZEOF_CONTACT_CITY = 128;
	public static final int SIZEOF_CONTACT_COUNTRY = 128;
	public static final int SIZEOF_NEMOUSER_LASTNAME = 128;
	public static final int SIZEOF_NEMOUSER_FIRSTNAME = 128;
	public static final int SIZEOF_NEMOUSER_EMAIL = 60;
	public static final int SIZEOF_NEMOUSER_CRYPTEDPASSWORD = 40;
	public static final int SIZEOF_PRICE_NAME = 128;
	public static final int SIZEOF_PRICE_DESCRIPTION = 512;
	public static final int SIZEOF_STOCK_CODE = 128;
	public static final int SIZEOF_STOCK_NAME = 128;
	public static final int SIZEOF_STOCK_DESCRIPTION = 512;
	public static final int SIZEOF_STORAGETYPE_CODE = 128;
	public static final int SIZEOF_STORAGETYPE_NAME = 128;
	public static final int SIZEOF_STORAGETYPE_DESCRIPTION = 512;
	public static final int SIZEOF_TERMINAL_IP = 20;
	public static final int SIZEOF_USERTYPE_CODE = 128;
	public static final int SIZEOF_USERTYPE_NAME = 20;

	public class PriceDurationUnit{
		public static final String MINUTE = "minute";
		public static final String HOUR = "hour";
		public static final String DAY = "day";
		public static final String WEEK = "week";
		public static final String MONTH = "month";
	}

	public class BikeUsageType {
		public static final String STOCKING = "Stockage";
		public static final String BOOKING = "Réservation";
		public static final String RENTING = "Location";
	}

	public class UserType {
		public static final String TEST = "Test";
		public static final String ANONYMOUS = "Anonyme";
	}

	public class PriceTypeCode {
		public static final String GUARANTEE = "guarantee";
		public static final String RENT = "rent";
	}

	public class BikeUsageColSet {

		public static final String FULL = DataBaseElements.ALIAS_BIKEUSAGE + "." + DataBaseElements.BIKEUSAGE_ID + ", "
				+ DataBaseElements.ALIAS_BIKEUSAGE + "." + DataBaseElements.BIKEUSAGE_IDNEMOUSER + ", "
				+ DataBaseElements.ALIAS_BIKEUSAGE + "." + DataBaseElements.BIKEUSAGE_IDBIKEUSAGETYPE + ", "
				+ DataBaseElements.ALIAS_BIKEUSAGE + "." + DataBaseElements.BIKEUSAGE_IDBIKE + ", "
				+ DataBaseElements.ALIAS_BIKEUSAGE + "." + DataBaseElements.BIKEUSAGE_IDENDSTORAGE + ", "
				+ DataBaseElements.ALIAS_BIKEUSAGE + "." + DataBaseElements.BIKEUSAGE_STARTDATE + ", "
				+ DataBaseElements.ALIAS_BIKEUSAGE + "." + DataBaseElements.BIKEUSAGE_ENDDATE;
	}
}
