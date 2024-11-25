package coid.bcaf.bebootcamp.model;


import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerID;
    private String fap;
    private String fcAkta;
    private String fcKK;
    private String fcKTP;
    private String fcPasangan;
    private String formSurvey;
    private String k3;
    private String namaKonsumen;
    private String noKontrak;
    private String noPin;
    private String petaLokasi;
    private String rekomendasi;
    private String resume;
    private String siup;
    private String tandaDaftarPerusahaan;
    private String noBox;
    private String fcPengurus;
    private String noMap;
    private String sampled;


    @Temporal(TemporalType.DATE)
    private Date tglRealisasi;

    @Temporal(TemporalType.DATE)
    private Date tglJatuhTempo;

    @Temporal(TemporalType.DATE)
    private Date tglRetensi;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getFap() {
        return fap;
    }

    public void setFap(String fap) {
        this.fap = fap;
    }

    public String getFcAkta() {
        return fcAkta;
    }

    public void setFcAkta(String fcAkta) {
        this.fcAkta = fcAkta;
    }

    public String getFcKK() {
        return fcKK;
    }

    public void setFcKK(String fcKK) {
        this.fcKK = fcKK;
    }

    public String getFcKTP() {
        return fcKTP;
    }

    public void setFcKTP(String fcKTP) {
        this.fcKTP = fcKTP;
    }

    public String getFcPasangan() {
        return fcPasangan;
    }

    public void setFcPasangan(String fcPasangan) {
        this.fcPasangan = fcPasangan;
    }

    public String getFormSurvey() {
        return formSurvey;
    }

    public void setFormSurvey(String formSurvey) {
        this.formSurvey = formSurvey;
    }

    public String getK3() {
        return k3;
    }

    public void setK3(String k3) {
        this.k3 = k3;
    }

    public String getNamaKonsumen() {
        return namaKonsumen;
    }

    public void setNamaKonsumen(String namaKonsumen) {
        this.namaKonsumen = namaKonsumen;
    }

    public String getNoKontrak() {
        return noKontrak;
    }

    public void setNoKontrak(String noKontrak) {
        this.noKontrak = noKontrak;
    }

    public String getNoPin() {
        return noPin;
    }

    public void setNoPin(String noPin) {
        this.noPin = noPin;
    }

    public String getPetaLokasi() {
        return petaLokasi;
    }

    public void setPetaLokasi(String petaLokasi) {
        this.petaLokasi = petaLokasi;
    }

    public String getRekomendasi() {
        return rekomendasi;
    }

    public void setRekomendasi(String rekomendasi) {
        this.rekomendasi = rekomendasi;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getSiup() {
        return siup;
    }

    public void setSiup(String siup) {
        this.siup = siup;
    }

    public String getTandaDaftarPerusahaan() {
        return tandaDaftarPerusahaan;
    }

    public void setTandaDaftarPerusahaan(String tandaDaftarPerusahaan) {
        this.tandaDaftarPerusahaan = tandaDaftarPerusahaan;
    }

    public Date getTglRealisasi() {
        return tglRealisasi;
    }

    public void setTglRealisasi(Date tglRealisasi) {
        this.tglRealisasi = tglRealisasi;
    }

    public Date getTglJatuhTempo() {
        return tglJatuhTempo;
    }

    public void setTglJatuhTempo(Date tglJatuhTempo) {
        this.tglJatuhTempo = tglJatuhTempo;
    }

    public Date getTglRetensi() {
        return tglRetensi;
    }

    public void setTglRetensi(Date tglRetensi) {
        this.tglRetensi = tglRetensi;
    }

    public String getNoBox() {
        return noBox;
    }

    public void setNoBox(String noBox) {
        this.noBox = noBox;
    }

    public String getFcPengurus() {
        return fcPengurus;
    }

    public void setFcPengurus(String fcPengurus) {
        this.fcPengurus = fcPengurus;
    }

    public String getNoMap() {
        return noMap;
    }

    public void setNoMap(String noMap) {
        this.noMap = noMap;
    }

    public String getSampled() {
        return sampled;
    }

    public void setSampled(String sample) {
        this.sampled = sample;
    }




}
