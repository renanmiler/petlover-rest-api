package io.github.renanmiler.petslovers.rest;


import io.github.renanmiler.petslovers.model.entity.Pets;
import io.github.renanmiler.petslovers.model.entity.User;
import io.github.renanmiler.petslovers.model.repository.PetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/pets")
@CrossOrigin("*")
public class PetsController {

    @Autowired
    private PetsRepository petsRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pets salvar(@RequestBody Pets pets){
        return petsRepository.save(pets);
    }

    @GetMapping("{id}")
    public Pets findById(@PathVariable Integer id ){
        return petsRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @GetMapping
    public List<Pets> findAll(){
        return petsRepository.findAll();/*.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));*/
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){

        petsRepository.findById(id)
                .map(
                        pets -> {petsRepository.delete(pets);
                            return Void.TYPE;
                        }
                ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("{id}")
    public void update(@PathVariable Integer id, Pets petsAtualizado){
        petsRepository.findById(id)
                .map( pets -> {
                    petsAtualizado.setCod_pet(pets.getCod_pet());
                    petsRepository.save(petsAtualizado);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
