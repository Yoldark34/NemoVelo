package model.database;

/**
 *
 * @author Valentin SEITZ
 */
public class DataBaseElementNames {

	public static final String BIKE = "bike";
	public static final String BIKE_ID = "id";
	public static final String BIKE_USAGE = "bike_usage";
	public static final String BIKE_USAGE_ID = "id";
	public static final String BIKE_USAGE_ID_NEMO_USER = "id_nemo_user";
	public static final String BIKE_USAGE_ID_BIKE_USAGE_TYPE = "id_bike_usage_type";
	public static final String BIKE_USAGE_ID_BIKE = "id_bike";
	public static final String BIKE_USAGE_ID_END_STORAGE = "id_end_storage";
	public static final String BIKE_USAGE_START_DATE = "start_date";
	public static final String BIKE_USAGE_END_DATE = "end_date";
	public static final String BIKE_USAGE_COMMENTS = "comments";
	public static final String BIKE_USAGE_TYPE = "bike_usage_type";
	public static final String BIKE_USAGE_TYPE_ID = "id";
	public static final String BIKE_USAGE_TYPE_ID_PARENT = "id_parent_bike_usage_type";
	public static final String BIKE_USAGE_TYPE_NAME = "name";
	public static final String BIKE_USAGE_TYPE_DESCRIPTION = "description";
	public static final String CONTACT = "contact";
	public static final String CONTACT_ID = "id";
	public static final String CONTACT_STREET_NUMBER = "street_number";
	public static final String CONTACT_STREET_NAME = "street_name";
	public static final String CONTACT_ZIP_CODE = "zip_code";
	public static final String CONTACT_CITY = "city";
	public static final String CONTACT_COUNTRY = "country";
	public static final String CONTACT_PHONE_NUMBER = "phone_number";
	public static final String NEMO_USER = "nemo_user";
	public static final String NEMO_USER_ID = "id";
	public static final String NEMO_USER_LAST_NAME = "last_name";
	public static final String NEMO_USER_FIRST_NAME = "first_name";
	public static final String NEMO_USER_EMAIL = "email";
	public static final String NEMO_USER_CRYPTED_PASSWORD = "crypted_password";
	public static final String NEMO_USER_BIRTH_DATE = "birth_date";
	public static final String NEMO_USER_CREATE_DATE = "create_date";
	public static final String NEMO_USER_TYPE = "nemo_user_type";
	public static final String NEMO_USER_TYPE_ID_USER = "id_user";
	public static final String NEMO_USER_TYPE_ID_USER_TYPE = "id_user_type";
	public static final String PAYMENT = "payment";
	public static final String PAYMENT_ID = "id";
	public static final String PAYMENT_ID_SUBSCRIPTION = "id_subscription";
	public static final String PAYMENT_AMOUNT = "amount";
	public static final String PAYMENT_PAYMENT_DATE = "payment_date";
	public static final String PAYMENT_VALIDATED = "validated";
	public static final String PRICE = "price";
	public static final String PRICE_ID = "id";
	public static final String PRICE_AMOUNT = "amount";
	public static final String PRICE_TYPE_CODE = "type_code";
	public static final String PRICE_NAME = "name";
	public static final String PRICE_DESCRIPTION = "description";
	public static final String PRICE_DURATION = "price_duration";
	public static final String PRICE_DURATION_UNIT = "price_duration_unit";
	public static final String STOCK = "stock";
	public static final String STOCK_ID = "id";
	public static final String STOCK_CODE = "code";
	public static final String STOCK_NAME = "name";
	public static final String STOCK_DESCRIPTION = "description";
	public static final String STOCK_LATITUDE = "latitude";
	public static final String STOCK_LONGITUDE = "longitude";
	public static final String STORAGE = "storage";
	public static final String STORAGE_ID = "id";
	public static final String STORAGE_ID_STOCK = "id_stock";
	public static final String STORAGE_ID_STORAGE_TYPE = "id_sorage_type";
	public static final String STORAGE_TYPE = "storage_type";
	public static final String STORAGE_TYPE_ID = "id";
	public static final String STORAGE_TYPE_CODE = "code";
	public static final String STORAGE_TYPE_NAME = "name";
	public static final String STORAGE_TYPE_DESCRIPTION = "description";
	public static final String SUBSCRIPTION = "subscription";
	public static final String SUBSCRIPTION_ID = "id";
	public static final String SUBSCRIPTION_ID_PRICE = "id_price";
	public static final String SUBSCRIPTION_ID_NEMO_USER = "id_nemo_user";
	public static final String SUBSCRIPTION_AMOUNT = "amount";
	public static final String SUBSCRIPTION_SART_DATE = "start_date";
	public static final String SUBSCRIPTION_END_DATE = "end_date";
	public static final String TERMINAL = "terminal";
	public static final String TERMINAL_ID = "id";
	public static final String TERMINAL_ID_STOCK = "id_stock";
	public static final String TERMINAL_IP = "ip";
	public static final String USAGE_POSSIBILITY = "usage_possibility";
	public static final String USAGE_POSSIBILITY_ID = "id";
	public static final String USAGE_POSSIBILITY_ID_USER_TYPE = "id_user_type";
	public static final String USAGE_POSSIBILITY_ID_STORAGE_TYPE = "id_storage_type";
	public static final String USAGE_POSSIBILITY_ID_RENT = "id_rent";
	public static final String USAGE_POSSIBILITY_ID_GUARANTEE = "id_guarantee";
	public static final String USER_TYPE = "user_type";
	public static final String USER_TYPE_ID = "id";
	public static final String USER_TYPE_ID_PARENT = "id_parent_user_type";
	public static final String USER_TYPE_CODE = "code";
	public static final String USER_TYPE_NAME = "name";
	public static final String USER_TYPE_DESCRIPTION = "description";
}
