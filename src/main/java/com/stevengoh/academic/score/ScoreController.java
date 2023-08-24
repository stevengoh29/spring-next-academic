package com.stevengoh.academic.score;

import com.stevengoh.academic.score.model.RegisterScore;
import com.stevengoh.academic.utils.CustomResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("api/v1/score")
public class ScoreController {

    private final ScoreService scoreService;

//    @GetMapping
//    public ResponseEntity<CustomResponse<?>> getScoreByUsername (@RequestParam("username") String username) {
//        return scoreService.getScoreByUsername(username);
//    }

    @GetMapping("/getByTerm")
    public void getScoreByTerm () {

    }

    /*@PostMapping
    public ResponseEntity<CustomResponse<?>> registerScoreByUsername (@RequestBody RegisterScore registerScore) {
        return scoreService.registerScoreByUsername(registerScore);
    }*/
}
