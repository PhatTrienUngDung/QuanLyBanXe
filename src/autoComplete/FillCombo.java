package autoComplete;

import connect.ConnectDB;

import java.sql.SQLException;

import javax.swing.JComboBox;

public class FillCombo {

	ConnectDB con = new ConnectDB();
	
	@SuppressWarnings("rawtypes")
	public void fill(String SQL, JComboBox combo, String column) throws SQLException {
        con.connect();
        con.executaSQL(SQL);
        try {
            combo.removeAllItems();
            con.rs.first();
            do {
                new CustomCombo(combo).custom(combo, con.rs.getString(column));
                combo.setSelectedItem(null);
            } while (con.rs.next());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //con.disconnect();
        }
    }
}
