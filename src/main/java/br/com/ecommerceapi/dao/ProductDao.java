package br.com.ecommerceapi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.ecommerceapi.util.ConnectionConfiguration;

public class ProductDao {

	private void delete(String campaign, String table) throws Exception {

		PreparedStatement prepStat = null;

		Connection conn = null;

		ResultSet rs = null;

		try {

			conn = br.com.ecommerceapi.database.Connection.getConnectionMySql();

			StringBuilder sql = new StringBuilder();

			sql = new StringBuilder();
			sql.append(" DELETE FROM  " + table + " WHERE campaing_id = ? ");

			prepStat = conn.prepareStatement(sql.toString());

			prepStat.setString(1, campaign);

			prepStat.execute();

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			ConnectionConfiguration.db(prepStat, rs, conn);

		}

	}

	public Long saveAdset(String user, Long storeId, Long campaignId) throws Exception {
		PreparedStatement prepStat = null;

		Connection conn = null;

		ResultSet rs = null;

		try {

			conn = br.com.ecommerceapi.database.Connection.getConnectionMySql();

			StringBuilder sql = new StringBuilder();

			sql = new StringBuilder();
			sql.append(" INSERT INTO facebook_adset_imports");
			sql.append(
					" ( store_id, campaign_id, adset_id, adset_name, billing_event, bid_strategy, daily_budget, created_user, created_at)");
			sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);");

			prepStat = conn.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);

			prepStat.setLong(1, storeId);

			prepStat.setLong(2, campaignId);

			prepStat.setString(8, user);

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

	public Long getAds(FacebookDatum ads, Long storeId, Long idAdset) throws Exception {
		PreparedStatement prepStat = null;

		Connection conn = null;

		ResultSet rs = null;

		try {

			conn = br.com.ecommerceapi.database.Connection.getConnectionMySql();

			StringBuilder sql = new StringBuilder();

			sql = new StringBuilder();
			sql.append(" select id from facebook_ads_imports where store_id = ? and adset_id = ? and ads_id = ?");

			prepStat = conn.prepareStatement(sql.toString());

			prepStat.setLong(1, storeId);

			prepStat.setLong(2, idAdset);

			prepStat.setLong(3, new Long(ads.getAdsId()));

			rs = prepStat.executeQuery();

			if (rs.next()) {
				return rs.getLong("id");
			}

			return null;

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			ConnectionConfiguration.db(prepStat, rs, conn);

		}
	}

	public void updatedAdset(String user, Long idAdset) throws Exception {
		PreparedStatement prepStat = null;

		Connection conn = null;

		ResultSet rs = null;

		try {

			conn = br.com.ecommerceapi.database.Connection.getConnectionMySql();

			StringBuilder sql = new StringBuilder();

			sql = new StringBuilder();
			sql.append(
					" UPDATE facebook_adset_imports set billing_event=?, bid_strategy=?, daily_budget=?, updated_user=?, updated_at=? ");
			sql.append(" WHERE id = ?");

			prepStat = conn.prepareStatement(sql.toString());

			prepStat.setString(4, user);

			prepStat.setLong(6, idAdset);

			prepStat.execute();

		} catch (Exception e) {

			e.printStackTrace();

			throw e;

		} finally {

			ConnectionConfiguration.db(prepStat, rs, conn);

		}

	}

}
