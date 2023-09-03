package com.example.adrian_kepa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import io.micrometer.common.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class RestApi {

    @Autowired
    private ZajeciaDatabase zajeciaDatabase;

    @GetMapping("test")
    public String testApi() {
        return "test";
    }

    @PostMapping("zajecia")
    public void addNewZajecia(@RequestBody Zajecia zajecia) {
        zajeciaDatabase.addZajecia(zajecia);
    }

    @GetMapping( "zajecia")

    public List<Zajecia> getZajecia(
            @Nullable @RequestParam("name") String name,
            @Nullable @RequestParam("ECTS") Integer ECTS,
            @Nullable @RequestParam("room") Integer room,
            @Nullable @RequestParam("exam") Boolean exam) {
        List<Zajecia> filteredZajecia = zajeciaDatabase.getZajeciaList(name, ECTS, room, exam);
        return filteredZajecia;
    }

    @GetMapping("zajecia/{id}")
    public ResponseEntity<?> getZajeciaById(@PathVariable("id") Integer id) {
        Zajecia zajecia = zajeciaDatabase.getZajeciaById(id);
        if (zajecia == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(zajecia);
        }
    }


    @DeleteMapping(value = "zajecia")
    public void deleteAll() {
        zajeciaDatabase.deleteAll();
    }

    @DeleteMapping("zajecia/{id}")

    public ResponseEntity deleteById(@PathVariable("id") Integer id) {
        boolean isDeleted = zajeciaDatabase.deleteById(id);
        if (isDeleted == true) {
            return  ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
