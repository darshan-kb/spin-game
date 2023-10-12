package com.spin.game.controller;

import com.spin.game.dto.ClaimDTO;
import com.spin.game.payloads.MessagePayload;
import com.spin.game.payloads.RedeemClaimPayload;
import com.spin.game.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class ClaimController {
    @Autowired
    private ClaimService claimService;
    @GetMapping("/api/claims")
    public ResponseEntity<List<ClaimDTO>> getClaim(Principal p){
        return new ResponseEntity(claimService.getClaim(p.getName()), HttpStatus.OK);
    }

    @PostMapping("/api/claims")
    public ResponseEntity<Double> claimReward(@RequestBody RedeemClaimPayload redeemClaimPayload, Principal p){
        return new ResponseEntity<>(claimService.redeemClaim(redeemClaimPayload.getClaimId(),p.getName()),HttpStatus.OK);
    }
}
