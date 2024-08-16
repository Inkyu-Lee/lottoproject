package com.game.project.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.game.project.dto.RpsDTO;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;

@RestController
public class RpsGameController {

    @PostMapping("/api/rps/game")
    public RpsDTO getRpsGame(@RequestBody String userPick) {
        Random rand = new Random();
        String userData = userPick.replace("\"", "");
        String[] computerData = {"가위", "바위", "보"};

        String computerPick = computerData[rand.nextInt(0, 3)];

        String winner = userData.equalsIgnoreCase("가위") && computerPick.equalsIgnoreCase("보") ? "유저승리" :
                userData.equalsIgnoreCase("바위") && computerPick.equalsIgnoreCase("가위") ? "유저승리" :
                        userData.equalsIgnoreCase("보") && computerPick.equalsIgnoreCase("바위") ? "유저승리" :
                                userData.equalsIgnoreCase(computerPick) ? "무승부" : "유저패배";


        RpsDTO returnDTO = new RpsDTO(userData,computerPick,winner);

        return returnDTO;
    }
}
