package com.ecobank.personalAcc.repository.repoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.ecobank.personalAcc.model.PersonalAccounts;
import com.ecobank.personalAcc.repository.PersonalAccountRepo;
import com.ecobank.personalAcc.utils.DatabaseConnection;

@Repository
public class PersonalAccRepoImpl implements PersonalAccountRepo {

	@Override
	public List<PersonalAccounts> getPersonalAccount(String accountNumber) {

		Connection conn = null;
		ResultSet resultSet = null;
		CallableStatement cStmt = null;

		List<PersonalAccounts> personalAccounts = new ArrayList();
		PersonalAccounts account;

		try {
			try {
				conn = DatabaseConnection.getConnection();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cStmt = conn.prepareCall("{call pckg_gdk_acc_details.PR_GET_multiple_accounts(?,?,?)}");
			cStmt.setString(1, accountNumber);
			cStmt.registerOutParameter(2, Types.REF_CURSOR);
			cStmt.registerOutParameter(3, Types.VARCHAR);
			cStmt.execute();

			resultSet = (ResultSet) cStmt.getObject(2);

			while (resultSet.next()) {
				System.out.println("Got here");

				account = new PersonalAccounts();

				account.setCustomerId(resultSet.getString(1));
				account.setName(resultSet.getString(2));
				account.setAccountNumber(resultSet.getString(3));
				account.setEmail(resultSet.getString(4));
				account.setTelephone(resultSet.getString(5));
				account.setAccountClass(resultSet.getString(6));

				personalAccounts.add(account);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DatabaseConnection.close(conn, cStmt, resultSet);
		}
		return personalAccounts;

	}

}
