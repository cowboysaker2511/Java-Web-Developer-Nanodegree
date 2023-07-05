package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.entity.Credential;
import com.udacity.jwdnd.course1.cloudstorage.entity.Note;
import com.udacity.jwdnd.course1.cloudstorage.security.token.SuperDuperDriveToken;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/credential")
public class CredentialController {

    private CredentialService credentialService;

    public CredentialController(CredentialService credentialService) {
        this.credentialService = credentialService;
    }

    @PostMapping("/saveCredential")
    public String saveCredential(Model model, Credential credential, Authentication authentication) {
        SuperDuperDriveToken token = (SuperDuperDriveToken) authentication;

        credential.setUserid(token.getUserId());
        credential.setKey(token.getSalt());
        System.out.println(credential);
        if (credential.getCredentialId() == null) {
            //create credential
            credentialService.addCredential(credential);

        }
        else {
            //update credential
            credentialService.updateCredential(credential);
        }

        //get credential list
        List<Credential> credentialList = credentialService.getCredentialListByUserId(token.getUserId());
        model.addAttribute("credentialList", credentialList);

        return "home";
    }

    @PostMapping("/deleteCredential")
    public String deleteNote(Model model, Authentication authentication, Credential credential) {
        SuperDuperDriveToken token = (SuperDuperDriveToken) authentication;

        //delete credential
        credentialService.deleteCredentialByCredentialId(credential.getCredentialId());

        //get credential list
        List<Credential> credentialList = credentialService.getCredentialListByUserId(token.getUserId());
        model.addAttribute("credentialList", credentialList);

        return "home";
    }
}
