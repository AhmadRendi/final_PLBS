/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import config.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.ModelMahasiswa;

/**
 *
 * @author ahmad
 */
public class MahasiswaService {
    
   public ModelMahasiswa getMahasiswaByNIM(String NIM) throws SQLException {
    String sql = "SELECT * FROM mhs WHERE NIM = ?";
    
    try (PreparedStatement st = Connect.getConnect().prepareStatement(sql)) {
        st.setString(1, NIM); // Set parameter sebelum executeQuery
        try (ResultSet rs = st.executeQuery()) {
            if (rs.next()) { // Cek apakah ada hasil
                ModelMahasiswa mhs = new ModelMahasiswa();
                mhs.setNIM(rs.getString("NIM"));
                mhs.setNama(rs.getString("nama"));
                mhs.setEmail(rs.getString("email"));
                mhs.setJurusan(rs.getString("jurusan"));
                return mhs; // Kembalikan objek mahasiswa
            } else {
                return null; // Jika data tidak ditemukan
            }
        }
    } catch (SQLException exception) {
        throw new SQLException(exception.getMessage());
    }
}
  
}
