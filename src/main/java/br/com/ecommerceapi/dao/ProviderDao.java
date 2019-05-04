package br.com.ecommerceapi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ecommerceapi.entity.Provider;
import br.com.ecommerceapi.util.ConnectionConfiguration;

@Service
public class ProviderDao {

	public void delete(Integer id) throws Exception {

		PreparedStatement prepStat = null;
		Connection conn = null;
		ResultSet rs = null;

		try {

			conn = br.com.ecommerceapi.database.Connection.getConnectionMySql();

			StringBuilder sql = new StringBuilder();
			sql.append(" DELETE FROM provider");
			sql.append(" WHERE id = ?");

			prepStat = conn.prepareStatement(sql.toString());

			prepStat.setInt(1, id);

			prepStat.execute();

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			ConnectionConfiguration.db(prepStat, rs, conn);

		}

	}

	public Long insert(Provider provider) throws Exception {

		PreparedStatement prepStat = null;
		Connection conn = null;
		ResultSet rs = null;

		try {

			conn = br.com.ecommerceapi.database.Connection.getConnectionMySql();

			StringBuilder sql = new StringBuilder();
			sql.append(" INSERT INTO provider");
			sql.append(" (name, email)");
			sql.append(" VALUES(?, ?)");

			prepStat = conn.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);

			prepStat.setString(1, provider.getName());

			prepStat.setString(2, provider.getEmail());

			prepStat.execute();

			rs = prepStat.getGeneratedKeys();
			if (rs.next()) {
				return rs.getLong(1);
			}

			return null;

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			ConnectionConfiguration.db(prepStat, rs, conn);

		}
	}

	public List<Provider> select() throws Exception {

		PreparedStatement prepStat = null;
		Connection conn = null;
		ResultSet rs = null;

		try {

			conn = br.com.ecommerceapi.database.Connection.getConnectionMySql();

			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT id, name, email");
			sql.append(" FROM provider");

			prepStat = conn.prepareStatement(sql.toString());

			rs = prepStat.executeQuery();

			List<Provider> listProvider = new ArrayList<Provider>();

			while (rs.next()) {

				Provider provider = new Provider();

				provider.setId(rs.getInt("id"));

				provider.setName(rs.getString("name"));

				provider.setEmail(rs.getString("email"));

				listProvider.add(provider);

			}

			return listProvider;

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			ConnectionConfiguration.db(prepStat, rs, conn);

		}
	}

	public void update(Provider provider) throws Exception {

		PreparedStatement prepStat = null;
		Connection conn = null;
		ResultSet rs = null;

		try {

			conn = br.com.ecommerceapi.database.Connection.getConnectionMySql();

			StringBuilder sql = new StringBuilder();
			sql.append(" UPDATE provider");
			sql.append(" SET name = ?, email = ?");
			sql.append(" WHERE id = ?");

			prepStat = conn.prepareStatement(sql.toString());

			prepStat.setString(1, provider.getName());

			prepStat.setString(2, provider.getEmail());

			prepStat.setInt(3, provider.getId());

			prepStat.execute();

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			ConnectionConfiguration.db(prepStat, rs, conn);

		}

	}

}
