package com.spin.game.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketModel {

    private String betCategory;

    private List<TicketRecordModel> ticketRecords;

}
