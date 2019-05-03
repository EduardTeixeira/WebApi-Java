package br.com.ecommerceapi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ecommerceapi.entity.User;
import br.com.ecommerceapi.util.ConnectionConfiguration;

@Service
public class UserDao {

	public void delete(User user) throws Exception {

		PreparedStatement prepStat = null;
		Connection conn = null;
		ResultSet rs = null;

		try {

			conn = br.com.ecommerceapi.database.Connection.getConnectionMySql();

			StringBuilder sql = new StringBuilder();
			sql = new StringBuilder();
			sql.append(" DELETE FROM user");
			sql.append(" WHERE id = ?");

			prepStat = conn.prepareStatement(sql.toString());

			prepStat.setInt(1, user.getId());

			prepStat.execute();

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			ConnectionConfiguration.db(prepStat, rs, conn);

		}

	}

	public Long insert(User user) throws Exception {

		PreparedStatement prepStat = null;
		Connection conn = null;
		ResultSet rs = null;

		try {

			conn = br.com.ecommerceapi.database.Connection.getConnectionMySql();

			StringBuilder sql = new StringBuilder();

			sql = new StringBuilder();
			sql.append(" INSERT INTO user");
			sql.append(" (username, password)");
			sql.append(" VALUES(?, ?)");

			prepStat = conn.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);

			prepStat.setString(1, user.getUsername());

			prepStat.setString(2, user.getPassword());

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

	public List<User> select() throws Exception {

		PreparedStatement prepStat = null;
		Connection conn = null;
		ResultSet rs = null;

		try {

			conn = br.com.ecommerceapi.database.Connection.getConnectionMySql();

			StringBuilder sql = new StringBuilder();

			sql = new StringBuilder();
			sql.append(" SELECT id, username, password");
			sql.append(" FROM user");

			prepStat = conn.prepareStatement(sql.toString());

			rs = prepStat.executeQuery();

			List<User> listUser = new ArrayList<User>();

			while (rs.next()) {

				User user = new User();

				user.setId(rs.getInt("id"));

				user.setUsername(rs.getString("username"));

				user.setPassword(rs.getString("password"));

				listUser.add(user);

			}

			return listUser;

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			ConnectionConfiguration.db(prepStat, rs, conn);

		}
	}

	public void update(User user) throws Exception {

		PreparedStatement prepStat = null;
		Connection conn = null;
		ResultSet rs = null;

		try {

			conn = br.com.ecommerceapi.database.Connection.getConnectionMySql();

			StringBuilder sql = new StringBuilder();

			sql = new StringBuilder();
			sql.append(" UPDATE user");
			sql.append(" SET username = ?, password = ?");
			sql.append(" WHERE id = ?");

			prepStat = conn.prepareStatement(sql.toString());

			prepStat.setString(1, user.getUsername());

			prepStat.setString(2, user.getPassword());

			prepStat.setInt(3, user.getId());

			prepStat.execute();

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			ConnectionConfiguration.db(prepStat, rs, conn);

		}

	}

}
