package coid.bcaf.bebootcamp.controller;



import coid.bcaf.bebootcamp.model.ListBox;
import coid.bcaf.bebootcamp.service.ListBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
                    existingListBox.setcreated_date(listBox.getcreated_date());
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
}


