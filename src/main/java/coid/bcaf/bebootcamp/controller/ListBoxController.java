package coid.bcaf.bebootcamp.controller;



import coid.bcaf.bebootcamp.model.ListBox;
import coid.bcaf.bebootcamp.service.ListBoxService;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/listbox")

public class ListBoxController {

    @Autowired
    private ListBoxService listBoxService;

    @GetMapping
    public List<ListBox> getAllListBoxes() {
        return listBoxService.getAllListBoxes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListBox> getListBoxById(@PathVariable Long id) {
        Optional<ListBox> listBox = listBoxService.getListBoxById(id);
        return listBox.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ListBox createListBox(@RequestBody ListBox listBox) {
        return listBoxService.saveListBox(listBox);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListBox> updateListBox(@PathVariable Long id, @RequestBody ListBox listBox) {
        return listBoxService.getListBoxById(id)
                .map(existingListBox -> {
                    existingListBox.setno_box(listBox.getno_box());
//                    existingListBox.setCreatedDate(listBox.getcreated_date());
                    existingListBox.setapproved(listBox.getapproved());
                    existingListBox.setsampled(listBox.getsampled());
                    ListBox updatedListBox = listBoxService.saveListBox(existingListBox);
                    return ResponseEntity.ok(updatedListBox);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteListBox(@PathVariable Long id) {
        listBoxService.deleteListBox(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/update-sampled")
    public ResponseEntity<Map<String, String>> updateSampledByNoBox(
            @RequestParam String noBox, @RequestParam String sampled, @RequestParam String approved) {
        listBoxService.updateSampledByNoBox(noBox, sampled, approved);
        Map<String, String> response = new HashMap<>();
        response.put("message", "ListBox sampled column updated successfully.");
        response.put("noBox", noBox);
        response.put("sampled", sampled);
        response.put("approved", approved);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/unapproved")
    public List<ListBox> getUnapprovedListBoxes() {
        return listBoxService.getUnapprovedListBoxes();
    }








}


