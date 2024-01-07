package pdcgbbn.learn.spring_boot_with_database.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pdcgbbn.learn.spring_boot_with_database.domain.User;
import pdcgbbn.learn.spring_boot_with_database.repository.UserRepo;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepo userRepo;

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return userRepo.save(user);
    }
}
