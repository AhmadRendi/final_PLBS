/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package server.mahasiswa;

import config.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.ModelMahasiswa;

/**
 *
 * @author ahmad
 */
@WebService(serviceName = "Mahasiswa")
public class Mahasiswa {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addMahasiswa")
    public String addMahasiswa(@WebParam(name = "NIM") String NIM,
            @WebParam(name = "nama") String nama,
            @WebParam(name = "email") String email,
            @WebParam(name = "jurusan") String jurusan) {
        //TODO write your implementation code here:
        System.out.println("Masuk Ke Tambah");
        String sql = "INSERT INTO mhs(NIM, nama, email, jurusan) VALUE (?,?,?,?)";
        try(
                PreparedStatement st = Connect.getConnect().prepareStatement(sql);
                ){
            
            st.setString(1, NIM);
            st.setString(2, nama);
            st.setString(3, email);
            st.setString(4, jurusan);
            
            int isCreated  = st.executeUpdate();
            
            if(isCreated > 0){
                return "Berhasil Menambahkan";
            }
            return "Gagal Menambahkan";
        }catch (Exception exception){
            exception.printStackTrace();
            return "Gagal Menambahkan";
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateMahasiswa")
    public String updateMahasiswa(@WebParam(name = "nama") String nama,
            @WebParam(name = "email") String email,
            @WebParam(name = "NIM") String NIM,
            @WebParam(name = "jurusan") String jurusan) {
        //TODO write your implementation code here:
        
        String sql = "UPDATE mhs "
                + "SET nama = ?, email = ?, jurusan = ? "
                + "WHERE NIM = ?";
        try(
                PreparedStatement st = Connect.getConnect().prepareStatement(sql)
                ){
            
            st.setString(1, nama);
            st.setString(2, email);
            st.setString(3, jurusan);
            st.setString(4, NIM);
            
            int isCreated  = st.executeUpdate();
            
            if(isCreated > 0){
                return "Berhasil Update";
            }
            return "Gagal Update";
            
        }catch (Exception exception){
            exception.printStackTrace();
            return "Gagal Update";
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getMahasiswa")
    public List<ModelMahasiswa> getMahasiswa() {
        //TODO write your implementation code here:
        
        String sql = "SELECT * FROM mhs";
        
        try(
                PreparedStatement st = Connect.getConnect().prepareStatement(sql);
                ResultSet rs = st.executeQuery()
                ){
            List<ModelMahasiswa> listMhs = new ArrayList<>();
            while(rs.next()){
                ModelMahasiswa mhs = new ModelMahasiswa(
                        rs.getString("NIM"),
                        rs.getString("nama"),
                        rs.getString("email"),
                        rs.getString("jurusan")
                        
                );
                listMhs.add(mhs);
            }
            
            return listMhs;
        }catch (Exception exception){
            throw new RuntimeException(exception.getMessage());
        }
    }
}
