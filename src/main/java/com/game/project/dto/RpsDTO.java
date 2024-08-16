package com.game.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RpsDTO {

    private String userData;
    private String computerPick;
    private String whoWin;

}
