/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ahmad
 */
public class ModelMahasiswa {
    
    private String NIM;
    
    private String nama;
    
    private String email;
    
    private String jurusan;

    public ModelMahasiswa() {
    }

    public ModelMahasiswa(String NIM, String nama, String email, String jurusan) {
        this.NIM = NIM;
        this.nama = nama;
        this.email = email;
        this.jurusan = jurusan;
    }

    public String getNIM() {
        return NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    @Override
    public String toString() {
        return "Mahasiswa{" + "NIM=" + NIM + ", nama=" + nama + ", email=" + email + ", jurusan=" + jurusan + '}';
    }
    
}
