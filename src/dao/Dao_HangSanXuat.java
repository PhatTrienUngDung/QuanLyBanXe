package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import connect.ConnectDB;

public class Dao_HangSanXuat {


	public void getListHSX(String tenXe, JComboBox comboBox) {
		Connection con = ConnectDB.getCon();
		String sql = "select DISTINCT HangSanXuat.tenHangSanXuat from Xe, HangSanXuat where Xe.maHangSanXuat=HangSanXuat.maHangSanXuat and tenXe = ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, tenXe);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				comboBox.addItem(rs.getString(1));
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
			e1.printStackTrace();
		}
	}
}
