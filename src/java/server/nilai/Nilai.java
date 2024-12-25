/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package server.nilai;

import config.Connect;
import java.sql.PreparedStatement;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.ModelMahasiswa;
import service.EmailSender;
import service.MahasiswaService;

/**
 *
 * @author ahmad
 */
@WebService(serviceName = "Nilai")
public class Nilai {
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "inputNilai")
    public String inputNilai(@WebParam(name = "nilai") int nilai, @WebParam(name = "nim") String nim) {
        //TODO write your implementation code here:
        MahasiswaService mhsService = new MahasiswaService();
        String sql = "INSERT INTO nilai (nilai, NIM) VALUE (?,?)";
        try(
                PreparedStatement st = Connect.getConnect().prepareStatement(sql)
                ){
            st.setInt(1, nilai);
            st.setString(2, nim);
            
            ModelMahasiswa model = mhsService.getMahasiswaByNIM(nim);
            
            String email = model.getEmail();
            
            System.out.println("Email : " + email);
            
            String subject = "Pengiriman Nilai";
            
            String body = "Kepada " + model.getNama() + " Nilai anda telah diinputkan dengan Nilai " + nilai;
            
            EmailSender.sendEmail(email, subject, body);
            
            st.executeUpdate();
            return "Berhasil Menginputkan Nilai";
        }catch (Exception exception){
            System.out.println("Disini yang gagal");
            exception.printStackTrace();
            return "Gagal Menambahkan";
        }
    }

    
}
