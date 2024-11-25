package coid.bcaf.bebootcamp.controller;



import coid.bcaf.bebootcamp.model.Customer;

import coid.bcaf.bebootcamp.repository.CustomerRepository;
import coid.bcaf.bebootcamp.repository.IDaoImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private IDaoImpl iDao;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/masterbox")
    public List<?> getNoBox(HttpServletRequest request){
        return iDao.getAll("SELECT COUNT(0) as jml ,CURRENT_TIMESTAMP as waktu, no_box FROM db_user.customer GROUP BY no_box");
    }

    @GetMapping("/data")
    public List<?> getData(HttpServletRequest request){
        return iDao.getAll("SELECT * FROM db_user.customer");
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        try {
            Customer savedCustomer = customerRepository.save(customer);
            return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") Long id) {
        try {
            customerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("details/{noBox}")
    public ResponseEntity<List<Customer>> getCustomerByNoBox(@PathVariable("noBox") String noBox) {
        try {
            List<Customer> customers = customerRepository.findAllByNoBox(noBox);
            if (customers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customerDetails) {
        return customerRepository.findById(id).map(customer -> {
            customer.setCustomerID(customerDetails.getCustomerID());
            customer.setFap(customerDetails.getFap());
            customer.setCustomerID(customerDetails.getCustomerID());
            customer.setFcAkta(customerDetails.getFcAkta());
            customer.setFcKK(customerDetails.getFcKK());
            customer.setFcKTP(customerDetails.getFcKTP());
            customer.setFcPasangan(customerDetails.getFcPasangan());
            customer.setFormSurvey(customerDetails.getFormSurvey());
            customer.setK3(customerDetails.getK3());
            customer.setNamaKonsumen(customerDetails.getNamaKonsumen());
            customer.setNoBox(customerDetails.getNoBox());
            customer.setNoKontrak(customerDetails.getNoKontrak());
            customer.setNoPin(customerDetails.getNoPin());
            customer.setPetaLokasi(customerDetails.getPetaLokasi());
            customer.setRekomendasi(customerDetails.getRekomendasi());
            customer.setResume(customerDetails.getResume());
            customer.setSiup(customerDetails.getSiup());
            customer.setTandaDaftarPerusahaan(customerDetails.getTandaDaftarPerusahaan());
            customer.setTglJatuhTempo(customerDetails.getTglJatuhTempo());
            customer.setTglRealisasi(customerDetails.getTglRealisasi());
            customer.setTglRetensi(customerDetails.getTglRetensi());
            customer.setFcPengurus(customerDetails.getFcPengurus());
            customer.setNoMap(customerDetails.getNoMap());
            customer.setSampled(customerDetails.getSampled());


            Customer updatedCustomer = customerRepository.save(customer);
            return ResponseEntity.ok(updatedCustomer);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
