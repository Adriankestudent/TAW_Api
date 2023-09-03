package com.example.adrian_kepa;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class ZajeciaDatabase {

    private List<Zajecia> zajeciaList = new ArrayList<>();

    private int zajeciaCounter = 1;
    public void addZajecia(Zajecia element) {

        element.setId(zajeciaCounter);
        zajeciaList.add(element);
        zajeciaCounter++;
    }

    public Zajecia getZajeciaById(Integer id) {
        for (Zajecia element : zajeciaList) {
            if (element.getId().equals(id)){
                return element;
            }
        }
        return null;
    }

    public List<Zajecia> getZajeciaList(String name, Integer ECTS, Integer room, Boolean exam) {
        List<Zajecia> filteredZajecia = new ArrayList<>();
        for (Zajecia element : zajeciaList) {
            boolean matchesFilters = true;
            if (name != null && !element.getName().equals(name)) {
                matchesFilters = false;
            }
            if (ECTS != null && !element.getECTS().equals(ECTS)) {
                matchesFilters = false;
            }
            if (room != null && !element.getRoom().equals(room)) {
                matchesFilters = false;
            }
            if (exam != null && !element.getExam().equals(exam)) {
                matchesFilters = false;
            }
            if (matchesFilters) {
                filteredZajecia.add(element);
            }
        }
        return filteredZajecia;
    }


    public void deleteAll() {
        zajeciaList.clear();
    }

    public boolean deleteById(Integer id) {
        Zajecia toDelete = null;
        for (Zajecia element : zajeciaList) {
            if (element.getId().equals(id)) {
                toDelete = element;
            }
        }
        return zajeciaList.remove(toDelete);
    }
}
