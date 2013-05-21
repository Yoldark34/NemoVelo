/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.database;

import model.object.UsagePossibility;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Yoldark34 <yoldark@gmail.com>
 */
public class UsagePossibilityMapper extends AbstractMapper {

	public ArrayList<UsagePossibility> getAllUsagePossibilitys() throws SQLException, ClassNotFoundException {
		DbConnection adapter = DbConnection.getDbConnection();
		adapter.executeSelectQuery("Select * from " + DataBaseElements.USAGEPOSSIBILITY);
		return (ArrayList<UsagePossibility>) adapter.getModelsFromRequest(this);
	}

	@Override
	public Object populateModel(ResultSet row) throws SQLException {
		UsagePossibility obj = new UsagePossibility();
		if (this.hasColumn(DataBaseElements.USAGEPOSSIBILITY_IDBIKEUSAGETYPE, row)) {
			obj.setIdBikeUsageType(row.getInt(DataBaseElements.USAGEPOSSIBILITY_IDBIKEUSAGETYPE));
		}
		if (this.hasColumn(DataBaseElements.USAGEPOSSIBILITY_IDUSERTYPE, row)) {
			obj.setIdUserType(row.getInt(DataBaseElements.USAGEPOSSIBILITY_IDUSERTYPE));
		}
		if (this.hasColumn(DataBaseElements.USAGEPOSSIBILITY_IDSTORAGETYPE, row)) {
			obj.setIdStorageType(row.getInt(DataBaseElements.USAGEPOSSIBILITY_IDSTORAGETYPE));
		}
		if (this.hasColumn(DataBaseElements.USAGEPOSSIBILITY_IDRENT, row)) {
			obj.setIdRent(row.getInt(DataBaseElements.USAGEPOSSIBILITY_IDRENT));
		}
		if (this.hasColumn(DataBaseElements.USAGEPOSSIBILITY_IDGUARANTEE, row)) {
			obj.setIdGuarantee(row.getInt(DataBaseElements.USAGEPOSSIBILITY_IDGUARANTEE));
		}

		return obj;
	}
}
