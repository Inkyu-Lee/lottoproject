package com.game.project.api;


import com.game.project.dto.lottoDTO;
import com.game.project.entity.LottoEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;


@RestController
public class LottoController {

    @GetMapping("/api/lotto/get")
    public List<lottoDTO> getRandomLotto(){
        Set<Integer> compareList = new HashSet<Integer>();
        List<lottoDTO> lottoDTOS = new ArrayList<>();
        Random ran = new Random();

        for (int i = 0; compareList.size() < 6; i++) {
            compareList.add(ran.nextInt(1, 45));
        }
        List<Integer> lottoList = new ArrayList<Integer>(compareList);
        Collections.sort(lottoList);

        for (int i = 0; lottoList.size() > i; i++){
            lottoDTOS.add(new lottoDTO(i,lottoList.get(i).toString()));
        }

        return lottoDTOS;
    }


}
