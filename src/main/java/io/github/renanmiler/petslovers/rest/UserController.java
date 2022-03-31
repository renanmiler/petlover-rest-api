package io.github.renanmiler.petslovers.rest;


import io.github.renanmiler.petslovers.model.entity.User;
import io.github.renanmiler.petslovers.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository user) {
        this.userRepository = user;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User salvar(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("{id}")
    public User findById(@PathVariable Integer id ){
        return userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @GetMapping
    public List<User> findAll(){
        return userRepository.findAll();/*.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));*/
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){

        userRepository.findById(id)
                .map(
                    user -> {userRepository.delete(user);
                    return Void.TYPE;
                    }
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("{id}")
    public void update(@PathVariable Integer id, User userAtualizado){
        userRepository.findById(id)
                .map( user -> {
                    userAtualizado.setCodPessoa(user.getCodPessoa());
                    userRepository.save(userAtualizado);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
