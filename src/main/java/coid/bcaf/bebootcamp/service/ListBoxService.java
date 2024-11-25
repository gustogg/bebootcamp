package coid.bcaf.bebootcamp.service;


import coid.bcaf.bebootcamp.model.ListBox;
import coid.bcaf.bebootcamp.repository.ListBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListBoxService {

    @Autowired
    private ListBoxRepository listBoxRepository;

    public List<ListBox> getAllListBoxes() {
        return listBoxRepository.findAll();
    }

    public Optional<ListBox> getListBoxById(Long id) {
        return listBoxRepository.findById(id);
    }

    public ListBox saveListBox(ListBox listBox) {
        return listBoxRepository.save(listBox);
    }

    public void deleteListBox(Long id) {
        listBoxRepository.deleteById(id);
    }
}
