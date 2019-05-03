package br.com.ecommerceapi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ecommerceapi.entity.Product;
import br.com.ecommerceapi.util.ConnectionConfiguration;

@Service
public class ProductDao {

	public void delete(Product product) throws Exception {

		PreparedStatement prepStat = null;
		Connection conn = null;
		ResultSet rs = null;

		try {

			conn = br.com.ecommerceapi.database.Connection.getConnectionMySql();

			StringBuilder sql = new StringBuilder();

			sql = new StringBuilder();
			sql.append(" DELETE FROM product");
			sql.append(" WHERE id = ?");

			prepStat = conn.prepareStatement(sql.toString());

			prepStat.setInt(1, product.getId());

			prepStat.execute();

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			ConnectionConfiguration.db(prepStat, rs, conn);

		}

	}

	public Long insert(Product product) throws Exception {

		PreparedStatement prepStat = null;
		Connection conn = null;
		ResultSet rs = null;

		try {

			conn = br.com.ecommerceapi.database.Connection.getConnectionMySql();

			StringBuilder sql = new StringBuilder();

			sql = new StringBuilder();
			sql.append(" INSERT INTO product");
			sql.append(" (name, cost_purchase, cost_sale, quantity)");
			sql.append(" VALUES(?, ?, ?, ?)");

			prepStat = conn.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);

			prepStat.setInt(1, product.getId());

			prepStat.setDouble(2, product.getCostPurchase());

			prepStat.setDouble(3, product.getCostSale());

			prepStat.setInt(4, product.getQuantity());

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

	public List<Product> select() throws Exception {

		PreparedStatement prepStat = null;
		Connection conn = null;
		ResultSet rs = null;

		try {

			conn = br.com.ecommerceapi.database.Connection.getConnectionMySql();

			StringBuilder sql = new StringBuilder();

			sql = new StringBuilder();
			sql.append(" SELECT id, name, cost_purchase, cost_sale, quantity");
			sql.append(" FROM product");

			prepStat = conn.prepareStatement(sql.toString());

			rs = prepStat.executeQuery();

			List<Product> listProduct = new ArrayList<Product>();

			while (rs.next()) {

				Product product = new Product();

				product.setId(rs.getInt("id"));

				product.setName(rs.getString("name"));

				product.setCostPurchase(rs.getDouble("cost_purchase"));

				product.setCostSale(rs.getDouble("cost_sale"));

				product.setQuantity(rs.getInt("quantity"));

				listProduct.add(product);

			}

			return listProduct;

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			ConnectionConfiguration.db(prepStat, rs, conn);

		}
	}

	public void update(Product product) throws Exception {

		PreparedStatement prepStat = null;
		Connection conn = null;
		ResultSet rs = null;

		try {

			conn = br.com.ecommerceapi.database.Connection.getConnectionMySql();

			StringBuilder sql = new StringBuilder();

			sql = new StringBuilder();
			sql.append(" UPDATE product");
			sql.append(" SET name = ?, cost_purchase = ?, cost_sale = ?, quantity = ?");
			sql.append(" WHERE id = ?");

			prepStat = conn.prepareStatement(sql.toString());

			prepStat.setString(1, product.getName());

			prepStat.setDouble(2, product.getCostPurchase());

			prepStat.setDouble(3, product.getCostSale());

			prepStat.setInt(4, product.getQuantity());

			prepStat.setInt(5, product.getId());

			prepStat.execute();

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			ConnectionConfiguration.db(prepStat, rs, conn);

		}

	}

}
