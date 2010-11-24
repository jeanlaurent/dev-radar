/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.xebia.devradar.web.controller.profiles;


import java.net.URL;

import com.xebia.devradar.domain.Profile;
import com.xebia.devradar.validation.ProfileValidator;
import com.xebia.devradar.web.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.xebia.devradar.domain.Workspace;
import com.xebia.devradar.utils.Pom;
import com.xebia.devradar.utils.PomLoaderUtils;
import com.xebia.devradar.validation.WorkspaceValidator;
import com.xebia.devradar.web.WorkspaceRepository;

@Controller
@RequestMapping("/profiles/new")
@SessionAttributes("profile")
@Transactional
public class AddProfiles {

    private ProfileRepository profileRepository;

    public AddProfiles() {

    }

    @Autowired
    public AddProfiles(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String setupForm(Model model) {
        Profile profile = new Profile();
        model.addAttribute("profile", profile);
        return "profiles/form";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processSubmit(@ModelAttribute("profile") Profile profile, BindingResult result, SessionStatus status) {
        new ProfileValidator().validate(profile, result);
        if (result.hasErrors()) {
            return "profiles/form";
        } else {
            profileRepository.createProfile(profile);
            status.setComplete();
            return "redirect:/profiles/" + profile.getId()+"/edit.html";
        }
    }
}
